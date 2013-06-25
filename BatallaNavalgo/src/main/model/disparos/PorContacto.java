package main.model.disparos;

import main.model.tablero.Casillero;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;

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

	public PorContacto(Coordenada coordenada){
		this.coordenada = coordenada;
		this.costo = COSTO;
		this.radio = RADIO;
	}
	
	@Override
	public boolean debeExplotar() {
		Casillero casillero = Tablero.getTablero().getCasilleros()[this.coordenada.getX()][this.coordenada.getY()];
		if (casillero.getNaves().size() > 0) {
			return true;
		}
		return false;
	}
}
