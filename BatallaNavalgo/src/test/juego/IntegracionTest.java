package test.juego;

import java.io.IOException;

import main.juego.IniciadorDeJuego;
import main.juego.Jugador;
import main.model.tablero.Tablero;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {
	
	@Test
	public void testIniciarJuego() {
		IniciadorDeJuego iniciador = new IniciadorDeJuego();
		iniciador.setMostrarFrame(false);
		try {
			iniciador.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(Tablero.getTablero());
		Assert.assertNotNull(Jugador.getJugador());
		Assert.assertNotNull(Tablero.getTablero().getCasilleros());
	}
}
