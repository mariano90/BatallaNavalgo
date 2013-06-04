package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.DobleConRetardo;
import main.model.disparos.PuntualConRetardo;
import main.model.naves.Nave;
import main.model.naves.RompeHielos;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

import org.junit.Test;

public class RompeHielosTests {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(0,0);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
		Assert.assertTrue(rompeHielos.getPartes().size() == 3);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(0,0);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
		Disparo disparo = new DobleConRetardo(coordenada);
		rompeHielos.recibirDisparo(disparo, rompeHielos.getPartes().get(0));

		Assert.assertTrue(rompeHielos.getPartes().get(0).recibioDisparo());
		Assert.assertFalse(rompeHielos.getPartes().get(0).estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(0,0);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		rompeHielos.recibirDisparo(disparo, rompeHielos.getPartes().get(0));

		Assert.assertFalse(rompeHielos.getPartes().get(0).estaDestruida());
		Assert.assertTrue(rompeHielos.getPartes().get(0).recibioDisparo());
	}

	@Test
	public void recibirDosImpactosTest(){
		Coordenada coordenada = new Coordenada(0,0);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave rompeHielos = new RompeHielos(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		rompeHielos.recibirDisparo(disparo, rompeHielos.getPartes().get(1));
		Disparo disparo2 = new PuntualConRetardo(coordenada);
		rompeHielos.recibirDisparo(disparo2, rompeHielos.getPartes().get(1));

		Assert.assertTrue(rompeHielos.getPartes().get(1).recibioDisparo());
		Assert.assertTrue(rompeHielos.getPartes().get(1).estaDestruida());
	}
}
