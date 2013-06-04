package main.model.disparos;

import main.model.naves.Nave;
import main.model.naves.Parte;
import main.model.tablero.Coordenada;

/**
 * Clase Abstracta que representa un Disparo.
 * 
 * @author mariano.sanchez
 */
public abstract class Disparo {

	protected Coordenada coordenada;
	
	/**
	 * Numero entero que indica el costo de cada disparo. Se debe redefinir en las subclases.
	 */
	protected Integer costo = 0;

	/**
	 * Numero entero que indica el radio de alcance de cada disparo. Se debe redefinir en las subclases.
	 */
	protected Integer radio = 0;
	
	/**
	 * Numero entero que indica la cantidad de turnos de cada disparo antes de ser ejecutado.
	 * Se debe redefinir en las subclases.
	 */
	protected Integer cantTurnos = 0;
	
	/**
	 * Realiza un disparo.
	 */
	public void disparar(){
		
	}

	public void accionarMina(Nave nave, Parte parte){
		nave.recibirDisparo(this, parte);
	}
	
	public boolean debeExplotar(Parte parte){
		this.cantTurnos = cantTurnos -1;
		if(this.cantTurnos <= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve el costo de un disparo.
	 * 
	 * @return Numero entero indicando costo del disparo.
	 */
	public Integer getCosto() {
		return costo;
	}

	/**
	 * Devuelve el radio de alcance de un disparo.
	 * 
	 * @return Numero entero indicando el radio de alcance del disparo.
	 */
	public Integer getRadio() {
		return radio;
	}

	/**
	 * Devuelve la cantidad de turnos restantes de un disparo.
	 * 
	 * @return Numero entero indicando la cantidad de turnos restantes del disparo.
	 */
	public Integer getCantTurnos() {
		return cantTurnos;
	}
	
}
