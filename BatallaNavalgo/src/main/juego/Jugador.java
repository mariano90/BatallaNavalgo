package main.juego;

/**
 * Representa a un Jugador del juego BatallaNavalgo.
 * 
 * @author melisa.poleschi
 */
public class Jugador {

	/*
	 * Definicion de constantes.
	 */
	private final Integer PUNTAJE_INICIAL = 10000;

	/**
	 * Numero entero que indica la puntuacion del jugador.
	 */
	private Integer puntuacion;

	/**
	 * Constructor por defecto.
	 */
	public Jugador() {
		this.puntuacion = PUNTAJE_INICIAL;
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
		if ((this.puntuacion != 0) && (puntos>0)){
			this.puntuacion = this.puntuacion - puntos;
		}
	}
}
