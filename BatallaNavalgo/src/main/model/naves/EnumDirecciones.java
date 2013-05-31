package main.model.naves;

/**
 * Representa direcciones de movimiento y/o sentido de las naves.
 * 
 * @author melisa.poleschi
 */
public class EnumDirecciones {
	
	public enum DireccionMovimiento {
		NORTE,
		SUR,
		ESTE,
		OESTE,
		NORESTE,
		NOROESTE,
		SURESTE,
		SUROESTE
	}

	public enum DireccionSentido {
		VERTICAL,
		HORIZONTAL
	}
}
