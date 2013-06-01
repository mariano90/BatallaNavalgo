package main.model.tablero;

import java.util.ArrayList;
import main.model.disparos.Disparo;
import main.model.naves.Nave;

/**
 * Representa un casillero de un Tablero.
 * 
 * @author daniel.pilla
 */
public class Casillero {

	/**
	 * Lista de Naves que posee el casillero.
	 */
	private ArrayList<Nave> naves;

	/**
	 * Lista de Disparos que se efectuaron sobre el casillero.
	 */
	private ArrayList<Disparo> disparos;

	/**
	 * Coordenada del casillero.
	 */
	private Coordenada coordenada;

	/**
	 * Crea un nuevo casillero ubicado en la coordenada recibida por parametro.
	 * 
	 * @param laCoordenada Coordenada donde se ubica el casillero. No puede ser nulo.
	 */
	public Casillero (Coordenada laCoordenada) {
		naves = new ArrayList<Nave> ();
		disparos = new ArrayList<Disparo> ();
		coordenada = laCoordenada;
	}

	/**
	 * Agrega una Nave a la lista de naves que se encuentran en el casillero.
	 * 
	 * @param laNave Nave a agregar en el casillero. No puede ser nulo.
	 */
	public void agregarNave(Nave laNave) {
		naves.add(laNave);
	}

	/**
	 * Agrega un Disparo a la lista de disparos que se efectuan sobre el casillero.
	 * 
	 * @param elDisparo Disparo a agregar en el casillero. No puede ser nulo.
	 */
	public void agregarDisparo(Disparo elDisparo) {
		disparos.add(elDisparo);
	}

	/**
	 * Devuelve True si el casillero tiene barcos aun sin destruir.
	 * 
	 * @return boolean
	 */
	public boolean tieneBarcosNoDestruidos(){
		for (Nave nave : this.naves) {
			if(!nave.estaDestruida()) return true;
		}
		return false;
	}
	
	/**
	 * Devuelve las naves que se encuentran en el casillero.
	 * 
	 * @return naves Una ArrayList con las naves que se encuentran en el casillero.
	 */
	public ArrayList<Nave> getNaves() {
		return naves;
	}

	/**
	 * Devuelve los disparos que se efectuan en el casillero.
	 * 
	 * @return disparos Una ArrayList con los disparos que se efectuan en el casillero.
	 */
	public ArrayList<Disparo> getDisparos() {
		return disparos;
	}

	/**
	 * Devuelve la coordenada del casillero.
	 * 
	 * @return coordenada La Coordenada donde se ubica el casillero.
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
}
