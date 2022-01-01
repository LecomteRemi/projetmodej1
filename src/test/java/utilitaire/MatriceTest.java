package utilitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatriceTest {



	@Test
	void additionTest() throws Exception {
		Matrice m1=new Matrice(new double[][] {{2,5},{6,8},{2,4}});
		Matrice m2=new Matrice(new double[][] {{1,9},{2,8},{6,11}});
		Matrice m3=new Matrice(new double[][] {{2,5},{6,8},{4,3},{5,3}});
		Matrice m4=new Matrice(new double[][] {{2,5,6},{8,4,3},{5,3,5}});
		assertArrayEquals(new double[][] {{3,14},{8,16},{8,15}}, (m1.addition(m2)).points);
		assertThrows(Exception.class, () -> {
			m1.addition( m3);
		});
		assertThrows(Exception.class, () -> {
			m1.addition( m4);
		});
	}
	
	@Test
	void multiplicationTest() throws Exception {
		Matrice m1=new Matrice(new double[][] {{1,0},
								 {0,1}});
		Matrice m2=new Matrice(new double[][] {{2,4},
								 {5,8}});
		Matrice m3=new Matrice(new double[][] {{5,2,4},
								{2,5,8}});
		assertArrayEquals(m2.points, m1.multiplication( m2).points);
		assertArrayEquals(new double[][] {{18,24,40},{41,50,84}}, m2.multiplication( m3).points);
		assertThrows(Exception.class, () -> {
			m3.multiplication(m2);
		});
		
		
	}

}
