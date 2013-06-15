package main.juego;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class FondoPanel extends JPanel{
	ImageIcon image;
	String nombre;
	
	public FondoPanel(String nombre){
		this.nombre = nombre;
	}
	
	public void paint(Graphics g){
		Dimension tamanio = getSize();
		image = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(image.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}
	
}
