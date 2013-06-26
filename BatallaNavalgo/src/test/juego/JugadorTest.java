package test.juego;

import org.junit.Assert;

import org.junit.Test;

import main.juego.Jugador;

public class JugadorTest {

	@Test
	public void puntuacionInicialTest(){
		Jugador.reiniciarJugador();
		Assert.assertTrue(Jugador.getJugador().getPuntuacion() == 10000);
	}

	@Test
	public void restarCantidadDePuntosMenorALaPuntuacionTest(){
		Jugador.reiniciarJugador();
		Jugador jugador = Jugador.getJugador();
		jugador.restarPuntos(5000);

		Assert.assertTrue(jugador.getPuntuacion() == 5000);
	}

	@Test
	public void restarPuntosAPuntuacionEn0Test(){
		Jugador.reiniciarJugador();
		Jugador jugador = Jugador.getJugador();
		jugador.restarPuntos(10000);
		jugador.restarPuntos(50);
		
		Assert.assertTrue(jugador.getPuntuacion() == 0);
	}

	@Test
	public void restarCantidadDePuntosNegativaTest() {
		Jugador.reiniciarJugador();
		Jugador.getJugador().restarPuntos(-5000);
		Assert.assertTrue(Jugador.getJugador().getPuntuacion() == 10000);
	}

	@Test
	public void restarCantidadDePuntosMayorALaPuntuacionTest(){
		Jugador.reiniciarJugador();
		Jugador jugador = Jugador.getJugador();
		jugador.restarPuntos(3000);
		jugador.restarPuntos(8000);

		Assert.assertTrue(jugador.getPuntuacion() == 0);
	}
}