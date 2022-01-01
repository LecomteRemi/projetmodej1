package modele;

import java.util.ArrayList;
import java.util.List;

import utilitaire.Vecteur;

public class Tranche {
	protected List<Point> pointList;
	protected Modele modele;
	protected double zSliceCoordonnee;
	public Tranche(Modele modele, double zSliceCoordonne) {
		this.modele=modele;
		this.zSliceCoordonnee=zSliceCoordonne;
		pointList=getPoitOfTheSlice(modele, zSliceCoordonne);
	};

	
	protected List<Point> getPoitOfTheSlice(Modele modele, double zSliceCoordonne) {
		List<Point> res=new ArrayList<>();
		for (Point[] segment : modele.getSegment()) {
			Point point=pointOfASlice(segment[0], segment[1], zSliceCoordonne);
			if(point!=null) {
				res.add(point);
			}
		}
		return res;
	}


	public Point pointOfASlice(Point p1, Point p2, double zSliceCoordonnee) {
		if(isSliceBetweenTwoPoint(p1, p2, zSliceCoordonnee)) {
			double zDistanceBetweenPoint=p2.getZ()-p1.getZ();
			Vecteur vector=new Vecteur(p1, p2);
			double zDistanceBetweenPointAndSlice=zSliceCoordonnee-p1.getZ();
			vector=vector.divide(zDistanceBetweenPoint/zDistanceBetweenPointAndSlice);
			return p1.translate(vector);
		}else{
			return null;
		}
	}
	
	public boolean isSliceBetweenTwoPoint(Point p1, Point p2, double zSliceCoordonnee) {
		boolean res;
		if(zSliceCoordonnee>=p1.getZ() && zSliceCoordonnee<=p2.getZ()) {
			res=true;
		}else if(zSliceCoordonnee<=p1.getZ() && zSliceCoordonnee>=p2.getZ()) {
			res=true;
		}else {
			res=false;
		}
		return res;
	}
	
	public void updatePoint() {
		pointList=getPoitOfTheSlice(modele, zSliceCoordonnee);
	}
	
	public List<Point> getPointList(){
		return this.pointList;
	}
	

}
