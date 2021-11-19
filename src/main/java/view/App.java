package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controle.Repere;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Lecture;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;
import view.Face;
import view.FaceSorter;


/**
 * JavaFX App
 */
public class App extends Application implements Observer{

	/**
	 * Attribut qui stocke une liste de points dans une collection
	 */
	public List<Point> listePoint = new ArrayList<>();
	/**
	 * Attribut qui stocke une liste de Face dans une collection
	 */
	public List<Face> listeface = new ArrayList<>();
	Modele modele;
	protected FaceSorter faceSorter= FaceSorter.faceSorterZ();
	Canvas canvas = new Canvas(300, 250);
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Projet Modelisation");
        Group root = new Group();
        //Canvas canvas = new Canvas(600, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
       modele = Lecture.creation_modele("./exemples/vache.ply");
      modele.attach(this);
      listePoint = modele.getListPoints();
      listeface = modele.getListeFaces();
      
       /*listePoint.add(new Point(-1,-1,1));
        listePoint.add(new Point(1,-1,1));
        listePoint.add(new Point(0,1,0));
        listePoint.add(new Point(0,0,0));
        listePoint.add(new Point(0,-1,-1));
        listePoint.add(new Point(5,29,6));
        listePoint.add(new Point(86,11,6));
        listePoint.add(new Point(19,69,0));
        listePoint.add(new Point(102,40,4));
        listePoint.add(new Point(11,71,3));
        listePoint.add(new Point(55,88,1));
        listePoint.add(new Point(76,15,4));
        listePoint.add(new Point(05,29,5));
        listePoint.add(new Point(93,53,7));
        listePoint.add(new Point(63,42,1));
        listePoint.add(new Point(67,74,4));
        listePoint.add(new Point(38,33,3));
        listePoint.add(new Point(64,63,5));*/
        
        
        /*listeface.add(new Face(0,1,2,listePoint));
        listeface.add(new Face(1,2,3,listePoint));
        listeface.add(new Face(2,0,3,listePoint));
        listeface.add(new Face(1,3,0,listePoint));
        listeface.add(new Face(2,5,6,listePoint));
        listeface.add(new Face(3,1,4,listePoint));
        listeface.add(new Face(1,2,3,listePoint));
        listeface.add(new Face(2,2,5,listePoint));
        listeface.add(new Face(3,1,4,listePoint));*/
        
        
        FaceSorter faceSorter = FaceSorter.faceSorterZ();
        faceSorter.sort(listeface);
        //drawTriangles(gc,listeface);

        /*
        drawShapes(gc);
        Point p1 = new Point(90,30);
        Point p2 = new Point(190,170);
        Point p3 = new Point(10,170);
        Face triangle = new Face(new Point[] {p1, p2, p3});
        triangle.drawTriangle(gc,new Point(90,30),new Point(190,170),new Point(10,170));
        */
      
