package main.model.naves;

import java.util.ArrayList;

import main.model.disparos.Disparo;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

public class Buque extends Nave {

	protected final Integer CANTIDAD_PARTES = 4;
	
	public Buque(){
		this.partes = new ArrayList<Parte> ();
	}
	
	public Buque(Coordenada coordenadaInicio, DireccionSentido sentido, DireccionMovimiento movimiento){
		this.partes = new ArrayList<Parte> ();
		this.coordenadaInicio = coordenadaInicio;
		this.direccionSentido = sentido;
		this.direccionMovimiento = movimiento;
		this.agregarPartes(coordenadaInicio, this.CANTIDAD_PARTES);
	}
	
	public void recibirDisparo(Disparo disparo, Parte parte){
		for (Parte parteAfectada : this.partes) {
			parteAfectada.recibirDisparo();
			parteAfectada.destruir();
		}
	}
	
	public Integer getCANTIDAD_PARTES() {
		return CANTIDAD_PARTES;
	}

	@Override
	public int getX() {
		return 15 + 60*this.coordenadaInicio.getX();
	}

	@Override
	public int getY() {
		return 10 + 60*this.coordenadaInicio.getY();
	}
}
