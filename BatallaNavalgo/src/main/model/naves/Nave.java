package main.model.naves;

import java.util.ArrayList;

import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

public abstract class Nave {

	protected DireccionMovimiento direccionMovimiento;
	protected DireccionSentido direccionSentido;
	protected ArrayList<Parte> partes;

	public void moverse(){
	}
	
	protected void agregarPartes(Coordenada coordenadaInicio, Integer cantPartes){
		Coordenada coordenada = coordenadaInicio;
		for (int i = 0; i < cantPartes; i++) {
			this.agregarParte(coordenada);
			coordenada = this.obtenerSiguienteCoordenada(coordenada);
		}
	}
	
	protected void agregarParte(Coordenada coordenada){
		Parte parte = new Parte(coordenada);
		this.partes.add(parte);
	}

	protected Coordenada obtenerSiguienteCoordenada(Coordenada coordenada){
		Coordenada nuevaCoordenada = new Coordenada();
		if (this.direccionSentido == DireccionSentido.HORIZONTAL){
			nuevaCoordenada.setX(coordenada.getX() + 1);
			nuevaCoordenada.setY(coordenada.getY());
		}
		else{
			nuevaCoordenada.setX(coordenada.getX());
			nuevaCoordenada.setY(coordenada.getY() + 1);
		}
		return nuevaCoordenada;
	}
	
	public boolean estaDestruida(){
		boolean naveDestruida;
		for (Parte parte : this.partes) {
			naveDestruida = parte.estaDestruida();
			if (!naveDestruida) return false;			
		}
		return true;
	}
	
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
