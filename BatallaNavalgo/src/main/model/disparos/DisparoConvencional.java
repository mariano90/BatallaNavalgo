package main.model.disparos;

import main.model.tablero.Coordenada;

/**
 * Representa un Disparo Convencional.
 *
 * @author mariano.sanchez
 */
public class DisparoConvencional extends Disparo{
	
	protected final Integer COSTO = 200;
	protected final Integer RADIO = 0;
	protected final Integer CANTIDAD_TURNOS = 1;

	/**
	 * Constructor por defecto.
	 */
	public DisparoConvencional(Coordenada coordenada){
		this.coordenada = coordenada;
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}

}
