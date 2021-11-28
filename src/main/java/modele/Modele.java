package modele;

import java.util.ArrayList;
import java.util.List;

import controle.Repere;
import utilitaire.Subject;
import view.Face;

public class Modele extends Subject {

	/**
	 * 
	 */
	protected List<Face> listeFaces ;
	protected List<Point> listePoints ;
	protected Repere repere;
	
	public Modele(List<Face> listeFaces, List<Point> listPoints) {
		super();
		this.listeFaces = listeFaces;
		this.listePoints = listPoints;
		try {
			this.repere=new Repere();
		} catch (Exception e) {};
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
	

}
