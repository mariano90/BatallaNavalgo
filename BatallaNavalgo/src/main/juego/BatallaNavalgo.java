package main.juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.juego.view.naves.VistaNave;
import main.juego.view.tablero.BotonCelda;
import main.juego.view.tablero.VistaTablero;
import main.model.disparos.DobleConRetardo;
import main.model.naves.Buque;
import main.model.naves.Destructor;
import main.model.naves.Lancha;
import main.model.naves.Nave;
import main.model.naves.Parte;
import main.model.naves.Portaaviones;
import main.model.naves.RompeHielos;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;

/**
 * Clase principal del Juego BatallaNavalgo.
 * Se encarga de manejar la l�gica del juego.
 * 
 * @author daniel.pilla
 */
public class BatallaNavalgo {

	/*
	 * Definicion de constantes.
	 */
	private final static Integer PUNTOS_POR_TURNO = 10;
	private final static Integer CANT_LANCHAS = 2;
	private final static Integer CANT_DESTRUCTORES = 2;
	private final static Integer CANT_BUQUES = 1;
	private final static Integer CANT_PORTA_AVIONES = 1;
	private final static Integer CANT_ROMPE_HIELOS = 1;
	
	private final static DireccionSentido sentidosNave[] = 
		{DireccionSentido.VERTICAL};
	private final static DireccionMovimiento movimientosNave[] =
		{DireccionMovimiento.ESTE,DireccionMovimiento.OESTE,DireccionMovimiento.NORTE, DireccionMovimiento.SUR,
		DireccionMovimiento.NORESTE, DireccionMovimiento.SURESTE, DireccionMovimiento.SUROESTE,
		DireccionMovimiento.NOROESTE};
	
	private JFrame frame;
	private GameLoop gameLoop;
	
	/**
	 * Metodo principal del Programa. Inicia un Tablero, un Jugador,
	 * coloca los barcos de la maquina y controla el flujo de los turnos del juego.
	 * 
	 * @param args Array de Strings con atributos recibidos por consola.
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatallaNavalgo window = new BatallaNavalgo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BatallaNavalgo() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Tablero tablero = Tablero.getTablero();
		
		frame = new JFrame("Batalla Navalgo");
		frame.setBounds(0, 0, 1050, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel bottom = new JPanel();
        bottom.setLayout(null);
		
		SuperficiePanel panel = new SuperficiePanel();
		panel.setLocation(0, 0);
		panel.setSize(630,630);
		
		bottom.add(panel);
		
		JPanel panelControles = new JPanel();
		panelControles.setLayout(null);
		panelControles.setLocation(640, 0);
		panelControles.setSize(410,630);
		panelControles.setBackground(Color.CYAN);
		bottom.add(panelControles);
		
		JPanel panelControlesNorte = new JPanel();
		panelControles.setLayout(null);
		panelControlesNorte.setLocation(0, 0);
		panelControlesNorte.setSize(410,200);
		panelControlesNorte.setBackground(Color.CYAN);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setLocation(0, 0);
		btnIniciar.setSize(50, 50);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		panelControlesNorte.add(btnIniciar);
		panelControles.add(panelControlesNorte);
		
		
		JPanel panelControlesSur = new JPanel();
		panelControles.setLayout(null);
		panelControlesSur.setLocation(0, 200);
		panelControlesSur.setSize(410,430);
		panelControlesSur.setBackground(Color.CYAN);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton boton = new BotonCelda(new Coordenada(i, j));
				boton.setBackground(Color.RED);
				boton.setLocation(15+i*5, 15+j*5);
				boton.setSize(5, 5);
				panelControlesSur.add(boton);
			}
		}
			
		panelControles.add(panelControlesSur);

		bottom.setOpaque(true);
		frame.getContentPane().add(bottom);
		this.gameLoop = new GameLoop(700,panel);
		Imagen imagen = new VistaTablero(new URL("file:./images/tablero.PNG"), Tablero.getTablero());
		gameLoop.agregar(imagen);
		this.colocarBarcosEnTablero();
//		this.colocarMinasEnTablero();
		gameLoop.agregar(tablero);
//		jugar(jugador, tablero);
//		verResultado(jugador, tablero);
	}
	
	public void colocarMinasEnTablero() {
		for (int i= 0; i<5; i++) {
			Integer fila = (int) (Math.random() * 10);
			Integer columna = (int) (Math.random() * 10);
			Coordenada coordenada = new Coordenada(fila, columna);
			DobleConRetardo mina = new DobleConRetardo(coordenada);
			Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()].agregarDisparo(mina);
		}
	}
	
	private static void jugar(Jugador jugador){
		while(jugador.getPuntuacion() > 0 && Tablero.getTablero().tieneBarcosNoDestruidos()){
//			jugador.restarPuntos(PUNTOS_POR_TURNO);
			// FALTA QUE MANDEN LAS CLASES QUE DIJERON PARA IMPLEMENTAR LOS TURNOS 
			
		}
	}
	
	private static void verResultado(Jugador jugador){
		if(Tablero.getTablero().tieneBarcosNoDestruidos()){
			jugador.setGano(false);
			System.out.println("El jugador perdio");
		}
		else {
			jugador.setGano(true);
			System.out.println("El jugador gano");
		}
	}
	
	/**
	 * Crea y coloca todos las naves en el Tablero.
	 */
	private void colocarBarcosEnTablero() {
		this.colocarLanchas();
		this.colocarDestructores();
		this.colocarBuques();
		this.colocarPortaAviones();
		this.colocarRompeHielos();
	}

