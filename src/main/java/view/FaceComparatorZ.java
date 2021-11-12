package view;


import java.util.ArrayList;
import java.util.Comparator;

public class FaceComparatorZ implements Comparator<Face>{

	@Override
	public int compare(Face t1, Face t2) {
		ArrayList <Point> points1=t1.getPoints();
		ArrayList <Point> points2=t2.getPoints();
		for(int i=0; i<points1.size();i++) {
			if(points1.get(i).getZ()>points2.get(i).getZ()) {
				return 1;
			}else if(points1.get(i).getZ()>points2.get(i).getZ()) {
				return -1;
			}
		}
		return 0;
	}
	
}
