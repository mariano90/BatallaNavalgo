package main.model.naves;

import java.util.ArrayList;

import main.model.disparos.DisparoConvencional;
import main.model.disparos.MinaSubmarina;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

public class Destructor extends Nave {

	protected final Integer CANTIDAD_PARTES = 3;
	
	public Destructor(){
		this.partes = new ArrayList<Parte> ();
	}
	
	public Destructor(Coordenada coordenadaInicio, DireccionSentido sentido, DireccionMovimiento movimiento){
		this.partes = new ArrayList<Parte> ();
		this.direccionSentido = sentido;
		this.direccionMovimiento = movimiento;
		this.agregarPartes(coordenadaInicio, this.CANTIDAD_PARTES);
	}
	
	public void recibirDisparo(MinaSubmarina minaSubmarina, Parte parte){
		return;
	}
	
	public void recibirDisparo(DisparoConvencional minaSubmarina, Parte parte){
		parte.recibirDisparo();
		parte.destruir();
	}
}
