package utilitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Point;

class VecteurTest {
	
	@Test
	void vectorCreatedByPointsTest(){
		Point p1=new Point(1, 0, 1);
		Point p2=new Point(5,-1,0);
		Vecteur res=new Vecteur(-4, 1, 1);
		assertEquals(res,new Vecteur(p1, p2));
	}
	
	@Test
	void scalaireTest()
	{

		Vecteur v1=new Vecteur(1, 0, 1);
		Vecteur v2=new Vecteur(5,-1,0);
		double res=v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
		assertEquals(res, v1.scalaire(v2));
		assertEquals(res, v2.scalaire(v1));
		
	}
	
	@Test
	void produitVectorielTest() {
		Vecteur v1=new Vecteur(1, 0, 1);
		Vecteur v2=new Vecteur(5,-1,0);
		double x=v1.y*v2.z-v1.z*v2.y;
		double y=v1.z*v2.x-v1.x*v2.z;
		double z=v1.x*v2.y-v1.y*v2.x;
		Vecteur res= new Vecteur(x, y, z);
		assertEquals(res, v1.produitVectoriel(v2));
	}

	@Test
	void normeTest() {
		Vecteur v1=new Vecteur(1, 0, 1);
		double res=Math.sqrt(v1.x*v1.x+v1.y*v1.y+v1.z*v1.z);
		assertEquals(res, v1.getNorme());
	}
	@Test
	void divideTest() {
		Vecteur v1=new Vecteur(12, 60, 1.5);
		Vecteur res=new Vecteur(4,20,0.5);
		assertEquals(res, v1.divide(3));
	}
}
