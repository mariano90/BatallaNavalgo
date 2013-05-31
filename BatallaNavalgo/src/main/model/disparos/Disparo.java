package main.model.disparos;

/**
 * Clase Abstracta que representa un Disparo.
 * 
 * @author mariano.sanchez
 */
public abstract class Disparo {

	/**
	 * Numero entero que indica el costo de cada disparo. Se debe redefinir en las subclases.
	 */
	protected Integer costo;

	/**
	 * Numero entero que indica el radio de alcance de cada disparo. Se debe redefinir en las subclases.
	 */
	protected Integer radio;
//	protected Integer cantTurnos;

	/**
	 * Realiza un disparo.
	 */
	public void disparar(){
		
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
}
