package main.model.naves;

import java.util.ArrayList;

import main.model.disparos.Disparo;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

/**
 * Clase Abstracta que representa una Nave.
 * 
 * @author melisa.poleschi
 */
public abstract class Nave {

	/**
	 * Indica la direccion de movimiento de la nave.
	 */
	protected DireccionMovimiento direccionMovimiento;

	/**
	 * Indica el sentido hacia donde apunta la nave.
	 */
	protected DireccionSentido direccionSentido;

	/**
	 * Lista con las Partes de una Nave.
	 */
	protected ArrayList<Parte> partes;

	/**
	 * Realiza el movimiento de la Nave.
	 */
	public void moverse(){
	}

	/**
	 * Crea las partes de una Nave en las coordenadas correspondientes.
	 *
	 * @param coordenadaInicio Coordenada de inicio de la Nave. No puede ser nulo.
	 * @param cantPartes Cantidad de partes que posee la nave. Mayor a 0.
	 */
	protected void agregarPartes(Coordenada coordenadaInicio, Integer cantPartes){
		Coordenada coordenada = coordenadaInicio;
		for (int i = 0; i < cantPartes; i++) {
			this.agregarParte(coordenada);
			coordenada = this.obtenerSiguienteCoordenada(coordenada);
		}
	}

	/**
	 * Agrega una nueva Parte de una nave en una Coordenada.
	 *
	 * @param coordenada Coordenada donde se debe colocar la nueva Parte. No puede ser nulo.
	 */
	protected void agregarParte(Coordenada coordenada){
		Parte parte = new Parte(coordenada);
		this.partes.add(parte);
	}

	/**
	 * Devuelve la coordenada siguiente a la recibida por parametro.
	 *
	 * @param coordenada Coordenada de la cual se quiere obtener su siguiente. No puede ser nulo.
	 *
	 * @return Coordenada La Coordenada siguiente a la pasada por parametro.
	 */
	protected Coordenada obtenerSiguienteCoordenada(Coordenada coordenada){
		Coordenada nuevaCoordenada;
		if (this.direccionSentido == DireccionSentido.HORIZONTAL){
			nuevaCoordenada = new Coordenada(coordenada.getX() + 1, coordenada.getY());
		}
		else {
			nuevaCoordenada = new Coordenada(coordenada.getX(), coordenada.getY() + 1);
		}
		return nuevaCoordenada;
	}

	/**
	 * Devuelve True si la nave esta destruida. False en caso contrario.
	 *
	 * @return True si esta destruida. False en caso contrario. 
	 */
	public boolean estaDestruida(){
		boolean naveDestruida;
		for (Parte parte : this.partes) {
			naveDestruida = parte.estaDestruida();
			if (!naveDestruida) return false;			
		}
		return true;
	}

	public void recibirDisparo(Disparo disparo, Parte parte){
		parte.recibirDisparo();
		parte.destruir();
	}
	
	public void recibirDisparoDeMinaSubmarina(Disparo disparo, Parte parte) {
		parte.recibirDisparo();
		parte.destruir();
	}
	
	/**
	 * Devuelve la direccion de movimiento de la nave.
	 *
	 * @return direccionMovimiento Direccion de movimiento de la nave.
	 */
	public DireccionMovimiento getDireccionMovimiento() {
		return direccionMovimiento;
	}

	public void setDireccionMovimiento(DireccionMovimiento direccionMovimiento) {
		this.direccionMovimiento = direccionMovimiento;
	}

	public DireccionSentido getDireccionSentido() {
		return direccionSentido;
	}

	public void setDireccionSentido(DireccionSentido direccionSentido) {
		this.direccionSentido = direccionSentido;
	}

	public ArrayList<Parte> getPartes() {
		return partes;
	}
	
}
