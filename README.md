WORD ASSOCIATION
=====

This is a java library that provides shortest path analysis for the USF Word Association Norms.

To Use
----

Download the files [here](files.zip)  
Place these two files in the same directory as your sketch:

[master_word_list.txt](master_word_list.txt)  
[adjusted_edges_list.txt](adjusted_edges_list.txt)

Place the folder *WordAssociation* in the library folder in your Processing documents folder.

## Example code

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