package utilitaire;

public class Matrice {
	public static int[][] addition(int[][] m1, int[][] m2) throws Exception{
		if(m1.length==m2.length && m1[0].length==m2[0].length) {
			int[][] res=new int[m1.length][m1[0].length];
			for(int i=0;i<res.length;i++) {
				for(int j=0;j<res[0].length;j++) {
					res[i][j]=m1[i][j]+m2[i][j];
				}
			}
			return res;
		}else {
			throw new Exception("Le nombre de colonne et/ou de ligne des matrices sont différents");
		}
		
	}
	public static int[][] multiplication(int[][] m1, int[][] m2) throws Exception{
		if(m1[0].length==m2.length) {
			int[][] res=new int[m1.length][m2[0].length];
			for(int i=0;i<res.length;i++) {
				for(int j=0;j<res[0].length;j++) {
					res[i][j]=additionLigneColonne(m1, m2, i, j);
				}
			}
			return res;
		}else {
			throw new Exception("Le nombre de colonne la premiere matrice et different du nombre le ligne de la seconde.");
		}
		
	}
	public static int additionLigneColonne(int[][] m1, int[][] m2, int lig, int col) {
		int res=0;
		for(int i=0; i<m1[0].length;i++) {
				res+=m1[lig][i]*m2[i][col];
		}
		return res;
	}
	
}
