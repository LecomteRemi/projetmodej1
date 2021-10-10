package triangle;
import java.lang.Math;
public class Point {
	
	private double x, y;
	public Point(){
		
		assign(0.0, 0.0);
	}
	public Point(double x, double y){
		assign(x, y);
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void assign(double x, double y){
		x = x;
		y = y;
	}
	public void afficher(){
		System.out.print("("+getX()+","+getY()+")");
	}
	public String str(){
		return "("+getX()+", "+getY()+")";
	}
	public double distance(Point p2){
		double dx = (getX()-p2.getX());
		double dy = (getY()-p2.getY());
		return Math.sqrt(dx*dx + dy*dy);
	}
	public void translater(double dx, double dy){
		x += dx;
		y += dy;
	}
}