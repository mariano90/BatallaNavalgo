package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.PorContacto;
import main.model.naves.Lancha;
import main.model.naves.Nave;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;

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
		Nave nave = new Lancha();
		Tablero.getTablero().getCasilleros()[1][2].agregarNave(nave);
		boolean debeExplotar = disparo.debeExplotar();
		Assert.assertTrue(debeExplotar);
	}
	
	@Test
	public void noAccionarDisparoTest(){
		Disparo disparo = new PorContacto(new Coordenada(8, 9));
		Nave nave = new Lancha();
		Tablero.getTablero().getCasilleros()[4][5].agregarNave(nave);
		boolean debeExplotar = disparo.debeExplotar();
		Assert.assertFalse(debeExplotar);
	}
	
}
