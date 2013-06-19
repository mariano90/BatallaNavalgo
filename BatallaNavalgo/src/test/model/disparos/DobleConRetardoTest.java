package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.DobleConRetardo;
import main.model.tablero.Coordenada;

import org.junit.Assert;
import org.junit.Test;

public class DobleConRetardoTest {
	
	@Test
	public void ConRetardoCostoYRadioTest(){
		Disparo disparo = new DobleConRetardo(new Coordenada(1, 2));
		Assert.assertTrue(disparo.getCosto() == 100);
		Assert.assertTrue(disparo.getRadio() == 1);
	}
	
	@Test
	public void accionarDisparoTest(){
		Disparo disparo = new DobleConRetardo(new Coordenada(1, 2));
		boolean debeExplotar = disparo.debeExplotar();
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar();
		Assert.assertFalse(debeExplotar);
		debeExplotar = disparo.debeExplotar();
		Assert.assertTrue(debeExplotar);
	}
	
}
