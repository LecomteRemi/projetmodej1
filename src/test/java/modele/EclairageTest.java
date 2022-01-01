package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilitaire.Vecteur;

class EclairageTest {

	@Test
	void brightCoeffTest() {
		Point p1=new Point(1,0,0);
		Point p2=new Point(-1,0,0);
		Point p3=new Point(0,1,1);
		Face f=new Face(new Point[] {p1,p2,p3});
		Vecteur lightVector=new Vecteur(0, 1, 0);
		assertEquals(Math.sqrt(2)/2, Eclairage.getInstance().brightCoeff(f, lightVector));
		lightVector=new Vecteur(0,-1,0);
		assertEquals(0, Eclairage.getInstance().brightCoeff(f, lightVector));
		
	}

}
