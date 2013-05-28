package main.model.tablero;

public class Tablero {

	final int FILAS_TABLERO = 10;
	final int COLUMNAS_TABLERO = 10;
	private Casillero[][] casilleros;

	public Tablero () {
		casilleros = new Casillero[FILAS_TABLERO][COLUMNAS_TABLERO];
		crearCoordenadas();
	}

	private void crearCoordenadas() {
		for (int fila = 0; fila < FILAS_TABLERO; fila++) {
			for(int columna = 0; columna < COLUMNAS_TABLERO; columna++) {
				casilleros[fila][columna].agregarCoordenada(fila, columna);
			}
		}
	}

	public Casillero[][] getCasilleros() {
		return casilleros;
	}
}