        try {
		/*	Repere repere=new Repere();

=======
			Repere repere=new Repere();
			repere.turnOnYAxisOf(180);
>>>>>>> 3f13b43438d78c3a59e850ecff62445cade29b77
			//repere.turnOnYAxisOf(180);
			//repere.turnOnXAxisOf(90);
			
			for (Point point : listePoint) {
					point.transform(repere);
			}
			
			faceSorter.sort(listeface); 
        for (Face face : listeface) {
        	double[] x=new double[3];
        	double[] y=new double[3];
        	double[] x2=new double[3];
        	double[] y2=new double[3];
        	double[] x3=new double[3];
        	double[] y3=new double[3];
        	for(int i=0; i<face.getPoints().size(); i++) {
<<<<<<< HEAD
        		x[i]=face.getPoints().get(i).getCurrentX()/20+100;
        		y[i]=face.getPoints().get(i).getCurrentY()/20+100;

=======
        		x[i]=face.getPoints().get(i).getCurrentX()*20+100;
        		y[i]=face.getPoints().get(i).getCurrentY()*20+100;
        		x2[i]=face.getPoints().get(i).getCurrentX()*20+100+300;
        		y2[i]=face.getPoints().get(i).getCurrentY()*20+100;
        		x3[i]=face.getPoints().get(i).getCurrentX()*20+100;
        		y3[i]=face.getPoints().get(i).getCurrentY()*20+100+300;
>>>>>>> 3f13b43438d78c3a59e850ecff62445cade29b77
        	}
 
        	gc.strokePolygon(x, y, face.getPoints().size());
<<<<<<< HEAD
        }*/
        try {
			DrawModele(modele, canvas);
		} catch (Exception e1) {
			
        }
        
        root.getChildren().add(canvas);
        Button button = new Button("tourner de 5 degrés sur y");
        
        button.setOnAction(e->{
        	try {
				modele.turnOnYAxis(5);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
        
				/*try {
					modele.turnOnXAxis(5);
					
					gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
<<<<<<< HEAD
					for (Point point : listePoint) {

			    		//System.out.println(Arrays.toString(point.getMatricialCoordonnnee())+"\n---------------\n");
						point.transform(repere);
						//System.out.println(Arrays.toString(point.getMatricialCoordonnnee())+"\n---------------\n||||||||||||\n---------");
						
				}
=======
					System.out.println("Coordonées points:\n---------------");
			    	
					
>>>>>>> 8efa43c0830788fa4375b8c77a14f1cc47a35330
			//faceSorter.sort(listeface); 
	        for (Face face : modele.getListeFaces()) {
	        	double[] x=new double[3];
	        	double[] y=new double[3];
	        	double[] x2=new double[3];
	        	double[] y2=new double[3];
	        	double[] x3=new double[3];
	        	double[] y3=new double[3];
	        	for(int i=0; i<face.getPoints().size(); i++) {
<<<<<<< HEAD
	        		x[i]=face.getPoints().get(i).getCurrentX()/20+100;
	        		y[i]=face.getPoints().get(i).getCurrentY()/20+100;

=======
	        		x[i]=face.getPoints().get(i).getCurrentX()*20+100;
	        		y[i]=face.getPoints().get(i).getCurrentY()*20+100;
	        		x2[i]=face.getPoints().get(i).getCurrentX()*20+100+300;
	        		y2[i]=face.getPoints().get(i).getCurrentY()*20+100;
	        		x3[i]=face.getPoints().get(i).getCurrentX()*20+100;
	        		y3[i]=face.getPoints().get(i).getCurrentY()*20+100+300;
>>>>>>> 3f13b43438d78c3a59e850ecff62445cade29b77
	        	}
	 
	        	gc.strokePolygon(x, y, face.getPoints().size());
	        	gc.strokePolygon(x2, y2, face.getPoints().size());
	        	gc.strokePolygon(x3, y3, face.getPoints().size());
	        } 
	        System.out.println("-----------------");
	        for (Point point : listePoint) {
				System.out.println(Arrays.toString(point.getMatricialCoordonnnee()));
			}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			*/
        //root.getChildren().add(button);
        Button button2=new Button("tourner de 5 degrés sur x");
        button2.setOnAction(e->{
        		try {
					modele.turnOnXAxis(5);
				} catch (Exception e1) {
					
				}
        });		
				/*try {
					repere.turnOnXAxisOf(5);
					System.out.println(Arrays.deepToString(repere.matrice.points));
					gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
					System.out.println("Coordonées points:\n---------------");
			    	ArrayList<Point> listOfNewPoints=new ArrayList<Point>();
					for (Point point : listePoint) {

			    		System.out.println(Arrays.toString(point.getMatricialCoordonnnee())+"\n---------------\n");
						point.transform(repere);
						System.out.println(Arrays.toString(point.getMatricialCoordonnnee())+"\n---------------\n||||||||||||\n---------");
						
				}
			//faceSorter.sort(listeface); 
	        for (Face face : listeface) {
	        	double[] x=new double[3];
	        	double[] y=new double[3];
	        	double[] x2=new double[3];
	        	double[] y2=new double[3];
	        	double[] x3=new double[3];
	        	double[] y3=new double[3];
	        	for(int i=0; i<face.getPoints().size(); i++) {
<<<<<<< HEAD
	        		x[i]=face.getPoints().get(i).getCurrentX()/200+100;
	        		y[i]=face.getPoints().get(i).getCurrentY()/200+100;

=======
	        		x[i]=face.getPoints().get(i).getCurrentX()*20+100;
	        		y[i]=face.getPoints().get(i).getCurrentY()*20+100;
	        		x2[i]=face.getPoints().get(i).getCurrentX()*20+100+300;
	        		y2[i]=face.getPoints().get(i).getCurrentY()*20+100;
	        		x3[i]=face.getPoints().get(i).getCurrentX()*20+100;
	        		y3[i]=face.getPoints().get(i).getCurrentY()*20+100+300;
>>>>>>> 3f13b43438d78c3a59e850ecff62445cade29b77
	        	}
	 
	        	gc.strokePolygon(x, y, face.getPoints().size());
	        	gc.strokePolygon(x2, y2, face.getPoints().size());
	        	gc.strokePolygon(x3, y3, face.getPoints().size());
	        } 
	        System.out.println("-----------------");
	        for (Point point : listePoint) {
				System.out.println(Arrays.toString(point.getMatricialCoordonnnee()));
			}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			
   
        HBox hbox=new HBox();
        
        hbox.getChildren().addAll(button2, button);
        root.getChildren().add(hbox);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
   private void drawTriangles(GraphicsContext gc ,List<Face> listFace) {
    	for(int i=0; i<listFace.size();i++){
    		  Face face=listFace.get(i);
    		  Point p1=face.getPoints().get(0);
    		  Point p2=face.getPoints().get(1);
    		  Point p3=face.getPoints().get(2);
    		  drawTriangle(gc,p1,p2,p3);
    		}
    }
    
    
    
	private void drawTriangle(GraphicsContext gc, Point p1, Point p2, Point p3) {
		gc.strokePolygon(
        		new double[]{p1.getX(), p2.getX(),p3.getX()},
                new double[]{p1.getY(), p2.getY(), p3.getY()}, 3);
		
	}
	
	protected void DrawModele(Modele modele, Canvas canvas) {
		List<Face> faceList=modele.getListeFaces();
		this.faceSorter.sort(faceList);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
		
		//faceSorter.sort(listeface); 
		for (Face face : modele.getListeFaces()) {
			double[] x=new double[3];
			double[] y=new double[3];
			for(int i=0; i<face.getPoints().size(); i++) {
				x[i]=face.getPoints().get(i).getCurrentX()*20+100;
				y[i]=face.getPoints().get(i).getCurrentY()*20+100;

			}
			gc.strokePolygon(x, y, face.getPoints().size());
			gc.setFill(Color.WHITE);
			gc.fillPolygon(x, y, face.getPoints().size());
		}
		
	}




	public static void main(String[] args) {
        launch();
    }



	@Override
	public void update(Subject subj) {
		DrawModele(modele, canvas);
		
	}



	@Override
	public void update(Subject subj, Object data) {

		DrawModele(modele, canvas);
		
	}

}