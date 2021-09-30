package repere;

import utilitaire.Matrice;

public class Repere {
	double[][] matrice;
	
	public Repere(double[][] matrice) throws Exception {
		if(!matriceRepereValide(matrice)) {
			throw new Exception("La matrice du repere n'est pas valide");
		}
		this.matrice=matrice;
	}
	
	public double[] getPointInRepere(double[] point) throws Exception {
		double[][] pointMatrice=new double[1][4];
		pointMatrice[0]=point;
		double[][]pointInRepere=Matrice.multiplication(pointMatrice, this.matrice);
		return pointInRepere[0];
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
}
