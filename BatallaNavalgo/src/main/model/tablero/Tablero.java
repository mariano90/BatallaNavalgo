package main.model.tablero;

/**
 * Representa el Tablero de juego.
 * 
 * @author daniel.pilla
 */
public class Tablero {

	/*
	 * Declaracion de constantes
	 */
	private final int FILAS_TABLERO = 10;
	private final int COLUMNAS_TABLERO = 10;

	/**
	 * Matriz de Casilleros.
	 */
	private Casillero[][] casilleros;

	/**
	 * Constructor por defecto. Instancia un Tablero con sus Casilleros y Coordenadas.
	 */
	public Tablero () {
		casilleros = new Casillero[FILAS_TABLERO][COLUMNAS_TABLERO];
		crearCoordenadas();
	}

	/**
	 * Crea y asigna las coordenadas a los Casilleros del tablero.
	 */
	private void crearCoordenadas() {
		for (int fila = 0; fila < FILAS_TABLERO; fila++) {
			for(int columna = 0; columna < COLUMNAS_TABLERO; columna++) {
				Coordenada coordenada = new Coordenada(fila, columna);
				casilleros[fila][columna] = new Casillero(coordenada);
			}
		}
	}

	/**
	 * Devuelve la matriz de Casilleros del Tablero.
	 *
	 * @return casilleros Matriz de Casilleros.
	 */
	public Casillero[][] getCasilleros() {
		return casilleros;
	}
}
