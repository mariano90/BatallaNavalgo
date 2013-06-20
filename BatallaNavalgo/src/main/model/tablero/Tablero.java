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
				this.verificarCasillero(casillero);
			}
		}
	}
	
	private void verificarCasillero(Casillero casillero){
		ArrayList<Disparo> disparosRealizados = new ArrayList<Disparo>();
		for (Disparo disparo : casillero.getDisparos()) {
			if (disparo.debeExplotar()) {
				System.out.println("DISPARO DEBE EXPLOTAR");
				ArrayList<Nave> naves = this.buscarNaves(casillero, disparo.getRadio());
				ArrayList<Coordenada> coordenadas = this.buscarCoordenadas(casillero.getCoordenada(), disparo.getRadio());
				for (Nave nave : naves) {
					for (Parte parte : nave.getPartes()) {
						if (!parte.estaDestruida() && coordenadas.contains((parte.getPosicion()))) {
							System.out.println("ACCIONAR MINA");
							disparo.accionarMina(nave, parte);
						}
					}
				}
				disparosRealizados.add(disparo);
			}
		}
		this.eliminarDisparos(disparosRealizados,casillero);
	}
	
	private void eliminarDisparos(ArrayList<Disparo> disparosRealizados, Casillero casillero) {
		for (Disparo disparo : disparosRealizados) {
			casillero.getDisparos().remove(disparo);
		}
	}
	
	private ArrayList<Nave> buscarNaves(Casillero casillero, Integer radio){
		Integer x = casillero.getCoordenada().getX();
		Integer y = casillero.getCoordenada().getY();
		ArrayList<Nave> naves = new ArrayList<Nave>();
		naves.addAll(casillero.getNaves());
		if (radio == 0) return naves;
		for (int i = 1; i < radio+1; i++) {
			if (x-i >= 0){
				naves.addAll(this.casilleros[x-i][y].getNaves());
				for (int j = 1; j < radio+1; j++) {
					if (y-j >= 0) naves.addAll(this.casilleros[x-i][y-j].getNaves());
					if (y+j <= FILAS_TABLERO-1) naves.addAll(this.casilleros[x-i][y+j].getNaves());
				}
			}
			if (x+i <= COLUMNAS_TABLERO-1){
				for (int j = 1; j < radio+1; j++) {
					if (y-j >= 0) naves.addAll(this.casilleros[x+i][y-j].getNaves());
					if (y+j <= FILAS_TABLERO-1) naves.addAll(this.casilleros[x+i][y+j].getNaves());					
				}
			}
		}
		for (int j = 1; j < radio+1; j++) {
			if (y-j >= 0) naves.addAll(this.casilleros[x][y-j].getNaves());
			if (y+j <= FILAS_TABLERO-1) naves.addAll(this.casilleros[x][y+j].getNaves());					
		}
		return naves;
	}
	
	private ArrayList<Coordenada> buscarCoordenadas(Coordenada coordenada, Integer radio){
		Integer x = coordenada.getX();
		Integer y = coordenada.getY();
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(coordenada);
		if (radio == 0) return coordenadas;
		for (int i = 1; i < radio+1; i++) {
			if (x-i >= 0){
				coordenadas.add(new Coordenada(x-i, y));
				for (int j = 1; j < radio+1; j++) {
					if (y-j >= 0) coordenadas.add(new Coordenada(x-i, y-j));
					if (y+j <= FILAS_TABLERO-1) coordenadas.add(new Coordenada(x-i, y+j));
				}
			}
			if (x+i <= COLUMNAS_TABLERO-1){
				for (int j = 1; j < radio+1; j++) {
					if (y-j >= 0) coordenadas.add(new Coordenada(x+i, y-j));
					if (y+j <= FILAS_TABLERO-1) coordenadas.add(new Coordenada(x+i, y+j));					
				}
			}
		}
		for (int j = 1; j < radio+1; j++) {
			if (y-j >= 0) coordenadas.add(new Coordenada(x, y-j));
			if (y+j <= FILAS_TABLERO-1) coordenadas.add(new Coordenada(x, y+j));					
		}
		return coordenadas;
	}

}
