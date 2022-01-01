package view;


import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.AffichageMode;
import modele.Face;
import modele.FaceComparator;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;

public class View3D extends View{
	protected FaceComparator faceComparator;
	
	public View3D(double width, double height, FaceComparator faceComparator, Modele modele) {
		super(width, height, modele);
		this.faceComparator = faceComparator;
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
			int size=face.getPoints().size();
			double[] x=new double[size];
			double[] y=new double[size];
			for(int i=0; i<face.getPoints().size(); i++) {
				Point point=face.getPoints().get(i);
				x[i]=faceComparator.getX2D(point)*coeff+this.getWidth()/2;
				y[i]=-1*(faceComparator.getY2D(point))*coeff+this.getHeight()/2;

			}
			if(modele.getAffichageMode().equals(AffichageMode.COMPLET) || modele.getAffichageMode().equals(AffichageMode.FIL_DE_FER)) {
				gc.strokePolygon(x, y, face.getPoints().size());
			}
			if(modele.getAffichageMode().equals(AffichageMode.COMPLET) || modele.getAffichageMode().equals(AffichageMode.FACE)) {
				gc.setFill(face.getColor());
				gc.fillPolygon(x, y, face.getPoints().size());
			}
		}
		
	}

	
	@Override
	public void update(Subject subj) {

		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		DrawModele(modele);
	}

	@Override
	public void update(Subject subj, Object data) {
		coeff=calculCoeff(modele.getEcart(), this.getWidth(), this.getHeight());
		DrawModele(modele);
	}
}
