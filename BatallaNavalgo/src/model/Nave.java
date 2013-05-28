package model;

import java.util.ArrayList;


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
	
	
	public boolean estaDestruida(){
		boolean naveDestruida;
		for( int i = 0 ; i < partes.size() ; i++ ){
			naveDestruida = partes.get(i).estaDestruida();
			if (!naveDestruida) return false;
			}
		
		return true;
	}
	
}
