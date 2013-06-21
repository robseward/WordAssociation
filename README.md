Word Association
=====

A Java library that provides shortest path analysis for the USF Word Association Norms.

To Use
----

These instructions are for use with Processing

1. Download the library files [here](http://robseward.com/misc/WordAssociation.zip)  
2. Place these two files in the same directory as your sketch (they are included in the library folder):  
[master_word_list.txt](https://raw.github.com/robseward/WordAssociation/master/USFWordAssociation/master_word_list.txt)  
[adjusted_edges_list.txt](https://raw.github.com/robseward/WordAssociation/master/USFWordAssociation/adjusted_edges_list.txt)

3. Place the folder *WordAssociation* in the library folder in your Processing documents folder.

## Example code

	import seward.wordassociation.*;
	
	void setup() {
	  size(200, 200);  
	
	  String wordListPath = sketchPath("master_word_list.txt");
	  String edgesPath = sketchPath("adjusted_edges_list.txt");

	  WordAssociation wa = new WordAssociation(wordListPath, edgesPath);
	
	  try {
	    wa.setSourceWord("life");

	    ArrayList<WordPath> paths = wa.getAllPaths();
	    for (int i=0; i < 1000; i++) {
	      WordPath p = paths.get(i);
	      System.out.println(p.toString());
	    }
	  }
	  catch(Exception e) {
	    println(e);
	  }
	}

## Classes

### WordAssociation

`public WordAssociation(String wordListPath, String edgeListPath)`

*String wordListPath*  -- Path to the word list file

*String edgeListPath* -- Path to the edges file

`public setSourceWord(String word)`

This must be set before pathForWord is called. It is the word from which all paths will be calculated from.

*String word* -- the source word

`public ArrayList<WordPath> getAllPaths() throws Exception`

Return an ArrayList of all the paths from the soure word to every other word in the wordlist.

### WordPath

`public String toString()`

Return the path as a readable string

`ArrayList<String> getPathVertices()`

Return the path as an array of vertices

`double getCost()`

Return the cost of the path

`Public String getSource(){`

Get the source word (the first word in the path)


`Public String getTarget(){`

Get the target word (the last word in the path)