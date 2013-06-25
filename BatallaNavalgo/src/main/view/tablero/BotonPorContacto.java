package main.view.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import main.model.disparos.PorContacto;

public class BotonPorContacto extends BotonDisparo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662052988821033613L;

	public BotonPorContacto(SuperficiePanelListener mouseListener){
		this.setIcon(new ImageIcon("./images/disparos/porContacto.PNG"));
		this.mouseListener = mouseListener;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearDisparo();
			}
		});
	}
	
	@Override
	public void crearDisparo() {
		this.disparo = new PorContacto();		
		System.out.println("SE CREO EL DISPARO por contacto");
		this.mouseListener.setDisparo(this.disparo);
		try {
			this.mouseListener.setUrlImagen(new URL("file:./images/disparos/porContacto.PNG"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
}
