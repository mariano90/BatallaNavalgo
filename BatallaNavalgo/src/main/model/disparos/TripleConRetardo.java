package main.model.disparos;

import main.model.tablero.Coordenada;

/**
 * Representa una Mina Submarina Triple con Retardo.
 *
 * @author mariano.sanchez
 */
public class TripleConRetardo extends MinaSubmarina{
	
	protected final Integer COSTO = 125;
	protected final Integer RADIO = 2;
	protected final Integer CANTIDAD_TURNOS = 3;
	
	public TripleConRetardo(Coordenada coordenada){
		this.coordenada = coordenada;
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}

}
