package main.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;

public class BotonDisparoConvencional extends BotonDisparo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662052988821033613L;

	public BotonDisparoConvencional(Disparo disparo, SuperficiePanelListener mouseListener){
		this.setIcon(new ImageIcon("./images/disparos/disparoConvencional.PNG"));
		this.disparo = disparo;
		this.mouseListener = mouseListener;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearDisparo();
			}
		});
	}
	
	@Override
	public void crearDisparo() {
		this.disparo = new DisparoConvencional();		
		System.out.println("SE CREO EL DISPARO");
		this.mouseListener.setDisparo(this.disparo);
		try {
			this.mouseListener.setUrlImagen(new URL("file:./images/disparos/disparoConvencional.PNG"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
}
