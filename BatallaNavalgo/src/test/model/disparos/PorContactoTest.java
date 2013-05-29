package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.PorContacto;
import org.junit.Assert;
import org.junit.Test;

public class PorContactoTest {
	@Test
	public void PorContactoCostoYRadioTest(){
		Disparo disparo = new PorContacto();
		Assert.assertTrue(disparo.getCosto() == 150);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
}
