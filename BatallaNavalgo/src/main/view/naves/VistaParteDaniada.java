package main.view.naves;

import java.io.IOException;
import java.net.URL;

import main.model.naves.Parte;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class VistaParteDaniada extends Imagen{

	public VistaParteDaniada(URL urlImagen, Parte parte) throws IOException {
		super(urlImagen, parte);
	}

}
