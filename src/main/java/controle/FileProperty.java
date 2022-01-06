package controle;

import java.io.File;

import modele.Lecture;

public class FileProperty {
	protected String path;
	protected String name;
	protected int nbFace;
	protected int nbPoint;
	
	
	public FileProperty(String fileName) {
		int[] nbPointAndFace=new Lecture().getNbPointAndFace("exemples"+File.separator+fileName);
		this.name=fileName.substring(0, fileName.length()-4);
		this.path="exemples"+File.separator+fileName;
		this.nbPoint=nbPointAndFace[0];
		this.nbFace=nbPointAndFace[1];
		
	}
	public String getPath() {
		return path;
	}
	public String getName() {
		return name;
	}
	public int getNbFace() {
		return nbFace;
	}
	public int getNbPoint() {
		return nbPoint;
	}
	
	
}
