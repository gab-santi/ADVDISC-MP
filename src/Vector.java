import java.util.List;

/*
 * ACORDA, Luigi
 * GO, Timothy
 * SANTIAGO, Gabriel
 * 
 * ADVDISC S17
 */

public class Vector {
	private int dimension;
	private double[] vector; 
	
	public Vector (int dimension) {
		this.dimension = dimension;
		vector = new double[dimension];
		
		//initialize to zero vector
		for(int i = 0; i < vector.length; i++){
			vector[i] = 0;
		}
	}
	
	public Vector (double[] array, int dimension) {
		this.dimension = dimension;
		vector = new double[dimension];
		
		//copy
		for(int i = 0; i < vector.length; i++){
			vector[i] = array[i];
		}
	}
	
	public Vector scale (double scalar) {
		//scale each element
		for(int i = 0; i < vector.length; i++){
			vector[i] *= scalar;
		}
		
		return this;
	}
	
	public Vector add (Vector addend) {
		if(vector.length != addend.getVectorList().length){
			//handle size mismatch error here
		}else{
			for(int i = 0; i < vector.length; i++){
				vector[i] += addend.getVectorList()[i];
			}
		}
		return this;
	}
	
	public boolean isSolvable (List<Vector> vectors, Vector contraints) {
		// to-do: check if vector is solvable by Gauss-Jordan
		return true; // else return false
	}
	
	public Vector Gauss_Jordan (List<Vector> vectors, int dimension, Vector constraints) {
		Vector v = new Vector (dimension);
		
		if (isSolvable(vectors, constraints)) {
			// to-do: perform Gauss-Jordan algorithm
			
			return v;
		} else {
			return null;
		}

	}
	
	public int span (List<Vector> vectors, int dimension) {
		int span = 0;
		
		// to-do: count span of vector list
		
		return span;
	}
	
	public double[] getVectorList () {
		return vector;
	}
}
