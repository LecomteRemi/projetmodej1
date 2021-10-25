package lecture;

public class Point {
	private float x;
	private float y;
	private float z;
	//couleurs a ajouter plus tard
	
	public Point(float x, float y, float z) {
		this.x = x; this.y = y; this.z=z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public String toString() {
		return "x= "+getX()+" y= "+getY()+" z= "+getZ();
	}
	
	/*public static ArrayList<Point> creation_points() {
		String line;
		ArrayList<Point> points = new ArrayList<Point>();
		try(BufferedReader br = new BufferedReader(new FileReader("./src/main/java/lecture/coordonnes.txt"))) {
			line = br.readLine();
			while(line!=null) {
				String [] nb;
				nb = line.split(" ");
				//Scanner scanner = new Scanner(nb[0]);
				float [] coordonnees = new float[nb.length];
				for(int i=0;i<nb.length&&nb[i]!=null;i++) {
						coordonnees[i] = Float.parseFloat(nb[i]);
						//scanner = new Scanner(nb[i]);
						System.out.println("fait");
				}
				//System.out.println("j'essaie");
				points.add(new Point(coordonnees[0],coordonnees[1],coordonnees[2]));
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Une erreur est survenue");
			e.printStackTrace();
		}
		return points;
	}*/
	
}
