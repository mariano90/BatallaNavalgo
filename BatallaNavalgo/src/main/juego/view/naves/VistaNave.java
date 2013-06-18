package main.juego.view.naves;

import java.io.IOException;
import java.net.URL;

import main.model.naves.Nave;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class VistaNave extends Imagen{

	public VistaNave(URL urlImagen, Nave nave) throws IOException {
		super(urlImagen, nave);
	}

}
