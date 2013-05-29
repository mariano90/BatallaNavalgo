package main.juego;

import main.model.naves.Buque;
import main.model.naves.Destructor;
import main.model.naves.Lancha;
import main.model.naves.Nave;
import main.model.naves.Portaaviones;
import main.model.naves.RompeHielos;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;
import main.model.naves.EnumDirecciones;

public class BatallaNavalgo {

	private final static Integer CANT_LANCHAS = 2;
	private final static Integer CANT_DESTRUCTORES = 2;
	private final static Integer CANT_BUQUES = 1;
	private final static Integer CANT_PORTA_AVIONES = 1;
	private final static Integer CANT_ROMPE_HIELOS = 1;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		colocarBarcosEnTablero(tablero);
	}

	private static void colocarBarcosEnTablero(Tablero tablero) {
		for (int i = 0; i < CANT_LANCHAS; i++) {
			Coordenada coordenada = crearCoordenada();
			Lancha lancha = new Lancha();
		}
		for (int i = 0; i < CANT_DESTRUCTORES; i++) {
			Coordenada coordenada = crearCoordenada();
			Destructor destructor = new Destructor();
		}
		for (int i = 0; i < CANT_BUQUES; i++) {
			Coordenada coordenada = crearCoordenada();
			Buque buque = new Buque();
		}
		for (int i = 0; i < CANT_PORTA_AVIONES; i++) {
			Coordenada coordenada = crearCoordenada();
			Portaaviones portaAviones = new Portaaviones();
		}
		for (int i = 0; i < CANT_ROMPE_HIELOS; i++) {
			Coordenada coordenada = crearCoordenada();
			RompeHielos rompeHielos = new RompeHielos();
		}
	}

	private static Coordenada crearCoordenada() {
		Integer fila = (int) (Math.random() * 10);
		Integer columna = (int) (Math.random() * 10);
		return new Coordenada(fila, columna);
	}
}
