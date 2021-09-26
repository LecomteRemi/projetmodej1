package utilitaireTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import utilitaire.Matrice;

class MatriceTest {

	@Test
	void additionTest() throws Exception {
		int[][] m1=new int[][] {{2,5},{6,8},{2,4}};
		int[][] m2=new int[][] {{1,9},{2,8},{6,11}};
		int[][] m3=new int[][] {{2,5},{6,8},{4,3},{5,3}};
		int[][] m4=new int[][] {{2,5,6},{8,4,3},{5,3,5}};
		assertArrayEquals(new int[][] {{3,14},{8,16},{8,15}}, Matrice.addition(m1, m2));
		assertThrows(Exception.class, () -> {
			Matrice.addition(m1, m3);
		});
		assertThrows(Exception.class, () -> {
			Matrice.addition(m1, m4);
		});
	}
	
	@Test
	void multiplicationTest() throws Exception {
		int[][] m1= new int[][] {{1,0},
								 {0,1}};
		int[][] m2= new int[][] {{2,4},
								 {5,8}};
		int[][] m3=new int[][] {{5,2,4},
								{2,5,8}};
		assertArrayEquals(m2, Matrice.multiplication(m1, m2));
		assertArrayEquals(new int[][] {{18,24,40},{41,50,84}}, Matrice.multiplication(m2, m3));
		assertThrows(Exception.class, () -> {
			Matrice.multiplication(m3, m2);
		});
		
		
	}

}
