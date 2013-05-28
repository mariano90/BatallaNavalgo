package main.model.tablero;

import java.util.ArrayList;
import main.model.disparos.Disparo;
import main.model.naves.Nave;

public class Casillero {

	private ArrayList<Nave> naves;
	private ArrayList<Disparo> disparos;
	private Coordenada coordenada;

	public Casillero () {
		naves = new ArrayList<Nave> ();
		disparos = new ArrayList<Disparo> ();
	}

	public void agregarCoordenada (int x, int y) {
		coordenada = new Coordenada (x, y);
	}

	public void agregarNave(Nave laNave) {
		naves.add(laNave);
	}

	public void agregarDisparo(Disparo elDisparo) {
		disparos.add(elDisparo);
	}

	public ArrayList<Nave> getNaves() {
		return naves;
	}

	public ArrayList<Disparo> getDisparos() {
		return disparos;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
}
