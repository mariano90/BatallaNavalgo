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
import main.model.tablero.Tablero;
import org.junit.Ignore;
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

	@Ignore
	@Test
	public void destruirLancha(){
		Nave lancha = new Lancha();
		lancha.getPartes().get(0).destruir();
		lancha.getPartes().get(1).destruir();

		Assert.assertTrue(lancha.estaDestruida());
	}

	@Test 
	public void ubicacionDeLaNaveTest(){
		Coordenada coordenadaInicio = new Coordenada(5,5);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave lancha = new Lancha(coordenadaInicio, sentido, movimiento);

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion() == coordenadaInicio);
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(6,5)));
		}

	@Test
	public void moverseHaciaArribaTest(){
		Coordenada coordenada = new Coordenada(5,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
	}

	@Test
	public void moverseHaciaAbajoTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(5,3)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(6,3)));
	}

	@Test
	public void moverseHaciaElEsteTest(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(3,7)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(4,7)));
	}

	@Test
	public void moverseHaciaElOesteTest(){
		Coordenada coordenada = new Coordenada(6,7);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(6,6)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(6,7)));
	}

	@Test
	public void moverseHaciaElNoresteTest(){
		Coordenada coordenada = new Coordenada(5,4);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
	}

	@Test
	public void moverseHaciaElNoroesteTest(){
		Coordenada coordenada = new Coordenada(6,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NOROESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
	}

	@Test
	public void moverseHaciaElSuresteTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SURESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(6,4)));
	}

	@Test
	public void moverseHaciaElSuroeste(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUROESTE;
		Nave lancha = new Lancha(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(lancha);
		lancha.moverse();

		Assert.assertTrue(lancha.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(lancha.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
	}
}
