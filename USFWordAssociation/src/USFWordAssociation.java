import org.jgrapht.*;
import org.jgrapht.alg.*;
import org.jgrapht.graph.*;
import java.util.List;

public class USFWordAssociation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class); 
        graph.addVertex("47");
        graph.addVertex("28");
        graph.addVertex("29");
        graph.addVertex("26");
        graph.addVertex("79");
        
        
        DefaultWeightedEdge e1 = graph.addEdge("47", "28"); 
        graph.setEdgeWeight(e1, 5); 
        
        DefaultWeightedEdge e2 = graph.addEdge("28", "29"); 
        graph.setEdgeWeight(e2, 3); 
        
        DefaultWeightedEdge e3 = graph.addEdge("26", "79"); 
        graph.setEdgeWeight(e3, 6); 
        
        DefaultWeightedEdge e4 = graph.addEdge("28", "26"); 
        graph.setEdgeWeight(e4, 2); 
        
        DefaultWeightedEdge e5 = graph.addEdge("79", "26"); 
        graph.setEdgeWeight(e5, 4); 
        
       
        DefaultWeightedEdge e6 = graph.addEdge("28", "79"); 
        graph.setEdgeWeight(e6, 9); 
        
        DefaultWeightedEdge e7 = graph.addEdge("26", "47"); 
        graph.setEdgeWeight(e7, 7); 
        
        DefaultWeightedEdge e8 = graph.addEdge("29", "28"); 
        graph.setEdgeWeight(e8, 2); 
        
        DefaultWeightedEdge e9 = graph.addEdge("47", "29"); 
        graph.setEdgeWeight(e9, 10); 
        
        DefaultWeightedEdge e10 = graph.addEdge("29", "79"); 
        graph.setEdgeWeight(e10, 1); 
        
       
        System.out.println("Shortest path from 47 to 79:");
        List shortest_path =   DijkstraShortestPath.findPathBetween(graph, "47", "79");
        System.out.println(shortest_path);
	}

}
