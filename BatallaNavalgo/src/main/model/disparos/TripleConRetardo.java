package main.model.disparos;

/**
 * Representa una Mina Submarina Triple con Retardo.
 *
 * @author mariano.sanchez
 */
public class TripleConRetardo extends MinaSubmarina{
	
	protected final Integer COSTO = 125;
	protected final Integer RADIO = 2;
	protected final Integer CANTIDAD_TURNOS = 3;
	
	public TripleConRetardo(){
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}

}
