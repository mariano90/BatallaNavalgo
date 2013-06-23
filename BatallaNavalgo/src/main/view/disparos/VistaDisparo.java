package main.view.disparos;

import java.io.IOException;
import java.net.URL;

import main.model.disparos.Disparo;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class VistaDisparo extends Imagen{
	
	public VistaDisparo(URL url, Disparo disparo) throws IOException {
		super(url, disparo);
	}
	
}
