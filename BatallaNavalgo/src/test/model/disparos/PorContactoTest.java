package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.PorContacto;
import main.model.naves.Parte;
import main.model.tablero.Coordenada;

import org.junit.Assert;
import org.junit.Test;

public class PorContactoTest {
	
	@Test
	public void PorContactoCostoYRadioTest(){
		Disparo disparo = new PorContacto(new Coordenada(1, 2));
		Assert.assertTrue(disparo.getCosto() == 150);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
	
	@Test
	public void accionarDisparoTest(){
		Disparo disparo = new PorContacto(new Coordenada(1, 2));
		Parte parte = new Parte(new Coordenada(2, 2));
		boolean debeExplotar = disparo.debeExplotar(parte);
		Assert.assertFalse(debeExplotar);
		Parte parte2 = new Parte(new Coordenada(1, 2));
		debeExplotar = disparo.debeExplotar(parte2);
		Assert.assertTrue(debeExplotar);
	}
	
}
