package main.model.naves;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import main.model.tablero.Coordenada;

public class Parte implements ObjetoPosicionable{

	private Coordenada posicion ;
	private boolean destruida;
	private boolean recibioDisparo; 

	public Parte(){
		this.destruida = false;
		this.recibioDisparo = false;
	}
	
	public Parte(Coordenada coordenada){
		this.destruida = false;
		this.recibioDisparo = false;
		this.posicion = coordenada;
	}

	public boolean estaDestruida(){
		return destruida;
	}

	public boolean recibioDisparo(){
		return recibioDisparo;
	}

	public void recibirDisparo(){
		this.recibioDisparo = true;
	}

	public void destruir(){
		this.destruida = true;
	}

	public Coordenada getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int x, int y) {
		Coordenada posicion = new Coordenada(x, y);
		this.posicion = posicion;
	}

	@Override
	public int getX() {
		return posicion.getX();
	}

	@Override
	public int getY() {
		return posicion.getY();
	}
	
}
