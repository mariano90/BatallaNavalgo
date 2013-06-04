package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.PorContacto;
import main.model.naves.Nave;
import main.model.naves.Portaaviones;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

import org.junit.Test;

public class PortaavionesTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(9,0);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);

		Assert.assertTrue(portaaviones.getPartes().size() == 5);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(9,0);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Disparo disparo = new PorContacto(coordenada);
		portaaviones.recibirDisparo(disparo, portaaviones.getPartes().get(0));

		Assert.assertTrue(portaaviones.getPartes().get(0).estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(9,0);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		portaaviones.recibirDisparo(disparo, portaaviones.getPartes().get(0));

		Assert.assertTrue(portaaviones.getPartes().get(0).estaDestruida());
	}
}
