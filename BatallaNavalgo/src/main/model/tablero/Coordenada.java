package main.model.tablero;

/**
 * Representa una Coordenada dentro de un Tablero.
 * 
 * @author daniel.pilla
 */
public class Coordenada {

	/**
	 * Posicion en x.
	 */
	private int x;

	/**
	 * Posicion en y.
	 */
	private int y;

	/**
	 * Crea una instancia de Coordenada con valores de X e Y.
	 *
	 * @param x Posicion sobre el eje X.
	 * @param y Posicion sobre el eje Y.
	 */
	public Coordenada (int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object a){
		Coordenada coordenada = (Coordenada) a;
		if(this.x == coordenada.getX() && this.y == coordenada.getY()){
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve la posicion sobre el eje X.
	 * 
	 * @return x Posicion en X.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Devuelve la posicion sobre el eje Y.
	 * 
	 * @return y Posicion en Y.
	 */
	public int getY() {
		return y;
	}
}
