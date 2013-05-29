package test.model.disparos;

import org.junit.Assert;
import org.junit.Test;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;

public class DisparoConvencionalTest {
	@Test
	public void DisparoConvencionalCostoYRadioTest(){
		Disparo disparo = new DisparoConvencional();
		Assert.assertTrue(disparo.getCosto() == 200);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
}
