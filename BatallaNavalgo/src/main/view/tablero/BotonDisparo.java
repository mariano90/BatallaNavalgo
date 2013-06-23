package main.view.tablero;

import javax.swing.JButton;

import main.model.disparos.Disparo;

public abstract class BotonDisparo extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2009311450585882802L;
	
	protected Disparo disparo;
	protected SuperficiePanelListener mouseListener;
	
	public abstract void crearDisparo();
}
