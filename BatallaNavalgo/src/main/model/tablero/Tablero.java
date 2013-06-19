package main.model.tablero;

import java.util.ArrayList;
import java.util.List;

import main.model.disparos.Disparo;
import main.model.naves.Nave;
import main.model.naves.Parte;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

/**
 * Representa el Tablero de juego.
 * 
 * @author daniel.pilla
 */
public class Tablero implements ObjetoVivo, ObjetoPosicionable{

	/*
	 * Declaracion de constantes
	 */
	private final int FILAS_TABLERO = 10;
	private final int COLUMNAS_TABLERO = 10;
	private static Tablero tablero;

	/**
	 * Matriz de Casilleros.
	 */
	private Casillero[][] casilleros;

	/**
	 * Constructor por defecto. Instancia un Tablero con sus Casilleros y Coordenadas.
	 */
	private Tablero () {
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
	 * Devuelve True si el Tablero tiene barcos aun sin destruir.
	 * 
	 * @return boolean
	 */
	public boolean tieneBarcosNoDestruidos(){
		for (int fila = 0; fila < FILAS_TABLERO; fila++) {
			for(int columna = 0; columna < COLUMNAS_TABLERO; columna++) {
				if(!casilleros[fila][columna].tieneBarcosNoDestruidos()) return true; 
			}
		}
		return false;
	}
	
	public static Tablero getTablero() {
		if (tablero == null) {
			tablero = new Tablero();
		}
		return tablero;
	}
	
	public void removerNave (Nave nave) {
		for (Parte parte : nave.getPartes()) {
			casilleros[parte.getPosicion().getX()][parte.getPosicion().getY()].removerNave(nave);
		}
	}
	
	public void reubicarNave (Nave nave) {
		for (Parte parte : nave.getPartes()) {
			casilleros[parte.getPosicion().getX()][parte.getPosicion().getY()].agregarNave(nave);
		}
	}
	
	public void agregarDisparo(Disparo disparo) {
		casilleros[disparo.getCoordenada().getY()][disparo.getCoordenada().getX()].agregarDisparo(disparo);
	}
	
	/**
	 * Devuelve la matriz de Casilleros del Tablero.
	 *
	 * @return casilleros Matriz de Casilleros.
	 */
	public Casillero[][] getCasilleros() {
		return casilleros;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public void vivir() {
		System.out.println("VIVE EL TABLERO");
		for (Casillero[] filas : casilleros) {
			for(Casillero casillero : filas) {
				ArrayList<Disparo> disparosEfectivos = new ArrayList<Disparo>();
				for (Disparo disparo : casillero.getDisparos()) {
					if (disparo.debeExplotar()) {
						System.out.println("DISPARO DEBE EXPLOTAR");
						for (Nave nave : casillero.getNaves()) {
							for (Parte parte : nave.getPartes()) {
								if (!parte.estaDestruida() && casillero.getCoordenada().equals(parte.getPosicion())) {
									System.out.println("ACCIONAR MINA");
									disparo.accionarMina(nave, parte);
								}
								disparosEfectivos.add(disparo);
							}
						}
					}
				}
				eliminarDisparos(disparosEfectivos,casillero);
			}
		}
	}
	
	private void eliminarDisparos(ArrayList<Disparo> disparosEfectivos, Casillero casillero) {
		for (Disparo disparo : disparosEfectivos) {
			casillero.getDisparos().remove(disparo);
		}
	}
	
	private void buscarPartes(Coordenada coordenada, Integer radio){
		Integer x = coordenada.getX();
		Integer y = coordenada.getY();
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(coordenada);
		for (int i = 1; i < radio+1; i++) {
			if(x-i >= 0){
				Coordenada coordenadaRadiox = new Coordenada(x-i, y); 
				coordenadas.add(coordenadaRadiox);
				if(y-i >=0){
					Coordenada coordenadaRadioy = new Coordenada(x-i, y-i); 
					coordenadas.add(coordenadaRadioy);
				}
			}
			
		}
	}

}
