package main.juego;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;

/**
 * Representa a un Jugador del juego BatallaNavalgo.
 * 
 * @author melisa.poleschi
 */
public class Jugador implements ObjetoVivo{

	/*
	 * Definicion de constantes.
	 */
	private final Integer PUNTAJE_INICIAL = 10000;

	public static Jugador jugador;
	public boolean pusoDisparo;
	
	/**
	 * Numero entero que indica la puntuacion del jugador.
	 */
	private static Integer puntuacion;
	
	/**
	 * Booleano que indica si el jugador gano el juego o no.
	 */	
	private boolean gano;

	/**
	 * Constructor por defecto.
	 */
	public Jugador() {
		puntuacion = PUNTAJE_INICIAL;
	}
	
	public static Jugador getJugador() {
		if (jugador == null) {
			jugador = new Jugador();
		}
		return jugador;
	}

	/**
	 * Devuelve la puntuacion del jugador.
	 * 
	 * @return puntuacion Entero que indica la puntuacion del jugador.
	 */
	public Integer getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Resta una X cantidad de puntos a la puntuacion del jugador
	 * 
	 * @param puntos Puntos a restar. Debe ser mayor a 0.
	 */
	public void restarPuntos (Integer puntos){
		if ((puntuacion != 0) && (puntos>0)){
			if ((puntuacion - puntos) > 0){
				puntuacion = puntuacion - puntos;
			}
			else {
				puntuacion = 0;
			}
		}
	}

	public boolean isGano() {
		return gano;
	}

	public void setGano(boolean gano) {
		this.gano = gano;
	}

	@Override
	public void vivir() {
		this.restarPuntos(10);
		this.pusoDisparo = false;
	}
	
	public static boolean tienePuntos() {
		if (puntuacion >= 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPusoDisparo() {
		return pusoDisparo;
	}

	public void setPusoDisparo(boolean pusoDisparo) {
		this.pusoDisparo = pusoDisparo;
	}
	
}
