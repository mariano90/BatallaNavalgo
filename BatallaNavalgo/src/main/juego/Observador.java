package main.juego;

import main.model.tablero.Tablero;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class Observador implements ObservadorDeGameLoop{

	@Override
	public void notificarCicloFinalizado() {
		if (!Jugador.tienePuntos() || !Tablero.getTablero().tieneBarcosNoDestruidos()) {
			BatallaNavalgo.finalizarJuego();
		}
	}

}
