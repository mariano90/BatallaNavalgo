package test.model.naves;

import junit.framework.Assert;
import main.model.naves.Parte;
import main.model.tablero.Coordenada;
import org.junit.Test;

public class ParteTest {

	@Test
	public void constructorSinParametroTest(){
		Parte parte = new Parte();

		Assert.assertFalse(parte.recibioDisparo());
		Assert.assertFalse(parte.estaDestruida());
	}

	@Test
	public void constructorConParametroTest(){
		Coordenada coordenada = new Coordenada(4,3);
		Parte parte = new Parte(coordenada);

		Assert.assertFalse(parte.recibioDisparo());
		Assert.assertFalse(parte.estaDestruida());
		Assert.assertTrue(parte.getPosicion() == coordenada);
	}

	@Test
	public void recibirDisparoTest(){
		Parte parte = new Parte();
		parte.recibirDisparo();

		Assert.assertTrue(parte.recibioDisparo());
	}

	@Test
	public void destruirTest(){
		Parte parte = new Parte();
		parte.destruir();
		
		Assert.assertTrue(parte.estaDestruida());
	}
}
