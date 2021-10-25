package repereTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import repere.Repere;

class RepereTest {

	@Test
	void test() throws Exception {
		Repere repere=new Repere();
		repere.turnOnYAxisOf(90);
		
		assertArrayEquals(repere.matrice.points, new double[][] {{0,0,-1,0},
														  {0,1,0,0},
														  {1,0,0,0},
														  {0,0,0,1}
														});

		repere.turnOnYAxisOf(-90);
		repere.turnOnXAxisOf(180);
		assertArrayEquals(repere.matrice.points, new double[][] {{1,0,0,0},
														  {0,-1,0,0},
														  {0,0,-1,0},
														  {0,0,0,1}
														 });
		
		repere=new Repere();
		repere.turnOnYAxisOf(180);
		repere.turnOnXAxisOf(270);
		
		assertArrayEquals(repere.matrice.points, new double[][] {{-1,0,0,0},
														  {0,0,-1,0},
														  {0,-1,0,0},
														  {0,0,0,1}
														 });
		repere=new Repere();
		repere.turnOnYAxisOf(45);
		double arrondiSqrtDeux=(double)Math.round((Math.sqrt(2)*10000))/10000;
		System.out.println(arrondiSqrtDeux/2);
		System.out.println("\n--------\n"+Arrays.toString(repere.matrice.points[0]));
		System.out.println(Arrays.toString(repere.matrice.points[1]));
		System.out.println(Arrays.toString(repere.matrice.points[2]));
		System.out.println(Arrays.toString(repere.matrice.points[3]));
		assertArrayEquals(repere.matrice.points, new double[][] {{arrondiSqrtDeux/2,0,-1*arrondiSqrtDeux/2,0},
			  {0,1,0,0},
			  {arrondiSqrtDeux/2,0,arrondiSqrtDeux/2,0},
			  {0,0,0,1}
			 });
		
	}
	
	@Test
	void translationTest() throws Exception {

		Repere repere=new Repere();
		repere.translation(5, 10, 3);
		assertArrayEquals(repere.matrice.points, new double[][] {{1,0,0,5},
														  {0,1,0,10},
														  {0,0,1,3},
														  {0,0,0,1}});
	}
	@Test
	void homotetieTest() throws Exception {

		Repere repere=new Repere();
		repere.homotetie(0.5);
		assertArrayEquals(repere.matrice.points, new double[][] {{0.5,0,0,0},
														  {0,0.5,0,0},
														  {0,0,0.5,0},
														  {0,0,0,1}});
		repere=new Repere();
		repere.translation(2, 1, 0);

		System.out.println("\n--------\n"+Arrays.toString(repere.matrice.points[0]));
		System.out.println(Arrays.toString(repere.matrice.points[1]));
		System.out.println(Arrays.toString(repere.matrice.points[2]));
		System.out.println(Arrays.toString(repere.matrice.points[3]));
		repere.homotetie(2);
		System.out.println("\n--------\n"+Arrays.toString(repere.matrice.points[0]));
		System.out.println(Arrays.toString(repere.matrice.points[1]));
		System.out.println(Arrays.toString(repere.matrice.points[2]));
		System.out.println(Arrays.toString(repere.matrice.points[3]));
		assertArrayEquals(repere.matrice.points, new double[][] {{2,0,0,4},
			  {0,2,0,2},
			  {0,0,2,0},
			  {0,0,0,1}});
	}

}
