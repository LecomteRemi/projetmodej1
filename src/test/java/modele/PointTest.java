package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.Repere;

class PointTest {

	@Test
	void transformTest() {
		Point p=new Point(1, 1, 0);
		Point res=new Point(0, 1, 1);
		try {
			Repere repere=new Repere();
			repere.turnOnYAxisOf(90);
			p.transform(repere);
		} catch (Exception e) {
		}
		
		assertEquals(p, res);
		
	}
}
