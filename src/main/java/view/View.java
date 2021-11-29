package view;


import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.AffichageMode;
import modele.FaceComparator;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;

public class View extends Canvas implements Observer{
	protected FaceComparator faceComparator;
	protected Modele modele;
	protected double coeff;
	
	public View(double width, double height, FaceComparator faceComparator, Modele modele) {
		super(width, height);
		this.faceComparator = faceComparator;
		this.modele = modele;
		coeff=calculCoeff(modele.getEcart(), width, height);
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
				x[i]=faceComparator.getX2D(point)*coeff+this.getWidth()/2;
				y[i]=-1*(faceComparator.getY2D(point))*coeff+this.getHeight()/2;

			}
			if(modele.getAffichageMode().equals(AffichageMode.COMPLET) || modele.getAffichageMode().equals(AffichageMode.FIL_DE_FER)) {
				gc.strokePolygon(x, y, face.getPoints().size());
			}
			if(modele.getAffichageMode().equals(AffichageMode.COMPLET) || modele.getAffichageMode().equals(AffichageMode.FACE)) {
				gc.setFill(Color.SKYBLUE);
				gc.fillPolygon(x, y, face.getPoints().size());
			}
		}
		
	}
	protected double calculCoeff(double ecart, double width, double height) {
		double size=width>height?height:width;
		return size/ecart;
	}
}
