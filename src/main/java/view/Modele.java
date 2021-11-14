package view;

import java.util.ArrayList;
import java.util.List;

public class Modele {

	/**
	 * 
	 */
	ArrayList<Face> listeFaces ;
	ArrayList<Point> listPoints ;
	
	public Modele(ArrayList<Face> listeFaces, ArrayList<Point> listPoints) {
		super();
		this.listeFaces = listeFaces;
		this.listPoints = listPoints;
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

}
