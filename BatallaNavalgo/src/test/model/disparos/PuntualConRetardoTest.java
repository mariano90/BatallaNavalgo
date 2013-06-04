package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.PuntualConRetardo;
import main.model.tablero.Coordenada;

import org.junit.Assert;
import org.junit.Test;

public class PuntualConRetardoTest {
	@Test
	public void PuntualConRetardoCostoYRadioTest(){
		Disparo disparo = new PuntualConRetardo(new Coordenada(1, 2));
		Assert.assertTrue(disparo.getCosto() == 50);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
	
	@Test
	public void accionarDisparoTest(){
		Disparo disparo = new PuntualConRetardo(new Coordenada(1, 2));
		boolean debeExplotar = disparo.debeExplotar(null);
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar(null);
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar(null);
		Assert.assertTrue(debeExplotar);
	}
	
}
