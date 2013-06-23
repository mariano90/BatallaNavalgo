package main.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;

public class BotonCelda extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordenada coordenada;

	public BotonCelda(Coordenada coordenada){
		this.coordenada = coordenada;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearDisparo();
			}
		});
	}
	
	public void crearDisparo(){
		Disparo disparo = new DisparoConvencional(this.coordenada);
		Tablero.getTablero().agregarDisparo(disparo);
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
}
