package test.model.disparos;

import main.model.disparos.Disparo;
import main.model.disparos.TripleConRetardo;
import org.junit.Assert;
import org.junit.Test;

public class TripleConRetardoTest {
	@Test
	public void TripleConRetardoCostoYRadioTest(){
		Disparo disparo = new TripleConRetardo();
		Assert.assertTrue(disparo.getCosto() == 125);
		Assert.assertTrue(disparo.getRadio() == 2);
	}
}
