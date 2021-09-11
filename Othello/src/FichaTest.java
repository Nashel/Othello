import static org.junit.Assert.*;

import org.junit.Test;

public class FichaTest {

	Ficha ficha1 = new Ficha(0);
	Ficha ficha2 = new Ficha(1);
	Ficha ficha3 = new Ficha(2);
	Ficha ficha4 = new Ficha(-1);
	
	@Test
	public void cambiaPiezaTest() {
		
		ficha1.cambiaPieza();
		assertEquals(true,ficha1.getPieza());
		
		ficha2.cambiaPieza();
		assertEquals(false,ficha2.getPieza());
		
		ficha2.cambiaPieza();
		assertEquals(true,ficha2.getPieza());
		
		// Valors frontera exteriors		
		ficha3.cambiaPieza();
		assertEquals(false,ficha3.getPieza());
		
		ficha4.cambiaPieza();
		assertEquals(false,ficha4.getPieza());
	}
	
	@Test
	public void toStringTest() {
		
		assertEquals("X",ficha1.toString());
		
		assertEquals("O",ficha2.toString());
		
		// Valors frontera exteriors
		assertEquals("O",ficha3.toString());

		assertEquals("O",ficha4.toString());
	}
	

}
