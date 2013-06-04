package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.TripleConRetardo;
import main.model.naves.Buque;
import main.model.naves.Nave;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

import org.junit.Test;

public class BuqueTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);

		Assert.assertTrue(buque.getPartes().size() == 4);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Disparo disparo = new TripleConRetardo(coordenada);
		buque.recibirDisparo(disparo, buque.getPartes().get(0));

		Assert.assertTrue(buque.getPartes().get(0).estaDestruida());
		Assert.assertTrue(buque.estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		buque.recibirDisparo(disparo, buque.getPartes().get(0));

		Assert.assertTrue(buque.getPartes().get(0).estaDestruida());
		Assert.assertTrue(buque.estaDestruida());
	}
}
