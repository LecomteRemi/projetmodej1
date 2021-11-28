package view;


import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.FaceComparator;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;

public class View extends Canvas implements Observer{
	protected FaceComparator faceComparator;
	protected Modele modele;
	
	public View(double width, double height, FaceComparator faceComparator, Modele modele) {
		super(width, height);
		this.faceComparator = faceComparator;
		this.modele = modele;
		DrawModele(modele);
	}
	
	@Override
	public void update(Subject subj) {
		DrawModele(modele);
	}

	@Override
	public void update(Subject subj, Object data) {
		DrawModele(modele);
	}
	
	protected void DrawModele(Modele modele) {
		List<Face> faceList=modele.getListeFaces();
		faceList.sort(faceComparator);
		//this.faceSorter.sort(faceList);
		GraphicsContext gc= this.getGraphicsContext2D();
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    	
		
		//faceSorter.sort(listeface); 
		for (Face face : modele.getListeFaces()) {
			double[] x=new double[3];
			double[] y=new double[3];
			for(int i=0; i<face.getPoints().size(); i++) {
				Point point=face.getPoints().get(i);
				x[i]=faceComparator.getX2D(point)+this.getWidth()/2;
				y[i]=-1*(faceComparator.getY2D(point))+this.getHeight()/2;

			}
			gc.strokePolygon(x, y, face.getPoints().size());
			gc.setFill(Color.LIME);
			gc.fillPolygon(x, y, face.getPoints().size());
		}
		
	}
}
