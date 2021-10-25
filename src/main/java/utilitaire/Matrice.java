package utilitaire;

public class Matrice {
	public double[][] points;

	public Matrice(int nbLigne, int nbColonne) {
		points = new double[nbLigne][nbColonne];
	}

	public Matrice(double[][] points) {
		this.points = points;
	}

	public Matrice addition(Matrice other) throws Exception {
		if (this.points.length == other.points.length && this.points[0].length == other.points[0].length) {
			double[][] res = new double[this.points.length][this.points[0].length];
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[0].length; j++) {
					res[i][j] = this.points[i][j] + other.points[i][j];
				}
			}
			return new Matrice(res);
		} else {
			throw new Exception("Le nombre de colonne et/ou de ligne des matrices sont différents");
		}
	}

	public Matrice multiplication(Matrice other) throws Exception {
		return this.multiplication(other.points);
	}

	public Matrice multiplication(double[][] points) throws Exception {
		if (this.points[0].length == points.length) {
			double[][] res = new double[this.points.length][points[0].length];
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[0].length; j++) {
					res[i][j] = this.additionLigneColonne(points, i, j);
				}
			}
			return new Matrice(res);
		} else {
			throw new Exception(
					"Le nombre de colonne la premiere matrice et different du nombre le ligne de la seconde.");
		}
	}

	public double additionLigneColonne(double[][] otherMatrice, int lig, int col) {
		double res = 0;
		for (int i = 0; i < this.points[0].length; i++) {
			res += this.points[lig][i] * otherMatrice[i][col];
		}
		return res;
	}
}
