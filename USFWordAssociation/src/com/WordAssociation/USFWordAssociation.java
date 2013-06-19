package com.WordAssociation;

import org.jgrapht.alg.*;
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
		
		BellmanFordShortestPath<String, WeightedEdge> bfPath = new BellmanFordShortestPath<String,WeightedEdge>(wa.graph, "2253");
		int count = 0;
        for(int i=1; i < 10; i++){
        	try	{
        		List<WeightedEdge> list = bfPath.getPathEdgeList("" + i);
        		Path p = new Path(list, "CREATIVE", wa.wordList);
        		count++;
        	} catch(java.lang.IllegalArgumentException e){
        		System.out.println("Bad vertex: " + i);
        	}
        	
        }
     
      //  wa.printPath(shortestPaths.getPath());
        System.out.println("Done - " + count + " lines");
        //System.out.println(shortest_path);
	}

	//constructor
	USFWordAssociation(){
		graph = new AssociationGraph();
	}

	public ArrayList<Path> listFromWord(String word){
		ArrayList<Path> list = new ArrayList<Path>();
		
		
		
		return list;
	}
	
	void printPath(List<WeightedEdge> list){
		if(list == null)
			return;
		String str = "";
		for (int i=0;i<list.size();i++) {
		    WeightedEdge e = list.get(i);
		    str += this.wordForIndexString((String)e.getSource());
		    str += " ";
		    str += this.wordForIndexString((String)e.getTarget());
		    str += " ";
		}
		System.out.println(str);
	}
	
	private String wordForIndexString(String indexStr){
		int index = Integer.parseInt(indexStr);
		return wordList.get(index);
	}
	
	/// Load Data from files ///
	
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
}


