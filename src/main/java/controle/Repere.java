package controle;

import utilitaire.TrigonometrieSimplifiee;
import utilitaire.Matrice;

import java.util.Arrays;

import modele.Point;


public class Repere {
	public Matrice matrice;
	
	public Repere() throws Exception {
		this.matrice=new Matrice(new double[][] {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}});
	}
	
	public double[] getCoordonneeInRepere(double[] coordonnee) throws Exception {
		double[][] coordonneeInMatrice=new double[4][1];
		for(int i=0;i<3;i++) {
			coordonneeInMatrice[i][0]=coordonnee[i];
		}
		coordonneeInMatrice[3][0]=1;
		double[][]coordonneeInRepere=matrice.multiplication(coordonneeInMatrice).points;
		return new double[] {coordonneeInRepere[0][0],coordonneeInRepere[1][0],coordonneeInRepere[2][0]};
	}
	public Point getPointInRepere(Point point) throws Exception{
		double[] coordonnee=point.getMatricialCoordonnnee();
		double[] coordonneeInRepere=this.getCoordonneeInRepere(coordonnee);
		Point res=new Point(coordonneeInRepere);
		return res;
	}
	
	public void turnOnYAxisOf(double degree) throws Exception {
		Matrice matriceTemporaire=new Matrice(new double[][] {{TrigonometrieSimplifiee.cos(degree),0,-1*TrigonometrieSimplifiee.sin(degree),0},
									   {0,1,0,0},
									   {TrigonometrieSimplifiee.sin(degree),0,TrigonometrieSimplifiee.cos(degree),0},
									   {0,0,0,1}});
		this.matrice=matriceTemporaire;
	}
	public void turnOnXAxisOf(double degree) throws Exception {
		Matrice matriceTemporaire=new Matrice(new double[][] {{1,0,0,0},
									  {0,TrigonometrieSimplifiee.cos(degree),-1*TrigonometrieSimplifiee.sin(degree),0},
									  {0,TrigonometrieSimplifiee.sin(degree),TrigonometrieSimplifiee.cos(degree),0},
									  {0,0,0,1}});
			   this.matrice=matriceTemporaire;
	}
	
	public void translation(double x, double y, double z) throws Exception {
		Matrice matriceTemporaire=new Matrice(new double[][]{{1,0,0,x},{0,1,0,y},{0,0,1,z},{0,0,0,1}});
		this.matrice=matriceTemporaire;
	}
	
	public void homotetie(double factor) throws Exception {
		Matrice matriceTemporaire=new Matrice(new double[][] {{factor,0,0,0},
													{0,factor,0,0},
													{0,0,factor,0},
													{0,0,0,1}});
		this.matrice=matriceTemporaire;
	}
	
	public void homotetieFromAPoint(double factor, Point point) throws Exception {
		this.translation(-1*point.getX(), -1*point.getY(), -1*point.getZ());
		this.homotetie(factor);
		this.translation(point.getX(), point.getY(), point.getZ());
	}
	
	public double[] getVector(int col) {
		double[] res=new double[3];
		for(int i=0;i<3;i++) {
			res[i]=this.matrice.points[i][col];
		}
		return res;
	}
	
	public double[] getVectorX() {
		return this.getVector(0);
	}
	
	public double[] getVectorY() {
		return this.getVector(1);
	}
	
	public double[] getVectorZ() {
		return this.getVector(2);
	}
	
	public void setVector(double[] coord,int col) {
		for(int i=0;i<3;i++) {
			this.matrice.points[i][col]=coord[i];
		}
	}
	
	public void setVectorX(double[] coord) {
		this.setVector(coord,0);
	}
	
	public void setVectorY(double[] coord) {
		this.setVector(coord,1);
	}
	
	public void setVectorZ(double[] coord) {
		this.setVector(coord,2);
	}
	
	public static boolean matriceRepereValide(double[][] matrice) {
		boolean res=true;
		if(matrice.length!=4 ||matrice[0].length!=4) {
			return false;
		}
		double[] derniereLigne=matrice[matrice.length-1];
		if(derniereLigne[derniereLigne.length-1]!=1.0) {
			return false;
		}

		for(int i=0; i<derniereLigne.length-1 && res; i++){
			if(derniereLigne[i]!=0) {
				res=false;
			}
		}

		return res;
	}

	public void symetry(String plan) throws Exception {
		SymetricMatrixFactory factory=new SymetricMatrixFactory();
		Matrice matriceTemporaire=factory.SymetricMatrix(plan);
		this.matrice=matriceTemporaire;
	}
	public void symetryFromAPoint(String plan, Point point) throws Exception {
		this.translation(-1*point.getX(), -1*point.getY(), -1*point.getZ());
		this.symetry(plan);
		this.translation(point.getX(), point.getY(), point.getZ());
		
	}

	public void turnOnZAxisOf(double degree) throws Exception {
		Matrice matriceTemporaire=new Matrice(new double[][] {
			  {TrigonometrieSimplifiee.cos(degree),-1*TrigonometrieSimplifiee.sin(degree),0,0},
			  {TrigonometrieSimplifiee.sin(degree),TrigonometrieSimplifiee.cos(degree),0,0},
			  {0,0,1,0},
			  {0,0,0,1}});
		this.matrice=matriceTemporaire;
		
	}
	
}
