package modele;

public class Eclairage {
	public double[] getN(Point[] points) {
		return null;
	}
	public double brightCoeff(double[] normal, double[] lightVector) {
		double scalaire=0;
		for(int i=0; i<3; i++) {
			scalaire+=normal[i]*lightVector[i];
			
		}
	}
}
