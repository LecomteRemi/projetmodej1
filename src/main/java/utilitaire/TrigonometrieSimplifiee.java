package utilitaire;

public class TrigonometrieSimplifiee {
	private static int precision=1000000;
	public static double cos(double degree) {
		return (double)Math.round(Math.cos( Math.toRadians(degree))*precision)/precision;
	}
	public static double sin(double degree) {
		return (double)Math.round(Math.sin( Math.toRadians(degree))*precision)/precision;
	}
	

}
