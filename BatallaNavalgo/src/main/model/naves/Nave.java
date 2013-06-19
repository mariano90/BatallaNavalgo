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
		ArrayList<Parte> partesFinal = new ArrayList<Parte>();
		for (Parte parte : partes) {
			Coordenada posicionInicial = parte.getPosicion();
			Coordenada posicionFinal;
			if (direccionMovimiento == DireccionMovimiento.ESTE) {
				posicionFinal = this.moverseAlEste(posicionInicial);
			} else if (direccionMovimiento == DireccionMovimiento.OESTE) {
				posicionFinal = this.moverseAlOeste(posicionInicial);
			} else if (direccionMovimiento == DireccionMovimiento.SUR) {
				posicionFinal = this.moverseAlSur(posicionInicial);
			} else //if (direccionMovimiento == DireccionMovimiento.NORTE) {
				posicionFinal = this.moverseAlNorte(posicionInicial);
			/*} else if (direccionMovimiento == DireccionMovimiento.NORESTE) {
				posicionFinal = this.moverseAlNoreste(posicionInicial);
			} else if (direccionMovimiento == DireccionMovimiento.NOROESTE) {
				posicionFinal = this.moverseAlNoroeste(posicionInicial);
			} else if (direccionMovimiento == DireccionMovimiento.SUROESTE) {
				posicionFinal = this.moverseAlSuroeste(posicionInicial);				
			} else {
				posicionFinal = this.moverseAlSureste(posicionInicial);
			} */
			parte.setPosicion(posicionFinal);
			partesFinal.add(parte);
		}
		partes = partesFinal;
		Tablero.getTablero().reubicarNave(this);
	}

	private Coordenada moverseAlOeste(Coordenada posicionInicial) {
		int y = posicionInicial.getY();
		if (y == MARGEN_IZQUIERDO) {
			y++;
			direccionMovimiento = DireccionMovimiento.ESTE;
		} else {
			y--;
		}
		this.coordenadaInicio = new Coordenada(posicionInicial.getX(),y);
		return new Coordenada(posicionInicial.getX(),y);
	}

	private Coordenada moverseAlEste(Coordenada posicionInicial) {
		int y = posicionInicial.getY();
		int ejeY = y;
		if (direccionSentido == DireccionSentido.HORIZONTAL)
		{
			ejeY = (this.partes.size() + y);
		}
		if (ejeY == MARGEN_DERECHO) {
			y--;
			direccionMovimiento = DireccionMovimiento.OESTE;
		} else {
			y++;
		}
		this.coordenadaInicio = new Coordenada(posicionInicial.getX(),y);
		return new Coordenada(posicionInicial.getX(),y);
	}

	private Coordenada moverseAlSur(Coordenada posicionInicial) {
		int x = posicionInicial.getX();
		int ejeX = x;
		if (direccionSentido == DireccionSentido.VERTICAL)
		{
			ejeX += this.partes.size();
		}
		if (ejeX == MARGEN_INFERIOR) {
			x--;
			direccionMovimiento = DireccionMovimiento.NORTE;
			if (direccionSentido == DireccionSentido.VERTICAL) {
				this.coordenadaInicio = new Coordenada(MARGEN_INFERIOR - this.partes.size(),posicionInicial.getY());
			} else {
				this.coordenadaInicio = new Coordenada(x,posicionInicial.getY());
			}
		} else {
			x++;
			this.coordenadaInicio = new Coordenada(x,posicionInicial.getY());
		}
		return new Coordenada(x,posicionInicial.getY());
	}

	private Coordenada moverseAlNorte(Coordenada posicionInicial) {
		int x = posicionInicial.getX();
		if (x == MARGEN_SUPERIOR) {
			x++;
			direccionMovimiento = DireccionMovimiento.SUR;
			if (direccionSentido == DireccionSentido.VERTICAL) {
				this.coordenadaInicio = new Coordenada(this.partes.size()-1,posicionInicial.getY());
			} else {
				this.coordenadaInicio = new Coordenada(x,posicionInicial.getY());
			}
		} else {
			x--;
			this.coordenadaInicio = new Coordenada(x,posicionInicial.getY());
		}
		return new Coordenada(x,posicionInicial.getY());
	}

	private Coordenada moverseAlNoreste(Integer x, Integer y) {
		int ejeY = y;
		if (direccionSentido == DireccionSentido.HORIZONTAL)
		{
			ejeY += this.partes.size();
		}
		if ((x == MARGEN_SUPERIOR) || (ejeY == MARGEN_DERECHO)) {
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
		int ejeY = y;
		int ejeX = x;
		if (direccionSentido == DireccionSentido.HORIZONTAL)
		{
			ejeY += this.partes.size();
		} else {
			ejeX += this.partes.size();
		}
		if ((ejeX == MARGEN_INFERIOR) || (ejeY == MARGEN_DERECHO)) {
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
		int ejeX = x;
		if (direccionSentido == DireccionSentido.VERTICAL)
		{
			ejeX += this.partes.size();
		}
		if ((ejeX == MARGEN_INFERIOR) || (y == MARGEN_IZQUIERDO)) {
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
