package repere;

import utilitaire.Matrice;

public class SymetricMatrixFactory {
	public Matrice SymetricMatrix(String plan) throws Exception {
		double[][] res= new double[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		for(int i=0; i<plan.length();i++) {
			char car=plan.charAt(i);
			if(car=='x') {
				res[0][0]=-1;
			}else if(car=='y') {
				res[1][1]=-1;
			}else if(car=='z') {
				res[2][2]=-1;
			}else {
				throw new Exception("veuillez mettre seulement les caracteres 'x', 'y' ou 'z' dans la chaine de caracteres");
			}
		}
		return new Matrice(res);
	}
}
