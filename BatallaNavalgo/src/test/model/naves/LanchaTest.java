package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.PuntualConRetardo;
import main.model.naves.Lancha;
import main.model.naves.Nave;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;

import org.junit.Test;

public class LanchaTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(5,8);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);

		Assert.assertTrue(lancha.getPartes().size() == 2);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(5,8);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Disparo disparo = new PuntualConRetardo(coordenada);
		lancha.recibirDisparo(disparo, lancha.getPartes().get(0));

		Assert.assertTrue(lancha.getPartes().get(0).estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(5,8);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		lancha.recibirDisparo(disparo, lancha.getPartes().get(0));

		Assert.assertTrue(lancha.getPartes().get(0).estaDestruida());
	}
}
