package model;

public class Destructor extends Nave {

	@Override
	public void recibirDisparo(Disparo disparo, Parte parte){
		
		//solucionar como se ve el tipo de disparo
		if (disparo.tipo = "directo"){
			parte.recibirDisparo();
			parte.destruir();
		}
	}
}
