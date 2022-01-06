package modele;

import java.util.ArrayList;
import java.util.List;


import utilitaire.Vecteur;

public class Tranche {
	protected List<Segment> segmentList;
	protected Modele modele;
	protected double zSliceCoordonnee;
	public Tranche(Modele modele, double zSliceCoordonne) {
		this.modele=modele;
		this.zSliceCoordonnee=zSliceCoordonne;
		segmentList=getSegmentOfTheSlice(modele, zSliceCoordonne);
	};

	
	protected List<Segment> getSegmentOfTheSlice(Modele modele, double zSliceCoordonne) {
		List<Segment> res=new ArrayList<>();
		for(Face face : modele.getListeFaces()) {
			List<Point> pointOfSliceList=new ArrayList<>();
			for(Segment segment: face.getSegment()) {
				Point point=pointOfASlice(segment.getP1(), segment.getP2(), zSliceCoordonne);
				if(point!=null) {
					pointOfSliceList.add(point);
				}
			}
			for(int i=0; i<pointOfSliceList.size(); i++) {
				for(int j=pointOfSliceList.size()-1; j>i;j--) {
					res.add(new Segment(pointOfSliceList.get(i), pointOfSliceList.get(j)));
				}
			}
			
		/*for (Point[] segment : modele.getSegment()) {
			Point point=pointOfASlice(segment[0], segment[1], zSliceCoordonne);
			if(point!=null) {
				res.add(point);
			}*/
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
	
	public void updateSegment() {
		segmentList=getSegmentOfTheSlice(modele, zSliceCoordonnee);
	}
	
	public List<Segment> getSegmentList(){
		return this.segmentList;
	}
	

}
