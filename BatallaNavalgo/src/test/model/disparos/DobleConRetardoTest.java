package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.DobleConRetardo;
import org.junit.Assert;
import org.junit.Test;


public class DobleConRetardoTest {
	@Test
	public void ConRetardoCostoYRadioTest(){
		Disparo disparo = new DobleConRetardo();
		Assert.assertTrue(disparo.getCosto() == 100);
		Assert.assertTrue(disparo.getRadio() == 1);
	}
}
