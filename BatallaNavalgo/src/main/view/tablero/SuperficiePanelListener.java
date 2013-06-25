package main.view.tablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

import main.juego.Jugador;
import main.juego.MapsModeloVista;
import main.model.disparos.Disparo;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;
import main.view.disparos.VistaDisparo;
import main.view.juego.DibujablesList;

public class SuperficiePanelListener implements MouseListener {

	private Disparo disparo;
	private URL urlImagen;
	private int x;
	private int y;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -656393156072573350L;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.x = arg0.getX();
		this.y = arg0.getY();
		if (disparo != null && !Jugador.getJugador().isPusoDisparo() && Jugador.getJugador().getPuntuacion() >= disparo.getCosto()){
			Jugador.getJugador().restarPuntos(disparo.getCosto());
			Jugador.getJugador().setPusoDisparo(true);
			this.colocarDisparo();
			this.disparo = null;
		}
		else System.out.println("NO SE PUEDE CREAR DISPARO");
	}

	public void colocarDisparo(){
		Coordenada coordenada = this.obtenerCoordenada();
		if(coordenada != null){
			disparo.setCoordenada(coordenada);
			Tablero.getTablero().agregarDisparo(disparo);
			try {
				VistaDisparo vista = new VistaDisparo(this.urlImagen, disparo);
				DibujablesList.getDibujablesList().agregar(vista);
				MapsModeloVista.getMapsModeloVista().agregarDisparo(disparo, vista);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Coordenada obtenerCoordenada(){
		Coordenada coordenada = null;
		int x=0;
		int y=0;
		for (int i = 60; i < 660; i=i+60) {
			for (int j = 60; j < 660; j=j+60) {
				if (this.y<j && this.x<i && this.x>=i-60){
					coordenada = new Coordenada(x, y);
					System.out.println("x: "+coordenada.getX() + " y: " +coordenada.getY());
					return coordenada;
				}
			y++;
			}
			y=0;
			x++;
		}
		return null;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	public void setDisparo(Disparo disparo) {
		this.disparo = disparo;
	}

	public void setUrlImagen(URL urlImagen) {
		this.urlImagen = urlImagen;
	}
	
}
