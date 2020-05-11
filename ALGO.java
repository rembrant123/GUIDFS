//package application;
//
//import java.util.*;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//
//
//// This class represents a directed graph using adjacency list 
//// representation 
//
//public class ALGO extends Application {
//    private int num;   // No. of vertices
//    // Array  of lists for Adjacency List Representation 
//
//    private LinkedList<Integer> adj[];
//    // Constructor
//    public void jens(int num) {
//        this.num = num;
//        adj = new LinkedList[num];
//        for (int i = 0; i< num; ++i)
//            adj[i] = new LinkedList();
//    }
//    
//    //Function to add an edge into the graph
//    public void addEdge(int v, int w) {
//        adj[v].add(w);  // Add w to v's list.
//
//    }
//    // A function used by DFS
//    public void DFSUtil(int v,boolean visited[]) {
//        // Mark the current node as visited and print it
//        visited[v] = true;
//        System.out.print(v+" ");
//        // Recur for all the vertices adjacent to this vertex 
//
//        Iterator<Integer> i = adj[v].listIterator();
//        while (i.hasNext())
//        {
//            int n = i.next();
//            if (!visited[n])
//                DFSUtil(n, visited);
//        }
//    }
//
//    // The function to do DFS traversal. It uses recursive DFSUtil()
//    public void DFS(int v) {
//        // Mark all the vertices as not visited(set as
//        // false by default in java)
//        boolean visited[] = new boolean[num];
//        // Call the recursive helper function to print DFS traversal
//        DFSUtil(v, visited);
//    }
//
//	@Override
//	public void start(Stage arg0) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//    
//
//}