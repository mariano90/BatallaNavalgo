package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.DobleConRetardo;
import main.model.naves.Destructor;
import main.model.naves.Nave;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;
import org.junit.Test;

public class DestructorTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);

		Assert.assertTrue(destructor.getPartes().size() == 3);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Disparo disparo = new DobleConRetardo(coordenada);
		destructor.recibirDisparoDeMinaSubmarina(disparo, destructor.getPartes().get(0));

		Assert.assertFalse(destructor.getPartes().get(0).estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(2,3);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		destructor.recibirDisparo(disparo, destructor.getPartes().get(0));

		Assert.assertTrue(destructor.getPartes().get(0).estaDestruida());
	}

	@Test 
	public void ubicacionDeLaNaveTest(){
		Coordenada coordenadaInicio = new Coordenada(3,4);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave destructor = new Destructor(coordenadaInicio, sentido, movimiento);

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(coordenadaInicio));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(3,5)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(3,6)));
	}

	@Test
	public void moverseHaciaArribaTest(){
		Coordenada coordenada = new Coordenada(5,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
	}

	@Test
	public void moverseHaciaAbajoTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(5,3)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(6,3)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(7,3)));
	}

	@Test
	public void moverseHaciaElEsteTest(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(3,7)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(5,7)));
	}

	@Test
	public void moverseHaciaElOesteTest(){
		Coordenada coordenada = new Coordenada(6,7);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(6,6)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(6,7)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(6,8)));
	}

	@Test
	public void moverseHaciaElNoresteTest(){
		Coordenada coordenada = new Coordenada(5,4);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(6,5)));
	}

	@Test
	public void moverseHaciaElNoroesteTest(){
		Coordenada coordenada = new Coordenada(6,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NOROESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(5,6)));
	}

	@Test
	public void moverseHaciaElSuresteTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SURESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(6,4)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(7,4)));
	}

	@Test
	public void moverseHaciaElSuroeste(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUROESTE;
		Nave destructor = new Destructor(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(destructor);
		destructor.moverse();

		Assert.assertTrue(destructor.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(destructor.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(destructor.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
	}
}
