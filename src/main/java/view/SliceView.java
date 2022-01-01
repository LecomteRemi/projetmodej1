package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import modele.Modele;
import modele.Point;
import modele.Tranche;
import utilitaire.Subject;

public class SliceView extends View{
	protected Tranche tranche;

	public SliceView(double width, double height, Modele modele, double zSliceCoordonnee) {
		super(width, height, modele);
		tranche=new Tranche(modele, zSliceCoordonnee);
		DrawModele(modele);
	}

	@Override
	protected void DrawModele(Modele modele) {
		this.getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
		System.out.println("hou564");
		List<Point> pointList=tranche.getPointList();
		int pointListSize=pointList.size();
		for(int i=0;i<pointListSize;i++) {
			Point p=pointList.get(i);
			double x=p.getX()*coeff+this.getWidth()/2;
			double y=p.getY()*coeff+this.getWidth()/2;
			this.getGraphicsContext2D().strokeRect(x, y, 1, 1);
			
		}
		/*double[] xCoordonne=new double[pointListSize];
		double[] yCoordonne=new double[pointListSize];
		for(int i=0; i<pointListSize;i++) {
			xCoordonne[i]=pointList.get(i).getX()*coeff+this.getWidth()/2;
			yCoordonne[i]=pointList.get(i).getY()*coeff+this.getWidth()/2;
		}
		
		this.getGraphicsContext2D().setFill(Color.BLACK);
		this.getGraphicsContext2D().fillPolygon(xCoordonne, yCoordonne, pointListSize);*/
		
	}

	
	@Override
	public void update(Subject subj) {

		System.out.println("hou");
		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		tranche.updatePoint();
		DrawModele(modele);
		System.out.println("oihou");
	}

	@Override
	public void update(Subject subj, Object data) {
		System.out.println("ou");
		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		DrawModele(modele);
		System.out.println("oihou");
	}



}
