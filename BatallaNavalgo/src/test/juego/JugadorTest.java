package test.juego;

import org.junit.Assert;

import org.junit.Test;

import main.juego.Jugador;

public class JugadorTest {

	@Test
	public void puntuacionInicialTest(){
		
		Jugador jugador = new Jugador();
		
		Assert.assertTrue( jugador.getPuntuacion() == 10000);
	}

	@Test
	public void restarCantidadDePuntosMenorALaPuntuacionTest(){

		Jugador jugador = new Jugador();
		jugador.restarPuntos(5000);

		Assert.assertTrue(jugador.getPuntuacion() == 5000);
	}

	@Test
	public void restarPuntosAPuntuacionEn0Test(){
		
		Jugador jugador = new Jugador();
		jugador.restarPuntos(10000);
		jugador.restarPuntos(50);
		
		Assert.assertTrue(jugador.getPuntuacion() == 0);
	}

	@Test
	public void restarCantidadDePuntosNegativaTest(){

		Jugador jugador = new Jugador();
		jugador.restarPuntos(-5000);
		
		Assert.assertTrue(jugador.getPuntuacion() == 10000);
	}

	@Test
	public void restarCantidadDePuntosMayorALaPuntuacionTest(){

		Jugador jugador = new Jugador();
		jugador.restarPuntos(3000);
		jugador.restarPuntos(8000);

		Assert.assertTrue(jugador.getPuntuacion() == 0);
	}
}