import org.jgrapht.alg.*;
import org.jgrapht.graph.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class USFWordAssociation {

	AssociationGraph  graph;
	ArrayList<String> wordList;

	public static void main(String[] args) {
		
		USFWordAssociation wa = new USFWordAssociation();
		wa.loadWordList("master_word_list.txt");
		wa.loadEdges("adjusted_edges_list.txt");
		System.out.println("Shortest path from 47 to 79:");
        List<WeightedEdge> shortest_path =   DijkstraShortestPath.findPathBetween(wa.graph, "2253", "10489");
        wa.printPath(shortest_path);
        System.out.println(shortest_path);
	}

	USFWordAssociation(){
		graph = new AssociationGraph();
	}

	void loadEdges(String fileName) {
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				parseAndLoadLine(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	void printPath(List<WeightedEdge> list){
		for (int i=0;i<list.size();i++) {
		    WeightedEdge e = list.get(i);
		    System.out.println(this.wordForIndexString((String)e.getSource()));
		    System.out.println(this.wordForIndexString((String)e.getTarget()));

		}
	}
	
	void loadWordList(String fileName){
		BufferedReader br = null;
		wordList = new ArrayList<String>();

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				wordList.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void parseAndLoadLine(String line){
		String[] elements = line.split("\t");
		if(elements.length < 3)
			return;
		String cue = elements[0];
		String target = elements[1];
		String weightStr = elements[2];
		
		double weight = Double.parseDouble(weightStr);
		
		graph.addVertex(cue);
		graph.addVertex(target);
		WeightedEdge e = graph.addEdge(cue, target);
		graph.setEdgeWeight(e, weight);
	}
	
	private String wordForIndexString(String indexStr){
		int index = Integer.parseInt(indexStr);
		return wordList.get(index);
	}
}


