package utilitaire;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import utilitaire.Matrice;

class MatriceTest {

	@Test
	void additionTest() throws Exception {
		double[][] m1=new double[][] {{2,5},{6,8},{2,4}};
		double[][] m2=new double[][] {{1,9},{2,8},{6,11}};
		double[][] m3=new double[][] {{2,5},{6,8},{4,3},{5,3}};
		double[][] m4=new double[][] {{2,5,6},{8,4,3},{5,3,5}};
		assertArrayEquals(new double[][] {{3,14},{8,16},{8,15}}, Matrice.addition(m1, m2));
		assertThrows(Exception.class, () -> {
			Matrice.addition(m1, m3);
		});
		assertThrows(Exception.class, () -> {
			Matrice.addition(m1, m4);
		});
	}
	
	@Test
	void multiplicationTest() throws Exception {
		double[][] m1= new double[][] {{1,0},
								 {0,1}};
		double[][] m2= new double[][] {{2,4},
								 {5,8}};
		double[][] m3=new double[][] {{5,2,4},
								{2,5,8}};
		assertArrayEquals(m2, Matrice.multiplication(m1, m2));
		assertArrayEquals(new double[][] {{18,24,40},{41,50,84}}, Matrice.multiplication(m2, m3));
		assertThrows(Exception.class, () -> {
			Matrice.multiplication(m3, m2);
		});
		
		
	}

}
