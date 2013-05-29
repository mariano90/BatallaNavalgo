package main.juego;

public class Jugador {
	private Integer puntuacion;
	
	public Jugador() {
		this.puntuacion = 10000;
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
