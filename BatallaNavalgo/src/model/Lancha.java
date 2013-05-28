package model;

public class Lancha extends Nave {
	
	@Override
	public void recibirDisparo(Disparo disparo, Parte parte){
		parte.recibirDisparo();
		parte.destruir();
	}
}
