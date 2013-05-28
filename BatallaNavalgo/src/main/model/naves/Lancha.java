package main.model.naves;

import main.model.disparos.Disparo;

public class Lancha extends Nave {
	
	@Override
	public void recibirDisparo(Disparo disparo, Parte parte){
		parte.recibirDisparo();
		parte.destruir();
	}
}
