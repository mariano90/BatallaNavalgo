package main.model.disparos;

import main.model.tablero.Coordenada;

/**
 * Representa una Mina Submarina Puntual con Retardo
 *
 * @author mariano.sanchez
 */
public class PuntualConRetardo extends MinaSubmarina{

	protected final Integer COSTO = 50;
	protected final Integer RADIO = 0;
	protected final Integer CANTIDAD_TURNOS = 3;
	
	/**
	 * Constructor por defecto.
	 */
	public PuntualConRetardo(){
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}
	
	public PuntualConRetardo(Coordenada coordenada){
		this.coordenada = coordenada;
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}
	
}
