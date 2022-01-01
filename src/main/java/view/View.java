package view;

import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import modele.AffichageMode;
import modele.Face;
import modele.FaceComparator;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;

public abstract class  View extends Canvas implements Observer{
	protected Modele modele;
	protected double coeff;
	
	public View(double width, double height, Modele modele) {
		super(width, height);
		this.modele = modele;
		this.coeff=calculCoeff(modele.getEcart(), width, height);
		
		
	}
	
	@Override
	public abstract void update(Subject subj);

	@Override
	public abstract void update(Subject subj, Object data);
	
	protected abstract void DrawModele(Modele modele);	
	protected double calculCoeff(double ecart, double width, double height) {
		double size=width>height?height:width;
		return size/ecart;
	}
}
