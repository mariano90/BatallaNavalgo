package main.model.naves;

public class Parte {
	
	private Coordenada posicion ;
	private boolean destruida;
	private boolean recibioDisparo; 
	
	
	public Parte(){
		this.destruida = false;
		this.recibioDisparo = false;
	}
	
	public boolean estaDestruida(){
		return destruida;
	}
	
	public boolean recibioDisparo(){
		return recibioDisparo;
	}
	
	public void recibirDisparo(){
		this.recibioDisparo = true;
	}
	
	public void destruir(){
		this.destruida = true;
	}
	
	
	
	
	

}
