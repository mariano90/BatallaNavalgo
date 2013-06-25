package main.view.juego;

import java.util.ArrayList;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class DibujablesList implements ObjetoDibujable {
	
	public static DibujablesList dibujablesList;
	private ArrayList<ObjetoDibujable> objetosDibujables;
	
	public DibujablesList() {
		objetosDibujables = new ArrayList<ObjetoDibujable>();
	}
	
	public static DibujablesList getDibujablesList(){
		if (dibujablesList == null) {
			dibujablesList = new DibujablesList();
		}
		return dibujablesList;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficieDibujo) {
		for (ObjetoDibujable objetoDibujable : this.objetosDibujables) {
			objetoDibujable.dibujar(superficieDibujo);
		}
	}
	
	public void agregar(ObjetoDibujable objeto) {
		this.objetosDibujables.add(objeto);
	}
	
	public void remover(ObjetoDibujable objeto) {
		this.objetosDibujables.remove(objeto);
	}
}
