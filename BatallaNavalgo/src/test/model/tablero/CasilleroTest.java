package test.model.tablero;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DobleConRetardo;
import main.model.disparos.PorContacto;
import main.model.naves.Destructor;
import main.model.naves.Lancha;
import main.model.naves.Nave;
import main.model.tablero.Casillero;
import main.model.tablero.Coordenada;
import org.junit.Ignore;
import org.junit.Test;

public class CasilleroTest {

	@Test
	public void crearCasilleroTest(){
		Coordenada coordenada = new Coordenada(5,3);
		Casillero casillero = new Casillero(coordenada);

		Assert.assertTrue(casillero.getCoordenada() == coordenada);
		Assert.assertTrue(casillero.getDisparos() != null);	
		Assert.assertTrue(casillero.getNaves() != null);
	}

	@Test
	public void agregarNavesTest(){
		Casillero casillero = new Casillero(new Coordenada(3,7));
		Nave lancha = new Lancha();
		casillero.agregarNave(lancha);
		Nave destructor = new Destructor();
		casillero.agregarNave(destructor);

		Assert.assertTrue(casillero.getNaves().get(0) == lancha);
		Assert.assertTrue(casillero.getNaves().get(1) == destructor);
	}

	@Test
	public void agregarDisparosTest(){
		Coordenada coordenada = new Coordenada(4,1);
		Casillero casillero = new Casillero(coordenada);
		Disparo disparo1 = new DobleConRetardo(coordenada);
		casillero.agregarDisparo(disparo1);
		Disparo disparo2 = new PorContacto(coordenada);
		casillero.agregarDisparo(disparo2);

		Assert.assertTrue(casillero.getDisparos().get(0) == disparo1);
		Assert.assertTrue(casillero.getDisparos().get(1) == disparo2);
	}

	@Ignore
	// El test pasa con casillero.tieneBarcosNoDestruidos() == true
	@Test
	public void tieneBarcosNoDestruidosTest(){
		Casillero casillero = new Casillero(new Coordenada(4,8));
		Nave lancha = new Lancha();
		casillero.agregarNave(lancha);
		
		Assert.assertTrue(casillero.tieneBarcosNoDestruidos());
	}
}
