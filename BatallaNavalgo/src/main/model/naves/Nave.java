package main.model.naves;

import java.util.ArrayList;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

import main.model.disparos.Disparo;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;

/**
 * Clase Abstracta que representa una Nave.
 * 
 * @author melisa.poleschi
 */
public abstract class Nave implements ObjetoVivo, ObjetoPosicionable {
	
	private final Integer MARGEN_IZQUIERDO = 0;
	private final Integer MARGEN_DERECHO = 9;
	private final Integer MARGEN_SUPERIOR = 0;
	private final Integer MARGEN_INFERIOR = 9;

	/**
	 * Indica la coordenanda donde empieza la nave.
	 */
	protected Coordenada coordenadaInicio;
	
	/**
	 * Indica la direccion de movimiento de la nave.
	 */
	protected DireccionMovimiento direccionMovimiento;

	/**
	 * Indica el sentido hacia donde apunta la nave.
	 */
	protected DireccionSentido direccionSentido;

	/**
	 * Lista con las Partes de una Nave.
	 */
	protected ArrayList<Parte> partes;

	/**
	 * Realiza el movimiento de la Nave.
	 */
	public void moverse() {
		Tablero.getTablero().removerNave(this);
		for (Parte parte : partes) {
			Integer x = parte.getPosicion().getX();
			Integer y = parte.getPosicion().getY();
			if (direccionMovimiento == DireccionMovimiento.ESTE) {
				y = this.moverseAlEste(y);
			} else if (direccionMovimiento == DireccionMovimiento.OESTE) {
				y = this.moverseAlOeste(y);
			} else if (direccionMovimiento == DireccionMovimiento.SUR) {
				x = this.moverseAlSur(x);
			} else if (direccionMovimiento == DireccionMovimiento.NORTE) {
				x = this.moverseAlNorte(x);
			} else {
				Coordenada nuevaPosicion;
				if (direccionMovimiento == DireccionMovimiento.NORESTE) {
					nuevaPosicion = this.moverseAlNoreste(x,y);
				} else if (direccionMovimiento == DireccionMovimiento.NOROESTE) {
					nuevaPosicion = this.moverseAlNoroeste(x,y);
				} else if (direccionMovimiento == DireccionMovimiento.SUROESTE) {
					nuevaPosicion = this.moverseAlSuroeste(x,y);
				} else {
					nuevaPosicion = this.moverseAlSureste(x,y);
				}
				x = nuevaPosicion.getX();
				y = nuevaPosicion.getY();
			}
			parte.setPosicion(x,y);
			this.coordenadaInicio = new Coordenada(x,y);
		}
		Tablero.getTablero().reubicarNave(this);
	}

	private Integer moverseAlOeste(Integer y) {
		if (y == MARGEN_IZQUIERDO) {
			y++;
			direccionMovimiento = DireccionMovimiento.ESTE;
		} else {
			y--;
		}
		return y;
	}

	private Integer moverseAlEste(Integer y) {
		if (y == MARGEN_DERECHO) {
			y--;
			direccionMovimiento = DireccionMovimiento.OESTE;
		} else {
			y++;
		}
		return y;
	}

	private Integer moverseAlSur(Integer x) {
		if (x == MARGEN_INFERIOR) {
			x--;
			direccionMovimiento = DireccionMovimiento.NORTE;
		} else {
			x++;
		}
		return x;
	}

	private Integer moverseAlNorte(Integer x) {
		if (x == MARGEN_SUPERIOR) {
			x++;
			direccionMovimiento = DireccionMovimiento.SUR;
		} else {
			x--;
		}
		return x;
	}

	private Coordenada moverseAlNoreste(Integer x, Integer y) {
		if ((x == MARGEN_SUPERIOR) || (y == MARGEN_DERECHO)) {
			x++;
			y--;
			direccionMovimiento = DireccionMovimiento.SUROESTE;
		} else {
			y++;
			x--;
		}
		return new Coordenada(x,y);
	}

