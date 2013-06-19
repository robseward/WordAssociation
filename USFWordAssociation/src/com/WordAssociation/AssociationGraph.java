package com.WordAssociation;

import org.jgrapht.graph.*;
import org.jgrapht.*;


public class AssociationGraph 
extends AbstractBaseGraph<String, WeightedEdge>
implements UndirectedGraph<String, WeightedEdge>
 {

	public AssociationGraph() {// EdgeFactory<String, DefaultEdge> arg0, boolean arg1,boolean arg2
	    super(new ClassBasedEdgeFactory<String, WeightedEdge>(
	            WeightedEdge.class),
	        true,
	        true);
	}

}
