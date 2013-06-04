package main.model.disparos;

/**
 * Representa un Disparo Doble con Retardo.
 * 
 * @author mariano.sanchez
 */
public class DobleConRetardo extends MinaSubmarina{

	protected final Integer COSTO = 100;
	protected final Integer RADIO = 1;
	protected final Integer CANTIDAD_TURNOS = 3;
	
	/**
	 * Constructor por defecto.
	 */
	public DobleConRetardo(){
		this.costo = COSTO;
		this.radio = RADIO;
		this.cantTurnos = CANTIDAD_TURNOS;
	}
	
}
