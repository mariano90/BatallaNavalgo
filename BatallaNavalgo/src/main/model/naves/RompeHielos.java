package main.model.naves;

import java.util.ArrayList;

import main.model.disparos.Disparo;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

public class RompeHielos extends Nave {
	
	protected final Integer CANTIDAD_PARTES = 3;

	public RompeHielos(){
		this.partes = new ArrayList<Parte> ();
	}
	
	public RompeHielos(Coordenada coordenadaInicio, DireccionSentido sentido, DireccionMovimiento movimiento){
		this.partes = new ArrayList<Parte> ();
		this.coordenadaInicio = coordenadaInicio;
		this.direccionSentido = sentido;
		this.direccionMovimiento = movimiento;
		this.agregarPartes(coordenadaInicio, this.CANTIDAD_PARTES);
	}
	
	@Override
	public void recibirDisparo(Disparo disparo , Parte parte){
		if (parte.recibioDisparo()) {
			parte.destruir();
		} else {
			parte.recibirDisparo();
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
		return 5 + 60*this.coordenadaInicio.getY();
	}

}
