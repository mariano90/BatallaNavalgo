package main.model.disparos;

/**
 * Representa a una Mina Submarina por Contacto.
 *
 * @author mariano.sanchez
 */
public class PorContacto extends MinaSubmarina{
	
	protected final Integer COSTO = 150;
	protected final Integer RADIO = 0;

	/**
	 * Constructor por defecto.
	 */
	public PorContacto(){
		this.costo = COSTO;
		this.radio = RADIO;
	}
	
}
