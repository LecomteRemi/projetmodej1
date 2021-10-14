package lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Point {
	private double x;
	private double y;
	private double z;
	//couleurs a ajouter plus tard
	
	public Point(double x, double y, double z) {
		this.x = x; this.y = y; this.z=z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public static ArrayList<Point> creation_points() {
		String line;
		ArrayList<Point> points = new ArrayList<Point>();
		try(BufferedReader br = new BufferedReader(new FileReader("./src/main/java/lecture/coordonnes.txt"))) {
			line = br.readLine();
			while(line!=null) {
				String [] nb;
				nb = line.split(" ");
				Scanner scanner = new Scanner(nb[0]);
				double [] coordonnees = new double[nb.length];
				for(int i=0;scanner.hasNextDouble();i++) {
						coordonnees[i] = scanner.nextDouble();
						scanner = new Scanner(nb[i]);
						System.out.println("fait");
				}
				//System.out.println("bon");
				points.add(new Point(coordonnees[0],coordonnees[1],coordonnees[2]));
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Une erreur est survenue");
			e.printStackTrace();
		}
		return points;
	}
	
		
	public static void main(String[]args) {
			System.out.println(creation_points());
	}
	
	

}
