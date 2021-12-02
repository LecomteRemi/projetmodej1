package utilitaire;

public class TrigonometrieSimplifiee {
	private static final int PRECISION=1000000;
	public static double cos(double degree) {
		return (double)Math.round(Math.cos( Math.toRadians(degree))*PRECISION)/PRECISION;
	}
	public static double sin(double degree) {
		return (double)Math.round(Math.sin( Math.toRadians(degree))*PRECISION)/PRECISION;
	}
	

}
