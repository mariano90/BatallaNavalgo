package main.model.disparos;

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
	public DisparoConvencional(){
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}
}
