package controle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Point;

class RepereTest {
	
	@Test
	public void getCoordonneeInRepereTest() {
		double[] coord=new double[] {2,1,1,1};
		double[] res=new double[] {-1,1,2};
		try {
			Repere r=new Repere();
			r.turnOnYAxisOf(90);
			coord=r.getCoordonneeInRepere(coord);
		} catch (Exception e) {}
		assertArrayEquals(res, coord);
	}
	
	@Test
	public void getPointInRepereTest() {
		Point p=new Point(2,1,1);
		Point res=new Point(-1,1,2);
		try {
			Repere r=new Repere();
			r.turnOnYAxisOf(90);
			p=r.getPointInRepere(p);
		} catch (Exception e) {}
		assertEquals(res, p);
	}
	
	@Test
	public  void turnOnYAxisTest() {
		Repere r=null;
		double[][] res= {
				{0,0,-1,0},
				{0,1,0,0},
				{1,0,0,0},
				{0,0,0,1}
		};
		try {
		r=new Repere();
		r.turnOnYAxisOf(90);
		} catch (Exception e) {
		}
		assertArrayEquals(r.matrice.points, res);
	}
	
	@Test
	public  void turnOnXAxisTest() {
		Repere r=null;
		double[][] res= {
				{1,0,0,0},
				{0,0,-1,0},
				{0,1,0,0},
				{0,0,0,1}
		};
		try {
		r=new Repere();
		r.turnOnXAxisOf(90);
		} catch (Exception e) {
		}
		assertArrayEquals(r.matrice.points, res);
	}
	
	@Test
	public  void homotetieTest() {
		Repere r=null;
		double[][] res= {
				{2,0,0,0},
				{0,2,0,0},
				{0,0,2,0},
				{0,0,0,1}
		};
		try {
		r=new Repere();
		r.homotetie(2);
		} catch (Exception e) {
		}
		assertArrayEquals(r.matrice.points, res);
	}
	
	@Test
	public void symetryTest() {
		Repere r1=null;
		Repere r2=null;
		Repere r3=null;
		Repere r4=null;
		double[][] res1= {
				{-1,0,0,0},
				{0,1,0,0},
				{0,0,1,0},
				{0,0,0,1}
		};
		double[][] res2= {
				{1,0,0,0},
				{0,-1,0,0},
				{0,0,1,0},
				{0,0,0,1}
		};
		double[][] res3= {
				{-1,0,0,0},
				{0,1,0,0},
				{0,0,-1,0},
				{0,0,0,1}
		};
		double[][] res4= {
				{-1,0,0,0},
				{0,-1,0,0},
				{0,0,-1,0},
				{0,0,0,1}
		};
		try {
		r1=new Repere();
		r2=new Repere();
		r3=new Repere();
		r4=new Repere();
		r1.symetry("x");
		r2.symetry("y");
		r3.symetry("zx");
		r4.symetry("xyz");
		} catch (Exception e) {
		}
		assertArrayEquals(r1.matrice.points, res1);
		assertArrayEquals(r2.matrice.points, res2);
		assertArrayEquals(r3.matrice.points, res3);
		assertArrayEquals(r4.matrice.points, res4);
	}

}
