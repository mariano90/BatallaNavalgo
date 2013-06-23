package main.juego.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import main.model.disparos.Disparo;
import main.model.disparos.TripleConRetardo;

public class BotonTripleConRetardo extends BotonDisparo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662052988821033613L;

	public BotonTripleConRetardo(Disparo disparo, SuperficiePanelListener mouseListener){
		this.setIcon(new ImageIcon("./images/disparos/tripleConRetardo.PNG"));
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
		this.disparo = new TripleConRetardo();		
		System.out.println("SE CREO EL DISPARO t con retardo");
		this.mouseListener.setDisparo(this.disparo);
		try {
			this.mouseListener.setUrlImagen(new URL("file:./images/disparos/tripleConRetardo.PNG"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
}
