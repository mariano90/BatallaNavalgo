package main.model.tablero;

public class Coordenada {

	private int x;
	private int y;

	public Coordenada(){
		
	}
	
	public Coordenada (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
}
