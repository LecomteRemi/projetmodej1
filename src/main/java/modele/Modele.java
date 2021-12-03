package modele;

import java.util.ArrayList;
import java.util.List;

import controle.Repere;
import utilitaire.Subject;

public class Modele extends Subject {

	/**
	 * 
	 */
	protected List<Face> listeFaces ;
	protected List<Point> listePoints ;
	protected Repere repere;
	protected AffichageMode affichageMode;
	protected double ecart;
	
	public Modele(List<Face> listeFaces, List<Point> listPoints) {
		super();
		this.listeFaces = listeFaces;
		this.listePoints = listPoints;
		try {
			this.repere=new Repere();
		} catch (Exception e) {};
		this.toBarycenter();
		affichageMode=AffichageMode.COMPLET;
		ecart=maxEcart();
	}

	public List<Face> getListeFaces() {
		return listeFaces;
	}

	public void setListeFaces(ArrayList<Face> listeFaces) {
		this.listeFaces = listeFaces;
	}

	public List<Point> getListPoints() {
		return listePoints;
	}

	public void setListPoints(ArrayList<Point> listPoints) {
		this.listePoints = listPoints;
	}
	public void updatePoint() throws Exception {
		for (Point point : listePoints) {
			point.transform(repere);
		}
		for (Face face : listeFaces) {
			face.calculBarycenter();
		}
		this.notifyObservers();
	}
	public void turnOnXAxis(double degree) throws Exception {
		this.repere.turnOnXAxisOf(degree);
		updatePoint();
	}
	public void turnOnYAxis(double degree) throws Exception {
		this.repere.turnOnYAxisOf(degree);
		updatePoint();
	}
	public void turnOnZAxis(double degree) throws Exception {
		this.repere.turnOnZAxisOf(degree);
		updatePoint();
	}
	public void turnOnXAxisAroundAPoint(double degree, Point point) throws Exception {
		this.repere.turnOnXAxisAroundAPoint(degree, point);
		updatePoint();
	}
	public void turnOnYAxisAroundAPoint(double degree, Point point) throws Exception {
		this.repere.turnOnYAxisAroundAPoint(degree, point);
		updatePoint();
	}
	public void turnOnZAxisAroundAPoint(double degree, Point point) throws Exception {
		this.repere.turnOnZAxisAroundAPoint(degree, point);
		updatePoint();
	}
	public void homotetie(double factor) throws Exception {
		this.repere.homotetie(factor);
		updatePoint();
	}
	public void translation(double x, double y, double z) throws Exception {
		this.repere.absoluteTranslation(x,y,z);
		updatePoint();
	}
	public Point getBarycenter() {
		double y=0;
		double x=0;
		double z=0;
		for (Point point : listePoints) {
			x+=point.getX();
			y+=point.getY();
			z+=point.getZ();
		}
		y=y/listePoints.size();
		x=x/listePoints.size();
		z=z/listePoints.size();
		return new Point(new double[] {x,y,z});
	}
	
	public AffichageMode getAffichageMode() {
		return this.affichageMode;
	}
	
	public void setAffichageMode(AffichageMode mode) {
		this.affichageMode=mode;
		this.notifyObservers();
	}
	protected double maxEcart() {
		double max=0;
		double min=0;
		for (Point p : listePoints) {
			if(p.x>max) {
				max=p.x;
			} 
			if(p.x<min) {
				min=p.x;
			}
			if(p.y>max) {
				max=p.y;
			} 
			if(p.y<min) {
				min=p.y;
			}
			if(p.z>max) {
				max=p.z;
			} 
			if(p.z<min) {
				min=p.z;
			}
		}
		return max-min;
		
	}
	public double getEcart() {
		return ecart;
	}
	
	public void toBarycenter() {
		Point barycenter=this.getBarycenter();
		try {
			this.translation(-1*barycenter.getX(), -1*barycenter.getY(), -1*barycenter.getZ());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}