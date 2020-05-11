package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.*;
import javafx.event.EventHandler;
import javafx.event.EventType;




public class Controller implements Initializable {
	@FXML
	private Pane pane;
	@FXML
	private int a = 0;
	@FXML
	private int name = 0;
	@FXML
	private Button solve;
	@FXML
	private TextField tfield1;
	@FXML
	private TextField tField2;
	@FXML
	private TextField tfieldNodes;
    @FXML
    private Button connect;
    
    private int num;  

    private LinkedList<Integer> adj[];
   
    
    //initiazile list
	private ArrayList<Integer> listOfvertex = new ArrayList<Integer>();
	private ArrayList<Integer> listOfX = new ArrayList<Integer>();
	private ArrayList<Integer> listOfY = new ArrayList<Integer>();
	private ArrayList<Integer> edgelist1 = new ArrayList<Integer>();
	private ArrayList<Integer> edgelist2 = new ArrayList<Integer>();

    
	@FXML 
	public void MOUSE_CLICKED(MouseEvent e) {	
		System.out.println("Naclick mo ng "+ a +" beses"); // pang check kung naclick ba
		a++;
		int x = (int) e.getX();
		int y = (int) e.getY();
		draw(x,y);
	}
	@FXML 
	public void AddConnection() {
		int startX = 0,startY = 0;
		int endX = 0,endY = 0;
		
		//kunin yung inenter na node then ipasa sa variables
		int vertex1 = Integer.parseInt(tfield1.getText());
		int vertex2 = Integer.parseInt(tField2.getText());
		
		//check yung list kung yung inenter is meron
		if(listOfvertex.contains(vertex1)) {	//vertex1 is yung start ng X and Y for line
			System.out.println("Vertex Wan1 kumuha ng x and y");
			
			//kunin yung mga values which is yung x and y values
			startX = listOfX.get(vertex1);
			startY = listOfY.get(vertex1);
		}
		if(listOfvertex.contains(vertex2)) {	// vertex2 is yung end X and Y for line
			System.out.println("Vertex2 kumuha ng x and y");		
			
			endX = listOfX.get(vertex2);
			endY = listOfY.get(vertex2);
		}
		
		System.out.println("Draw na ng line!!!");
		
		edgelist1.add(vertex1);
		edgelist2.add(vertex2);
		
		
		System.out.println("edgelist "+ vertex1 + " "+vertex2);
		
		//call the drawLine mehtod
		DrawLine(startX,startY,endX,endY);
	}
	@FXML
	public void Algorithm() {
		int x = 0;
		int b = 0;
		System.out.println("Algoasdasdsa");
		
		for(int i= 0; i< edgelist1.size(); i++) {
			System.out.println(edgelist1.get(i) + "<--edge1 and edge2--> "+ edgelist2.get(i));
			x = edgelist1.get(i);
			b = edgelist2.get(i);
			System.out.println(x + "<--edge1 and edge2--> "+ b + "Part2");
			addEdge(x, b);
		}
		System.out.println("\n\n-----------------------------ANSWER--------------------------------------");
		DFS(0);
		NotConnected();
		System.out.println("\n-----------------------------ANSWER--------------------------------------");
		
	}
	@FXML
	public void NumberOfNodes() {
		LINKEDLIST(Integer.parseInt(tfieldNodes.getText()));
	}
	public void draw(int x , int y) { 
	    
		//Create new text
	    Text text = new Text(""+name); // cinonvert para malagay dito
	    text.setX(x -4); // may mga plus to para ma center yung Character
	    text.setY(y +4);
	    text.setStroke(Color.YELLOW); 
	    
	    //Create new Circle
	    Circle circle = new Circle(); 
	    circle.setCenterX(x); 
	    circle.setCenterY(y); 
	    circle.setRadius(20);  
	    circle.setFill(Color.SKYBLUE);
	     
	    //Creating a Group object  
	    Group root = new Group(circle, text); 
	    pane.getChildren().add(root);
	    
	    //put the coordinates and name to lists
	    listOfvertex.add(name); 
	    listOfX.add(x);
	    listOfY.add(y);	    
	    name++; //increment
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void DrawLine(int startX,int startY, int endX, int endY) {
		 Line line = new Line(); 
         
	     //Setting the properties to a line 
	     line.setStartX(startX+5); 
	     line.setStartY(startY); 
	     line.setEndX(endX-5); 
	     line.setEndY(endY); 
	     line.setStroke(Color.SKYBLUE);
	         
	     //Creating a Group 
	     Group root = new Group(line); 
	     
	     pane.getChildren().add(root);
	     System.out.println("Done");
	}
	public void LINKEDLIST(int num) {
        this.num = num;
        adj = new LinkedList[num];
        for (int i = 0; i< num; ++i)
            adj[i] = new LinkedList();
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.

    }
    public void DFSUtil(int v,boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[num];
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    public void NotConnected() {
    	
    	for(int i = 0; i < Integer.parseInt(tfieldNodes.getText()); i++) {
    		if(!edgelist1.contains(listOfvertex.get(i)) & !edgelist2.contains(listOfvertex.get(i))) {
    			System.out.print(listOfvertex.get(i)+ " ");
    		}
    	}
    }

}