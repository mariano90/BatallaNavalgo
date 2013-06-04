package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.TripleConRetardo;
import main.model.tablero.Coordenada;

import org.junit.Assert;
import org.junit.Test;

public class TripleConRetardoTest {
	
	@Test
	public void TripleConRetardoCostoYRadioTest(){
		Disparo disparo = new TripleConRetardo(new Coordenada(1, 2));
		Assert.assertTrue(disparo.getCosto() == 125);
		Assert.assertTrue(disparo.getRadio() == 2);
	}
	
	@Test
	public void accionarDisparoTest(){
		Disparo disparo = new TripleConRetardo(new Coordenada(1, 2));
		boolean debeExplotar = disparo.debeExplotar(null);
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar(null);
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar(null);
		Assert.assertTrue(debeExplotar);
	}
	
}
