package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import modele.Modele;
import modele.Point;
import modele.Segment;
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
		List<Segment> segmentList=tranche.getSegmentList();
		int pointListSize=segmentList.size();
		for(int i=0;i<pointListSize;i++) {
			Segment segment=segmentList.get(i);
			Point p1=segment.getP1();
			Point p2=segment.getP2();

			double x1=p1.getX()*coeff+this.getWidth()/2;
			double y1=-1*p1.getY()*coeff+this.getWidth()/2;
			double x2=p2.getX()*coeff+this.getWidth()/2;
			double y2=-1*p2.getY()*coeff+this.getWidth()/2;
			this.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
			
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

		tranche.updateSegment();
		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		DrawModele(modele);
		System.out.println("oihou");
	}

	@Override
	public void update(Subject subj, Object data) {
		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		DrawModele(modele);
		System.out.println("oihou");
	}



}
