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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.juego.view.tablero.BotonDisparo;
import main.juego.view.tablero.BotonDisparoConvencional;
import main.juego.view.tablero.BotonDobleConRetardo;
import main.juego.view.tablero.BotonPorContacto;
import main.juego.view.tablero.BotonPuntualConRetardo;
import main.juego.view.tablero.BotonTripleConRetardo;
import main.juego.view.tablero.SuperficiePanelListener;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
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
import main.view.juego.DibujablesList;
import main.view.naves.VistaNave;
import main.view.tablero.BotonCelda;
import main.view.tablero.VistaTablero;
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

	private static JFrame frame;
	private static GameLoop gameLoop;
	private static DibujablesList objetosDibujables;
	private static JPanel panelControlesNorte;
	private static JButton btnIniciar;
	private static JButton btnReiniciar;
	private static Disparo disparoAcolocar;
	
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
					initialize();
					frame.setVisible(true);
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
	private static void initialize() throws IOException {
		Tablero tablero = Tablero.getTablero();
		Jugador jugador = new Jugador();
		objetosDibujables = new DibujablesList();
		frame = new JFrame("Batalla Navalgo");
		frame.setBounds(0, 0, 800, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel bottom = new JPanel();
        bottom.setLayout(null);
		
		SuperficiePanel panel = new SuperficiePanel();
		SuperficiePanelListener mouseListener = new SuperficiePanelListener();
		panel.addMouseListener(mouseListener);
		panel.setLocation(0, 0);
		panel.setSize(600,600);
		
		bottom.add(panel);
		
		JPanel panelControles = new JPanel();
		panelControles.setLayout(null);
		panelControles.setLocation(600, 0);
		panelControles.setSize(200,630);
		panelControles.setBackground(Color.GRAY);
		bottom.add(panelControles);
			
		panelControlesNorte = new JPanel();
		panelControles.setLayout(null);
		panelControlesNorte.setLocation(0, 0);
		panelControlesNorte.setSize(200,200);
		panelControlesNorte.setBackground(Color.GRAY);
		
		btnIniciar = new JButton("Iniciar");
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
		panelControlesSur.setSize(200,430);
		panelControlesSur.setBackground(Color.GRAY);

		
		JButton botonDispConv = new BotonDisparoConvencional(disparoAcolocar, mouseListener);
		botonDispConv.setBackground(Color.BLACK);
		panelControlesSur.add(botonDispConv);
		JButton botonPuntualRet = new BotonPuntualConRetardo(disparoAcolocar, mouseListener);
		botonPuntualRet.setBackground(Color.BLACK);
		panelControlesSur.add(botonPuntualRet);
		JButton botonDobleRet = new BotonDobleConRetardo(disparoAcolocar, mouseListener);
		botonDobleRet.setBackground(Color.BLACK);
		panelControlesSur.add(botonDobleRet);
		JButton botonTripleRet = new BotonTripleConRetardo(disparoAcolocar, mouseListener);
		botonTripleRet.setBackground(Color.BLACK);
		panelControlesSur.add(botonTripleRet);
		JButton botonPorContacto = new BotonPorContacto(disparoAcolocar, mouseListener);
		botonPorContacto.setBackground(Color.BLACK);
		panelControlesSur.add(botonPorContacto);
			
		panelControles.add(panelControlesSur);

		bottom.setOpaque(true);
		frame.getContentPane().add(bottom);
		gameLoop = new GameLoop(1000,panel);
		gameLoop.agregar(jugador);
		gameLoop.agregar(tablero);
		gameLoop.agregar(objetosDibujables);
		Imagen imagen = new VistaTablero(new URL("file:./images/tablero.PNG"), Tablero.getTablero());
		objetosDibujables.agregar(imagen);
		gameLoop.agregarObservador(new Observador());
		colocarBarcosEnTablero();
		mouseListener.setGameLoop(gameLoop);
		tablero.setGameLoop(gameLoop);
	}
	
	/**
	 * Crea y coloca todos las naves en el Tablero.
	 */
	private static void colocarBarcosEnTablero() {
		colocarLanchas();
		colocarDestructores();
		colocarBuques();
		colocarPortaAviones();
		colocarRompeHielos();
	}

	/**
	 * Crea y coloca todas las lanchas en el Tablero.
	 */
	private static void colocarLanchas() {
		for (int i = 0; i < CANT_LANCHAS; i++) {
			Coordenada coordenada = crearCoordenada(2);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave lancha = new Lancha(coordenada, sentido, movimiento);
			for (Parte parte : lancha.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(lancha);
			}
			gameLoop.agregar(lancha);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/naves/lanchav.jpg"), lancha);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/naves/lancha.jpg"), lancha);
				}
				objetosDibujables.agregar(imagen);
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
	private static void colocarDestructores() {
		for (int i = 0; i < CANT_DESTRUCTORES; i++) {
			Coordenada coordenada = crearCoordenada(3);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave destructor = new Destructor(coordenada, sentido, movimiento);
			for (Parte parte : destructor.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(destructor);
			}
			gameLoop.agregar(destructor);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/naves/destructorv.jpg"), destructor);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/naves/destructor.jpg"), destructor);
				}
				objetosDibujables.agregar(imagen);
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
	private static void colocarBuques() {
		for (int i = 0; i < CANT_BUQUES; i++) {
			Coordenada coordenada = crearCoordenada(4);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave buque = new Buque(coordenada, sentido, movimiento);
			for (Parte parte : buque.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(buque);
			}
			gameLoop.agregar(buque);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/naves/buquev.jpg"), buque);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/naves/buque.jpg"), buque);
				}
				objetosDibujables.agregar(imagen);
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
	private static void colocarPortaAviones() {
		for (int i = 0; i < CANT_PORTA_AVIONES; i++) {
			Coordenada coordenada = crearCoordenada(5);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave portaAviones = new Portaaviones(coordenada, sentido, movimiento);
			for (Parte parte : portaAviones.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(portaAviones);
			}
			gameLoop.agregar(portaAviones);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/naves/portaavionv.jpg"), portaAviones);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/naves/portaavion.jpg"), portaAviones);
				}
				objetosDibujables.agregar(imagen);
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
	private static void colocarRompeHielos() {
		for (int i = 0; i < CANT_ROMPE_HIELOS; i++) {
			Coordenada coordenada = crearCoordenada(3);
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
			for (Parte parte : rompeHielos.getPartes()) {
				Tablero.getTablero().getCasilleros()[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(rompeHielos);
			}
			gameLoop.agregar(rompeHielos);
			try {
				Imagen imagen;
				if (sentido.equals(DireccionSentido.VERTICAL)){
					imagen = new VistaNave(new URL("file:./images/naves/rompehielosv.jpg"), rompeHielos);
				}
				else {
					imagen = new VistaNave(new URL("file:./images/naves/rompehielos.jpg"), rompeHielos);
				}
				objetosDibujables.agregar(imagen);
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
	
	public static void finalizarJuego() {
		panelControlesNorte.remove(btnIniciar);
		panelControlesNorte = new JPanel();
		panelControlesNorte.setLocation(0, 0);
		panelControlesNorte.setSize(650,200);
		panelControlesNorte.setBackground(Color.GRAY);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setLocation(0, 0);
		btnReiniciar.setSize(50, 50);
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		panelControlesNorte.add(btnReiniciar);
		if (!Jugador.tienePuntos()) {
			JOptionPane.showMessageDialog(frame, "El jugador perdio");
		} else {
			JOptionPane.showMessageDialog(frame, "El jugador ganó");
		}
		gameLoop.detenerEjecucion();
	}
}
