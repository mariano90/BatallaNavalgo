package main.model.naves;

import java.util.ArrayList;
import main.model.disparos.Disparo;
import main.model.tablero.Coordenada;

public abstract class Nave {

	private DireccionesDeMovimiento direccionDeMovimiento; 
	protected ArrayList<Parte> partes;

	public Nave(){
		this.partes = new ArrayList<Parte> ();
	}

	public void moverse(){
	}

	public void recibirDisparo (Disparo disparo, Parte parte){
		//sera redefinida en sus clases hijas
	}
	
	public void agregarParte(Coordenada coordenada){
		Parte parte = new Parte(coordenada);
		this.partes.add(parte);
	}

	public boolean estaDestruida(){
		boolean naveDestruida;
		for( int i = 0 ; i < partes.size() ; i++ ){
			naveDestruida = partes.get(i).estaDestruida();
			if (!naveDestruida) return false;
			}
		
		return true;
	}
}
