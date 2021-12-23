package utilitaire;

import java.util.Arrays;

import javafx.scene.canvas.Canvas;

public class DrawnTriangle {
	public void draw(double[] x, double[] y, Canvas canvas) {
		double[] a=new double[3];
		double[] b=new double[3];
		a[0]=(y[0]-y[1])/(x[0]-x[1]);
		b[0]=y[0]-a[0]*x[0];
		a[1]=(y[0]-y[2])/(x[0]-x[2]);
		b[1]=y[0]-a[1]*x[0];
		a[2]=(y[1]-y[2])/(x[1]-x[2]);
		b[2]=y[1]-a[2]*x[1];

		
	}
}
