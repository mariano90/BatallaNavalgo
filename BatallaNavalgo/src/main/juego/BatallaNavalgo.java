package main.juego;

import main.model.naves.Buque;
import main.model.naves.Destructor;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
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
	
	private final static DireccionSentido sentidosNave[] = 
		{DireccionSentido.HORIZONTAL, DireccionSentido.VERTICAL};
	private final static DireccionMovimiento movimientosNave[] =
		{DireccionMovimiento.ESTE, DireccionMovimiento.NORESTE, 
		DireccionMovimiento.NOROESTE, DireccionMovimiento.NORTE,
		DireccionMovimiento.OESTE, DireccionMovimiento.SUR,
		DireccionMovimiento.SURESTE, DireccionMovimiento.SUROESTE};

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		colocarBarcosEnTablero(tablero);
	}

	private static void colocarBarcosEnTablero(Tablero tablero) {
		colocarLanchas(tablero);
		colocarDestructores(tablero);
		colocarBuques(tablero);
		colocarPortaAviones(tablero);
		colocarRompeHielos(tablero);
	}

	private static void colocarLanchas(Tablero tablero) {
		for (int i = 0; i < CANT_LANCHAS; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Lancha lancha = new Lancha(coordenada, sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(lancha);
		}
	}

	private static void colocarDestructores(Tablero tablero) {
		for (int i = 0; i < CANT_DESTRUCTORES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Destructor destructor = new Destructor(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(destructor);
		}
	}

	private static void colocarBuques(Tablero tablero) {
		for (int i = 0; i < CANT_BUQUES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Buque buque = new Buque(coordenada, sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(buque);
		}
	}

	private static void colocarPortaAviones(Tablero tablero) {
		for (int i = 0; i < CANT_PORTA_AVIONES; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			Portaaviones portaAviones = new Portaaviones(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
					.agregarNave(portaAviones);
		}
	}

	private static void colocarRompeHielos(Tablero tablero) {
		for (int i = 0; i < CANT_ROMPE_HIELOS; i++) {
			Coordenada coordenada = crearCoordenada();
			DireccionSentido sentido = getSentidoRandom();
			DireccionMovimiento movimiento = getMovimientoRandom();
			RompeHielos rompeHielos = new RompeHielos(coordenada,
				sentido, movimiento);
			tablero.getCasilleros()[coordenada.getX()][coordenada.getY()]
				.agregarNave(rompeHielos);
		}
	}

	private static Coordenada crearCoordenada() {
		Integer fila = (int) (Math.random() * 10);
		Integer columna = (int) (Math.random() * 10);
		return new Coordenada(fila, columna);
	}

	private static DireccionSentido getSentidoRandom() {
		return sentidosNave[(int)(Math.random()*1)];
	}

	private static DireccionMovimiento getMovimientoRandom() {
		return movimientosNave[(int)(Math.random()*8)];
	}
}
