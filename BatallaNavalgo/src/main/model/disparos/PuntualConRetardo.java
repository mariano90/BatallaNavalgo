package main.model.disparos;

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
}