	/**
	 * Crea y coloca todas las lanchas en el Tablero.
	 */
	private void colocarLanchas() {
		for (int i = 0; i < CANT_LANCHAS; i++) {
			Coordenada coordenada = crearCoordenada(2);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave lancha = new Lancha(coordenada, sentido, movimiento);
			for (Parte parte : lancha.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(lancha);
			}
			this.gameLoop.agregar(lancha);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/lanchav.jpg"), lancha);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/lancha.jpg"), lancha);
				}
				this.gameLoop.agregar(imagen);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Crea y coloca todos los destructores en el Tablero.
	 */
	private void colocarDestructores() {
		for (int i = 0; i < CANT_DESTRUCTORES; i++) {
			Coordenada coordenada = crearCoordenada(3);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave destructor = new Destructor(coordenada, sentido, movimiento);
			for (Parte parte : destructor.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(destructor);
			}
			this.gameLoop.agregar(destructor);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/destructorv.jpg"), destructor);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/destructor.jpg"), destructor);
				}
				this.gameLoop.agregar(imagen);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea y coloca todos los buques en el Tablero.
	 */
	private void colocarBuques() {
		for (int i = 0; i < CANT_BUQUES; i++) {
			Coordenada coordenada = crearCoordenada(4);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave buque = new Buque(coordenada, sentido, movimiento);
			for (Parte parte : buque.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(buque);
			}
			this.gameLoop.agregar(buque);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/buquev.jpg"), buque);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/buque.jpg"), buque);
				}
				this.gameLoop.agregar(imagen);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * Crea y coloca todos los porta aviones en el Tablero.
	 */
	private void colocarPortaAviones() {
		for (int i = 0; i < CANT_PORTA_AVIONES; i++) {
			Coordenada coordenada = crearCoordenada(5);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave portaAviones = new Portaaviones(coordenada, sentido, movimiento);
			for (Parte parte : portaAviones.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(portaAviones);
			}
			this.gameLoop.agregar(portaAviones);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/portaavionv.jpg"), portaAviones);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/portaavion.jpg"), portaAviones);
				}
				this.gameLoop.agregar(imagen);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea y coloca todos los rompe hielos en el Tablero.
	 */
	private void colocarRompeHielos() {
		for (int i = 0; i < CANT_ROMPE_HIELOS; i++) {
			Coordenada coordenada = crearCoordenada(3);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
			for (Parte parte : rompeHielos.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(rompeHielos);
			}
			this.gameLoop.agregar(rompeHielos);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/rompehielosv.jpg"), rompeHielos);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/rompehielos.jpg"), rompeHielos);
				}
				this.gameLoop.agregar(imagen);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea una coordenada con valores aleatorios entre 0-9 de X e Y.
	 * 
	 * @return Coordenada La coordenada aleatoria donde se ubica el principio de una nave.
	 */
	private static Coordenada crearCoordenada(Integer cantPartes) {
		Integer fila = (int) (Math.random() * (10-cantPartes));
		Integer columna = (int) (Math.random() * (10-cantPartes));
		return new Coordenada(fila, columna);
	}

	/**
	 * Devuelve el sentido de la nave aleatorio.
	 * 
	 * @return DireccionSentido Valor aleatorio de sentido de ubicacion de la nave.
	 */
	private static DireccionSentido getSentidoRandom() {
		return sentidosNave[(int)(Math.random()*0)];
	}

	/**
	 * Devuelve una direccion de movimiento aleatoria.
	 * 
	 * @return DireccionMovimiento Valor aleatorio de direccion de movimiento de la nave.
	 */
	private static DireccionMovimiento getMovimientoRandom() {
		return movimientosNave[(int)(Math.random()*7)];
	}
}
