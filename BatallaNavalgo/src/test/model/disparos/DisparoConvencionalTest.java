package test.model.disparos;

import org.junit.Assert;
import org.junit.Test;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.tablero.Coordenada;

public class DisparoConvencionalTest {
	
	@Test
	public void DisparoConvencionalCostoYRadioTest(){
		Disparo disparo = new DisparoConvencional(new Coordenada(1, 2));
		Assert.assertTrue(disparo.getCosto() == 200);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
	
	@Test
	public void accionarDisparoTest(){
		Disparo disparo = new DisparoConvencional(new Coordenada(1, 2));
		boolean debeExplotar = disparo.debeExplotar();
		Assert.assertTrue(debeExplotar);
	}
	
}
