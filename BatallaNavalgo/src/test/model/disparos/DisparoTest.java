package test.model.disparos;

import junit.framework.Assert;

import main.model.disparos.DisparoConvencional;

import org.junit.Test;

public class DisparoTest {

	@Test
	public void puteTest(){
		DisparoConvencional disparo;
		disparo = new DisparoConvencional();
		Assert.assertTrue(disparo != null);
	}
	
}
