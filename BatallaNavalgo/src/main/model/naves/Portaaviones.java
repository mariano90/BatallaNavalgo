package main.model.naves;

import main.model.disparos.Disparo;

public class Portaaviones extends Nave {
	@Override
	public void recibirDisparo(Disparo disparo, Parte parte){

		parte.recibirDisparo();
		parte.destruir();
	}
}
