package main.juego;

import java.awt.EventQueue;
import java.io.IOException;

import main.model.tablero.Tablero;

/**
 * Clase principal del Juego BatallaNavalgo.
 * Se encarga de manejar la l�gica del juego.
 * 
 * @author daniel.pilla
 */
public class BatallaNavalgo {
	
	private static IniciadorDeJuego iniciador;
	
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
				iniciarJuego();
			}
		});
	}
	
	public static void finalizarJuego() {
		iniciador.finalizarJuego();
	}
	
	public static void iniciarJuego() {
		iniciador = new IniciadorDeJuego();
		try {
			iniciador.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reiniciarJuego() {
		Tablero.reiniciarTablero();
		iniciarJuego();
	}
}
	
