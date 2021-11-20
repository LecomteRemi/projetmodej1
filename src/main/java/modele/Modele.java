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
	protected ArrayList<Face> listeFaces ;
	protected ArrayList<Point> listPoints ;
	protected Repere repere;
	
	public Modele(ArrayList<Face> listeFaces, ArrayList<Point> listPoints) {
		super();
		this.listeFaces = listeFaces;
		this.listPoints = listPoints;
		try {
			this.repere=new Repere();
		} catch (Exception e) {};
	}

	public ArrayList<Face> getListeFaces() {
		return listeFaces;
	}

	public void setListeFaces(ArrayList<Face> listeFaces) {
		this.listeFaces = listeFaces;
	}

	public ArrayList<Point> getListPoints() {
		return listPoints;
	}

	public void setListPoints(ArrayList<Point> listPoints) {
		this.listPoints = listPoints;
	}
	public void updatePoint() throws Exception {
		for (Point point : listPoints) {
			point.transform(repere);
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
		for (Point point : listPoints) {
			y+=point.getCurrentY();
			x+=point.getCurrentX();
			z+=point.getCurrentZ();
		}
		y=y/listPoints.size();
		x=x/listPoints.size();
		z=z/listPoints.size();
		return new Point(new double[] {x,y,z});
	}
	

}
