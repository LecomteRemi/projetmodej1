package lecture;

import java.util.ArrayList;

public class Face {
	private ArrayList<Point> points;
	private int nb_points;
	
	public Face(ArrayList<Point> p, int np) {
		this.points = p; this.nb_points = np;
	}

	public ArrayList<Point> getPoints() {
		return points; 
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public int getNb_points() {
		return nb_points;
	}

	public void setNb_points(int nb_points) {
		this.nb_points = nb_points;
	}

	@Override
	public String toString() {
		return "Face [points=" + points + ", nb_points=" + nb_points + "]";
	}
	
	
	
}
