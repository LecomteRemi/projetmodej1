package utilitaire;

import java.util.Arrays;

import javafx.scene.canvas.Canvas;

public class DrawnTriangle {
	public void draw(double[] x, double[] y, Canvas canvas) {
		double a1=(y[0]-y[1])/(x[0]-x[1]);
		double b1=y[0]-a1*x[0];
		double a2=(y[0]-y[2])/(x[0]-x[2]);
		double b2=y[0]-a2*x[0];
		double maxX=0;
		double minX=0;
		double maxY=0;
		double minY=0;
		Double d;
		for(int i=0; i<x.length;i++) {
			double currentX=x[i];
			double currentY=y[i];
			maxX=currentX>maxX?currentX:maxX;
			maxY=currentY>maxY?currentY:maxY;
			minX=currentX<minX?currentX:minX;
			minY=currentY<minY?currentY:minY;
		}
	}
}
