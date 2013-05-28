package main.model.naves;

public class Buque extends Nave {

	@Override
	public void recibirDisparo(Disparo disparo, Parte parte){
		
		for( int i = 0 ; i < partes.size() ; i++ ){
			partes.get(i).recibirDisparo();
			partes.get(i).destruir();
		}
		
	}
}
