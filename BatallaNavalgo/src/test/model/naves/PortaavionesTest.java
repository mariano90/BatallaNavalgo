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
import main.model.tablero.Tablero;
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

	@Test 
	public void ubicacionDeLaNaveTest(){
		Coordenada coordenadaInicio = new Coordenada(1,4);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave portaaviones = new Portaaviones(coordenadaInicio, sentido, movimiento);

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(coordenadaInicio));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(2,4)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(3,4)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(4,4)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(5,4)));
	}

	@Test
	public void moverseHaciaArribaTest(){
		Coordenada coordenada = new Coordenada(5,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(4,8)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(4,9)));
	}

	@Test
	public void moverseHaciaAbajoTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(5,3)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(6,3)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(7,3)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(8,3)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(9,3)));
	}

	@Test
	public void moverseHaciaElEsteTest(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(3,7)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(5,7)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(6,7)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(7,7)));
	}

	@Test
	public void moverseHaciaElOesteTest(){
		Coordenada coordenada = new Coordenada(6,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(6,5)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(6,6)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(6,7)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(6,8)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(6,9)));
	}

	@Test
	public void moverseHaciaElNoresteTest(){
		Coordenada coordenada = new Coordenada(5,4);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(6,5)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(7,5)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(8,5)));
	}

	@Test
	public void moverseHaciaElNoroesteTest(){
		Coordenada coordenada = new Coordenada(6,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NOROESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(5,6)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(5,7)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(5,8)));
	}

	@Test
	public void moverseHaciaElSuresteTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SURESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(6,4)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(7,4)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(8,4)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(9,4)));
	}

	@Test
	public void moverseHaciaElSuroeste(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUROESTE;
		Nave portaaviones = new Portaaviones(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(portaaviones);
		portaaviones.moverse();

		Assert.assertTrue(portaaviones.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(portaaviones.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(portaaviones.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(portaaviones.getPartes().get(3).getPosicion().equals(new Coordenada(4,8)));
		Assert.assertTrue(portaaviones.getPartes().get(4).getPosicion().equals(new Coordenada(4,9)));
	}
}
