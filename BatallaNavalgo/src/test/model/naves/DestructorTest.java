package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.DobleConRetardo;
import main.model.naves.Destructor;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

import org.junit.Test;

public class DestructorTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Destructor destructor = new Destructor(coordenada, sentido, movimiento);

		Assert.assertTrue(destructor.getPartes().size() == 3);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Destructor destructor = new Destructor(coordenada, sentido, movimiento);
		DobleConRetardo disparo = new DobleConRetardo();
		destructor.recibirDisparo(disparo, destructor.getPartes().get(0));

		Assert.assertFalse(destructor.getPartes().get(0).estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Destructor destructor = new Destructor(coordenada, sentido, movimiento);
		DisparoConvencional disparo = new DisparoConvencional();
		destructor.recibirDisparo(disparo, destructor.getPartes().get(0));

		Assert.assertTrue(destructor.getPartes().get(0).estaDestruida());
	}
}
