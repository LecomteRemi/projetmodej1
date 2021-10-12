package triangle;

public class Point {
	double x ;
	double y ;
	
	public Point(double x, double y) {
		this.x = x ; 
		this.y = y;
	}
	
	public Point( Point p ){
		this.x = p.x ;
		this.y = p.y ;
	}
	
	public double getX() {
		return this.x;
	}
	
	
	public double getY() {
		return this.y;
	}
	
	public void setX( int x ){
		this.x = x ;
	}
		public void setY( int y ){
		this.y = y ;
	}
	public String toString(){
		return( "(" + x + "," + y + ")" ) ;
	}
	
	public void translate( int dx , int dy ){
		x = x + dx ;
		y = y + dy ;
	}
	
}