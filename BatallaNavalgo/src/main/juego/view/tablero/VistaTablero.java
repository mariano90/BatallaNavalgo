package main.juego.view.tablero;

import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;

import main.model.tablero.Tablero;

public class VistaTablero extends Imagen{
	
	public VistaTablero(URL urlImagen, Tablero tablero) throws IOException {
		super(urlImagen, tablero);
	}

}
