package repere;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepereTest {

	@Test
	void matriceRepereValidetest() {
		double[][] matrice1=new double[][] {
			{5,8,1,5},
			{2,3,7,7},
			{4,8,3,4},
			{0,0,0,1}
			
		};
		double[][] matrice2=new double[][] {
			{5,8,1,5},
			{2,3,7,7},
			{4,8,3,4},
			{0,0,0,0}
			
		};
		double[][] matrice3=new double[][] {
			{5,8,1,5},
			{2,3,7,7},
			{4,8,3,4},
			{0,0,1,1}
			
		};
		double[][] matrice4=new double[][] {
			{5,8,1,5},
			{2,3,7,7},
			{0,0,0,1}
			
		};
		double[][] matrice5=new double[][] {
			{5,8,5},
			{2,3,7},
			{4,8,4},
			{0,0,1}
			
		};
		assertTrue(Repere.matriceRepereValide(matrice1));
		assertFalse(Repere.matriceRepereValide(matrice2));
		assertFalse(Repere.matriceRepereValide(matrice3));
		assertFalse(Repere.matriceRepereValide(matrice4));
		assertFalse(Repere.matriceRepereValide(matrice5));
	}

}
