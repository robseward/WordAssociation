package com.WordAssociation;
import java.util.*;

public class Path {
	ArrayList<String>vertices;
	ArrayList<String>unsortedVertices;
	ArrayList<String>wordList;
	
	double cost;
	
	Path(List<WeightedEdge> edgeList, String sourceWord, ArrayList<String> wordList){
		this.wordList = wordList;
		vertices = new ArrayList<String>();
		unsortedVertices = new ArrayList<String>();
		convertEdgeList(edgeList);
		orderList(sourceWord, 0);
		removeDuplicates();
		//Temp print out testing data
		System.out.println("");
		for(int i=0; i<unsortedVertices.size(); i++){
			System.out.print(unsortedVertices.get(i) + " ");
		}
	}
	
	void convertEdgeList(List<WeightedEdge> edgeList){
		for(int i=0; i < edgeList.size(); i++){
			WeightedEdge edge = edgeList.get(i);
			String sourceString = (String)edge.getSource();
			unsortedVertices.add(wordForIndexString(sourceString));
			String targetString = (String)edge.getTarget();
			unsortedVertices.add(wordForIndexString(targetString));
		}
	}
	
	void removeDuplicates()
	{
		Iterator<String> iter = unsortedVertices.iterator();
		String last = null;
		while(iter.hasNext()){
			String current = iter.next();
			if(current.equals(last))
				iter.remove();
			last = current;
		}
		System.out.print("");
	}
	
	private String wordForIndexString(String indexStr){
		int index = Integer.parseInt(indexStr);
		return wordList.get(index);
	}
	
	void orderList(String startWord, int index){
		if(index >= unsortedVertices.size()-1)
			return;
		String str1 = unsortedVertices.get(index);
		String str2 = unsortedVertices.get(index+1);
		//TODO assert that one word matches startWord
		if(!str1.equals(startWord)){
			Collections.swap(unsortedVertices, index, index+1);
			orderList(str1, index+2);
		} 
		else {
			orderList(str2, index+2);
		}
	}
	
	String getSource(){
		return vertices.get(0);
	}
	
	String getTarget(){
		return vertices.get(vertices.size()-1);
	}
	
	void setCost(double c){
		this.cost = c;
	}
	
	double getCost()
	{
		return cost;
	}
}
