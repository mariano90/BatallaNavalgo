package main.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import main.model.disparos.Disparo;
import main.model.disparos.DobleConRetardo;

public class BotonDobleConRetardo extends BotonDisparo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662052988821033613L;

	public BotonDobleConRetardo(Disparo disparo, SuperficiePanelListener mouseListener){
		this.setIcon(new ImageIcon("./images/disparos/dobleConRetardo.PNG"));
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
		this.disparo = new DobleConRetardo();		
		System.out.println("SE CREO EL DISPARO d con retardo");
		this.mouseListener.setDisparo(this.disparo);
		try {
			this.mouseListener.setUrlImagen(new URL("file:./images/disparos/dobleConRetardo.PNG"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
}
