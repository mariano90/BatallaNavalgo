package main.juego;

public class Jugador {
	private Integer puntuacion;
	final Integer PUNTAJE_INICIAL = 10000;
	
	public Jugador() {
		this.puntuacion = PUNTAJE_INICIAL;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void restarPuntos (Integer puntos){
		if ((this.puntuacion != 0) && (puntos>0)){
			this.puntuacion = this.puntuacion - puntos;
		}
	}
}
