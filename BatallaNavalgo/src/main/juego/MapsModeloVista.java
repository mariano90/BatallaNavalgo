package main.juego;

import java.util.HashMap;
import java.util.Map;

import main.model.disparos.Disparo;
import main.model.naves.Nave;
import main.model.naves.Parte;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class MapsModeloVista {
	
	private static MapsModeloVista mapsModeloVista;
	private Map<Nave,Imagen> mapNaves;
	private Map<Disparo,Imagen> mapDisparos;
	private Map<Parte,Imagen> mapPartes;
	
	public MapsModeloVista(){
		mapDisparos = new HashMap<Disparo, Imagen>();
		mapNaves =  new HashMap<Nave, Imagen>();	
		mapPartes = new HashMap<Parte, Imagen>();
	}
	
	public static MapsModeloVista getMapsModeloVista(){
		if (mapsModeloVista == null){
			mapsModeloVista = new MapsModeloVista();
		}
		return mapsModeloVista;
	}

	public void agregarNave(Nave nave, Imagen vista){
		this.mapNaves.put(nave, vista);
	}
	
	public void agregarDisparo(Disparo disparo, Imagen vista){
		this.mapDisparos.put(disparo, vista);
	}
	
	public void agregarParte(Parte parte, Imagen vista){
		this.mapPartes.put(parte, vista);
	}
	
	public void removerNave(Nave nave){
		this.mapNaves.remove(nave);
	}
	
	public void removerDisparo(Disparo disparo){
		this.mapDisparos.remove(disparo);
	}
	
	public void removerParte(Parte parte){
		this.mapPartes.remove(parte);
	}
	
	public Map<Nave, Imagen> getMapNaves() {
		return mapNaves;
	}

	public Map<Disparo, Imagen> getMapDisparos() {
		return mapDisparos;
	}

	public Map<Parte, Imagen> getMapPartes() {
		return mapPartes;
	}
	
}