	private Coordenada moverseAlNoroeste(Integer x, Integer y) {
		if ((x == MARGEN_SUPERIOR) || (y == MARGEN_IZQUIERDO)) {
			x++;
			y++;
			direccionMovimiento = DireccionMovimiento.SURESTE;
		} else {
			x--;
			y--;
		}
		return new Coordenada(x,y);
	}

	private Coordenada moverseAlSureste(Integer x, Integer y) {
		if ((x == MARGEN_INFERIOR) || (y == MARGEN_DERECHO)) {
			direccionMovimiento = DireccionMovimiento.NOROESTE;
			x--;
			y--;
		} else {
			x++;
			y++;
		}
		return new Coordenada(x,y);
	}

	private Coordenada moverseAlSuroeste(Integer x, Integer y) {
		if ((x == MARGEN_INFERIOR) || (y == MARGEN_IZQUIERDO)) {
			x--;
			y++;
			direccionMovimiento = DireccionMovimiento.NORESTE;
		} else {
			x++;
			y--;
		}
		return new Coordenada(x,y);
	}

	/**
	 * Crea las partes de una Nave en las coordenadas correspondientes.
	 *
	 * @param coordenadaInicio Coordenada de inicio de la Nave. No puede ser nulo.
	 * @param cantPartes Cantidad de partes que posee la nave. Mayor a 0.
	 */
	protected void agregarPartes(Coordenada coordenadaInicio, Integer cantPartes){
		Coordenada coordenada = coordenadaInicio;
		for (int i = 0; i < cantPartes; i++) {
			this.agregarParte(coordenada);
			coordenada = this.obtenerSiguienteCoordenada(coordenada);
		}
	}

	/**
	 * Agrega una nueva Parte de una nave en una Coordenada.
	 *
	 * @param coordenada Coordenada donde se debe colocar la nueva Parte. No puede ser nulo.
	 */
	protected void agregarParte(Coordenada coordenada){
		Parte parte = new Parte(coordenada);
		this.partes.add(parte);
	}

	/**
	 * Devuelve la coordenada siguiente a la recibida por parametro.
	 *
	 * @param coordenada Coordenada de la cual se quiere obtener su siguiente. No puede ser nulo.
	 *
	 * @return Coordenada La Coordenada siguiente a la pasada por parametro.
	 */
	protected Coordenada obtenerSiguienteCoordenada(Coordenada coordenada){
		Coordenada nuevaCoordenada;
		if (this.direccionSentido == DireccionSentido.HORIZONTAL){
			nuevaCoordenada = new Coordenada(coordenada.getX(), coordenada.getY() + 1);
		}
		else {
			nuevaCoordenada = new Coordenada(coordenada.getX() + 1, coordenada.getY());
		}
		return nuevaCoordenada;
	}

	/**
	 * Devuelve True si la nave esta destruida. False en caso contrario.
	 *
	 * @return True si esta destruida. False en caso contrario. 
	 */
	public boolean estaDestruida(){
		for (Parte parte : this.partes) {
			if (!parte.estaDestruida()) return false;			
		}
		return true;
	}

	public void recibirDisparo(Disparo disparo, Parte parte){
		parte.recibirDisparo();
		parte.destruir();
	}
	
	public void recibirDisparoDeMinaSubmarina(Disparo disparo, Parte parte) {
		parte.recibirDisparo();
		parte.destruir();
	}
	
	@Override
	public void vivir() {
		System.out.println("VIVE LA NAVE");
		this.moverse();
	}

	@Override
	public int getX() {
		return 10;
	}

	@Override
	public int getY() {
		return 10;
	}
	
	/**
	 * Devuelve la direccion de movimiento de la nave.
	 *
	 * @return direccionMovimiento Direccion de movimiento de la nave.
	 */
	public DireccionMovimiento getDireccionMovimiento() {
		return direccionMovimiento;
	}

	public void setDireccionMovimiento(DireccionMovimiento direccionMovimiento) {
		this.direccionMovimiento = direccionMovimiento;
	}

	public DireccionSentido getDireccionSentido() {
		return direccionSentido;
	}

	public void setDireccionSentido(DireccionSentido direccionSentido) {
		this.direccionSentido = direccionSentido;
	}

	public ArrayList<Parte> getPartes() {
		return partes;
	}
}
