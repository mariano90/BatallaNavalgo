package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.PuntualConRetardo;
import org.junit.Assert;
import org.junit.Test;

public class PuntualConRetardoTest {
	@Test
	public void PuntualConRetardoCostoYRadioTest(){
		Disparo disparo = new PuntualConRetardo();
		Assert.assertTrue(disparo.getCosto() == 50);
		Assert.assertTrue(disparo.getRadio() == 0);
	}
}
