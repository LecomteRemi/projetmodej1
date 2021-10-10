package repere;

import utilitaire.TrigonometrieSimplifiee;

import java.util.Arrays;

import utilitaire.Matrice;


public class Repere {
	public double[][] matrice;
	
	public Repere() throws Exception {
		this.matrice=new double[][] {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
	}
	
	public double[] getPointInRepere(double[] point) throws Exception {
		double[][] pointMatrice=new double[1][4];
		pointMatrice[0]=point;
		double[][]pointInRepere=Matrice.multiplication(pointMatrice, this.matrice);
		return pointInRepere[0];
	}
	
	public void turnOnYAxisOf(double degree) throws Exception {
		double[][] mat=new double[][] {{TrigonometrieSimplifiee.cos(degree),0,-1*TrigonometrieSimplifiee.sin(degree),0},
									   {0,1,0,0},
									   {TrigonometrieSimplifiee.sin(degree),0,TrigonometrieSimplifiee.cos(degree),0},
									   {0,0,0,1}};
		double[][] newMatrice=Matrice.multiplication(mat, this.matrice);
		this.matrice=newMatrice;
	}
	public void turnOnXAxisOf(double degree) throws Exception {
		double[][] mat=new double[][] {{1,0,0,0},
									  {0,TrigonometrieSimplifiee.cos(degree),-1*TrigonometrieSimplifiee.sin(degree),0},
									  {0,TrigonometrieSimplifiee.sin(degree),TrigonometrieSimplifiee.cos(degree),0},
									  {0,0,0,1}};
			   double[][] newMatrice=Matrice.multiplication(mat, this.matrice);
			   this.matrice=newMatrice;
	}
	
	public void translation(double x, double y, double z) {
		this.matrice[0][3]+=x;
		this.matrice[1][3]+=y;
		this.matrice[2][3]+=z;
	}
	public void homotetie(double factor) throws Exception {
		double[][] homotetieMatrice=new double[][] {{factor,0,0,0},
													{0,factor,0,0},
													{0,0,factor,0},
													{0,0,0,1}};
		this.matrice=Matrice.multiplication(this.matrice, homotetieMatrice);
	}
	
	
	public double[] getVector(int col) {
		double[] res=new double[3];
		for(int i=0;i<3;i++) {
			res[i]=this.matrice[i][col];
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
			this.matrice[i][col]=coord[i];
		}
		System.out.println(Arrays.deepToString(this.matrice));
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
	
}
