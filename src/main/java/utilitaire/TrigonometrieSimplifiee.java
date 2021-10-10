package utilitaire;

public class TrigonometrieSimplifiee {
	public static double cos(double degree) {
		return (double)Math.round(Math.cos( Math.toRadians(degree))*10000)/10000;
	}
	public static double sin(double degree) {
		return (double)Math.round(Math.sin( Math.toRadians(degree))*10000)/10000;
	}
	

}
