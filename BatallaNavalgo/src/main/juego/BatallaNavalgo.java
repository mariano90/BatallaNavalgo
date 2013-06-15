package main.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import main.juego.view.naves.VistaNave;
import main.juego.view.naves.VistaParte;
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
		{DireccionSentido.HORIZONTAL, DireccionSentido.VERTICAL};
	private final static DireccionMovimiento movimientosNave[] =
		{DireccionMovimiento.ESTE, DireccionMovimiento.NORESTE, 
		DireccionMovimiento.NOROESTE, DireccionMovimiento.NORTE,
		DireccionMovimiento.OESTE, DireccionMovimiento.SUR,
		DireccionMovimiento.SURESTE, DireccionMovimiento.SUROESTE};

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
		Jugador jugador = new Jugador();
		Tablero tablero = new Tablero();
		

		frame = new JFrame();
		
//		frame.setForeground(new Color(0, 0, 0));
//		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
//		JButton btnIniciar = new JButton("Iniciar");
//		btnIniciar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				gameLoop.iniciarEjecucion();
//			}
//		});
//		btnIniciar.setBounds(42, 16, 77, 25);
//		frame.getContentPane().add(btnIniciar);
		frame.setSize(300, 400);
		FondoPanel panelFondo = new FondoPanel("/home/mariano/lancha.jpg");
		frame.getContentPane().add(panelFondo);
//		JPanel panel = new SuperficiePanel();
//		panel.setBackground(new Color(0, 0, 0));
//		panel.setBounds(0, 0, 600, 600);
//		frame.getContentPane().add(panel);

//		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
//		this.colocarBarcosEnTablero(tablero);
		
//		jugar(jugador, tablero);
//		verResultado(jugador, tablero);
	}
	
	private static void jugar(Jugador jugador, Tablero tablero){
		while(jugador.getPuntuacion() > 0 && tablero.tieneBarcosNoDestruidos()){
//			jugador.restarPuntos(PUNTOS_POR_TURNO);
			// FALTA QUE MANDEN LAS CLASES QUE DIJERON PARA IMPLEMENTAR LOS TURNOS 
			
		}
	}
	
	private static void verResultado(Jugador jugador,Tablero tablero){
		if(tablero.tieneBarcosNoDestruidos()){
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
	 * 
	 * @param tablero El Tablero sobre el cual se van a colocar las naves. No puede ser nulo.
	 */
	private void colocarBarcosEnTablero(Tablero tablero) {
		this.colocarLanchas(tablero);
//		this.colocarDestructores(tablero);
//		this.colocarBuques(tablero);
//		this.colocarPortaAviones(tablero);
//		this.colocarRompeHielos(tablero);
	}

	/**
	 * Crea y coloca todas las lanchas en el Tablero.
	 * 
	 * @param tablero El tablero sobre el cual se van a colocar las lanchas. No puede ser nulo.
	 */
	private void colocarLanchas(Tablero tablero) {
		System.out.println("CARGANDO LANCHAS");
		for (int i = 0; i < CANT_LANCHAS; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave lancha = new Lancha(coordenada, sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(lancha);
			this.gameLoop.agregar(lancha);
			try {
				Imagen imagen = new VistaNave(new URL("file:/home/mariano/lancha.jpg"), lancha);
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
	 * 
	 * @param tablero El tablero sobre el cual se van a colocar los destructores. No puede ser nulo.
	 */
	private void colocarDestructores(Tablero tablero) {
		for (int i = 0; i < CANT_DESTRUCTORES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave destructor = new Destructor(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(destructor);
			this.gameLoop.agregar(destructor);
		}
	}

	/**
	 * Crea y coloca todos los buques en el Tablero.
	 * 
	 * @param tablero El tablero sobre el cual se van a colocar los buques. No puede ser nulo.
	 */
	private void colocarBuques(Tablero tablero) {
		for (int i = 0; i < CANT_BUQUES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave buque = new Buque(coordenada, sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(buque);
			this.gameLoop.agregar(buque);
		}
	}

	/**
	 * Crea y coloca todos los porta aviones en el Tablero.
	 * 
	 * @param tablero El tablero sobre el cual se van a colocar los porta aviones. No puede ser nulo.
	 */
	private void colocarPortaAviones(Tablero tablero) {
		for (int i = 0; i < CANT_PORTA_AVIONES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave portaAviones = new Portaaviones(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
					.agregarNave(portaAviones);
			this.gameLoop.agregar(portaAviones);
		}
	}

	/**
	 * Crea y coloca todos los rompe hielos en el Tablero.
	 * 
	 * @param tablero El tablero sobre el cual se van a colocar los rompe hielos. No puede ser nulo.
	 */
	private void colocarRompeHielos(Tablero tablero) {
		for (int i = 0; i < CANT_ROMPE_HIELOS; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Nave rompeHielos = new RompeHielos(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(rompeHielos);
			this.gameLoop.agregar(rompeHielos);
		}
	}

	/**
	 * Crea una coordenada con valores aleatorios entre 0-9 de X e Y.
	 * 
	 * @return Coordenada La coordenada aleatoria donde se ubica el principio de una nave.
	 */
	private static Coordenada crearCoordenada() {
		Integer fila = (int) (Math.random() * 10);
		Integer columna = (int) (Math.random() * 10);
		return new Coordenada(fila, columna);
	}

	/**
	 * Devuelve el sentido de la nave aleatorio.
	 * 
	 * @return DireccionSentido Valor aleatorio de sentido de ubicacion de la nave.
	 */
	private static DireccionSentido getSentidoRandom() {
		return sentidosNave[(int)(Math.random()*1)];
	}

	/**
	 * Devuelve una direccion de movimiento aleatoria.
	 * 
	 * @return DireccionMovimiento Valor aleatorio de direccion de movimiento de la nave.
	 */
	private static DireccionMovimiento getMovimientoRandom() {
		return movimientosNave[(int)(Math.random()*8)];
	}
}
