package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Lecture {
	
	protected ArrayList<String> pointProperty;
	protected ArrayList<String> faceProperty;
	protected ArrayList<Face> listFace;
	protected ArrayList<Point> listPoint;
	protected int nbPoint;
	protected int nbFace;
	protected String partieHeader;

	
	public Modele creation_modele(String file) throws Exception {

		pointProperty=new ArrayList<>();
		faceProperty=new ArrayList<>();
		listPoint=new ArrayList<>();
		listFace=new ArrayList<>();
		nbPoint=0;
		nbFace=0;
		partieHeader="debut";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line="";
			/*while(!"header".equals(line)){
				line=br.readLine();
				System.out.println("ok");
			}*/
			this.readHeader(br);
			this.readBody(br);
			return new Modele(listFace, listPoint);
		} catch (IOException e) {
			
		}

		return null;
		
	}
	
	private void readBody(BufferedReader br) {
		try {
			int cpt=0;
			String line="";
			while(br.ready()) {
				line=br.readLine();
					
					if(cpt<=nbPoint && line.split(" ").length==pointProperty.size()) {
						readPoint(line);
						
					}else if(cpt<=nbFace+nbPoint && line.split(" ").length>=faceProperty.size() && !line.equals("")) {
						System.out.println(faceProperty.size());
						readFace(line);
					}
					cpt++;
				
				
			}
		} catch (IOException e) {}
		
	}

	public void readHeader(BufferedReader br) throws Exception {
		String line="";
		while(!"end_header".equals(line.toLowerCase())) {
			try {
				line=br.readLine();
				if(line.length()>6 && line.substring(0, 7).equals("element")) {
					if(partieHeader.equals("debut")) {
						String[] lineSplit=line.split(" ");
						nbPoint=Integer.parseInt(lineSplit[2]);
						partieHeader="point";
					}else if(partieHeader.equals("point")) {
						partieHeader="face";
						String[] lineSplit=line.split(" ");
						nbFace=Integer.parseInt(lineSplit[2]);
					}
				}
				if(line.length()>8 && line.substring(0, 8).equals("property")) {
					if(partieHeader.equals("point")) {
						try{String type=getPointPropertyType(line);
						pointProperty.add(type);}catch(Exception e) {}
					}
					if(partieHeader.equals("face")) {
						try{String type=getFacePropertyType(line);
						faceProperty.add(type);}catch(Exception e) {
							
						}
					}
					
				}
				
				
			} catch (IOException e) {}
			
		}
	}
	
	protected String getFacePropertyType(String line) throws Exception {
		String[] lineSplit=line.split(" ");
		String type=lineSplit[2].toLowerCase();
		if(type.equals("red")) {
			return "red";
		}else if(type.equals("green")) {
			return "green";
		}else if(type.equals("blue")) {
			return "blue";
		}else if(lineSplit[1].toLowerCase().equals("list")) {
			return "list";
		}
		
		throw new Exception("Erreur: le type de cette propriete n'est pas valide!\ntype:"+type);
	}

	protected String getPointPropertyType(String line) throws Exception {
		String[] lineSplit=line.split(" ");
		String type=lineSplit[2].toLowerCase();
		if(type.equals("x")) {
			return "x";
		}else if(type.equals("y")) {
			return "y";
		}else if(type.equals("z")) {
			return "z";
		}else if(type.equals("red")) {
			return "red";
		}else if(type.equals("green")) {
			return "green";
		}else if(type.equals("blue")) {
			return "blue";
		}else if(type.equals("nx") || type.equals("ny") || type.equals("nz") || type.equals("u") || type.equals("v") ) {
			return "inconnu";
		}
		
		throw new Exception("Erreur: le type de cette propriete n'est pas valide!");
	}
	
	protected void readPoint(String line) {
		String[] lineSplit=line.split(" ");
		double x=0;
		double y=0;
		double z=0;
		double red=0;
		double blue=0;
		double green=0;
		boolean isColored=false;
		for(int i=0; i<lineSplit.length;i++) {
			String type=pointProperty.get(i);
			System.out.println(lineSplit.length);
			System.out.println(line);
			System.out.println(pointProperty.toString());
			double value=Double.parseDouble(lineSplit[i]);
			if(type.equals("x")) {
				x=value;
			}else if(type.equals("y")) {
				y=value;
			}else if(type.equals("z")) {
				z=value;
			}else if(type.equals("red")) {
				red=value;
				isColored=true;
			}else if(type.equals("green")) {
				green=value;
				isColored=true;
			}else if(type.equals("blue")) {
				blue=value;
				isColored=true;
			}
		}
		if(isColored) {
			Color color=new Color(red/255, green/255, blue/255, 1);
			listPoint.add(new Point(x, y, z, color));
		}else {
			listPoint.add(new Point(x, y, z));
		}
	}
	
	protected void readFace(String line) {
		Point[] points=null;
		boolean isColored=false;
		int idxSplit=0;
		String[] lineSplit=line.split(" ");
		double red=0;
		double blue=0;
		double green=0;
		for(int i=0; i<faceProperty.size();i++) {
			String type=faceProperty.get(i);
			
			if(type.equals("list")) {
				System.out.println(line);
				System.out.println(lineSplit[i]);
				int nbPointFace=Integer.parseInt(lineSplit[i]);
				points=new Point[nbPointFace];
				for(int j=1; j<=idxSplit+nbPointFace;j++) {
					
					points[j-1]=listPoint.get(Integer.parseInt(lineSplit[idxSplit+j]));
				}
				idxSplit+=nbPointFace;
			}else if(type.equals("red")) {
				red=Double.parseDouble(lineSplit[idxSplit]);
				isColored=true;
				idxSplit++;
			}else if(type.equals("green")) {
				green=Double.parseDouble(lineSplit[idxSplit]);
				isColored=true;
				idxSplit++;
			}else if(type.equals("blue")) {
				blue=Double.parseDouble(lineSplit[idxSplit]);
				isColored=true;
				idxSplit++;
			}
			if(isColored) {
				Color color=new Color(red/255, green/255, blue/255, 1);
				listFace.add(new Face(points, color));
			}else {
				listFace.add(new Face(points));

				System.out.println(points.length);
			}
		}
		
	}
}
