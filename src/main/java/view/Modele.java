package view;

import java.util.List;

public class Modele {

	/**
	 * 
	 */
	List<Face> listeFaces ;
	List<Point> listPoints ;
	
	public Modele(List<Face> listeFaces, List<Point> listPoints) {
		super();
		this.listeFaces = listeFaces;
		this.listPoints = listPoints;
	}

	public List<Face> getListeFaces() {
		return listeFaces;
	}

	public void setListeFaces(List<Face> listeFaces) {
		this.listeFaces = listeFaces;
	}

	public List<Point> getListPoints() {
		return listPoints;
	}

	public void setListPoints(List<Point> listPoints) {
		this.listPoints = listPoints;
	}

}
