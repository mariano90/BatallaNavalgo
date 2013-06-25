package main.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import main.model.disparos.PuntualConRetardo;

public class BotonPuntualConRetardo extends BotonDisparo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662052988821033613L;

	public BotonPuntualConRetardo(SuperficiePanelListener mouseListener){
		this.setIcon(new ImageIcon("./images/disparos/puntualConRetardo.PNG"));
		this.mouseListener = mouseListener;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearDisparo();
			}
		});
	}
	
	@Override
	public void crearDisparo() {
		this.disparo = new PuntualConRetardo();		
		System.out.println("SE CREO EL DISPARO p con retardo");
		this.mouseListener.setDisparo(this.disparo);
		try {
			this.mouseListener.setUrlImagen(new URL("file:./images/disparos/puntualConRetardo.PNG"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
}
