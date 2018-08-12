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
		if(vector.length != addend.getVector().length){
			System.out.println("Error: Vectors are not of the same size");
		}else{
			for(int i = 0; i < vector.length; i++){
				vector[i] += addend.getVector()[i];
			}
		}
		return this;
	}
	
	public static void swap (List<Vector> vectors, Vector constants, int i, int j) {
		Vector vector = vectors.get(i);
		vectors.set(i, vectors.get(j));
		vectors.set(j, vector);
		
		double constant = constants.getVector()[i];
		constants.getVector()[i] = constants.getVector()[j];
		constants.getVector()[j] = constant;
	}
	
	public static boolean isSolvable (List<Vector> vectors, Vector constants) {
		if (vectors.size() == constants.getVector().length)
			return true;
		else
			return false;
	}
	
	public static Vector Gauss_Jordan (List<Vector> vectors, int dimension, Vector constants) {
		if (isSolvable(vectors, constants)) {
			//4 return to step 1
			for (int i = 0; i < vectors.size(); i++) {				
				if (vectors.get(i).getVector().length != dimension)
					return null;
				
				int j = 0, k = i;
				double pivot = 0;
				
				//1 if matrix[i][j] == 0 swap some row below until matrix[i][j] != 0
				while (vectors.get(i).getVector()[j] == 0) {
					if (k == vectors.size()) {
						if (j == vectors.get(i).getVector().length-1){
							break;
						}else {
							j++;
							k = i;
						}
					}
					
					if (vectors.get(k).getVector()[j] != 0) {
						swap(vectors, constants, i, k);
					} else
						k++;
				}
				
				
				//2 Divide the ith row by matrix[i][j] to make pivot value = 1
				if(vectors.get(i).getVector()[j] != 0){
					pivot = vectors.get(i).getVector()[j];
					vectors.get(i).scale(1 / pivot);
					constants.getVector()[i] *= 1 / pivot;
					
					//3 Make values in jth column 0 by using elementary row operations
					for (int l = 0; l < vectors.size(); l++) {
						if (l != i && vectors.get(l).getVector()[l] != 0) {
							Vector scaledVector = new Vector(vectors.get(i).getVector(), vectors.get(i).getDimension());
							double scalar = vectors.get(l).getVector()[j] * -1;
							
							scaledVector.scale(scalar);
							vectors.get(l).add(scaledVector);
							
							constants.getVector()[l] += constants.getVector()[i] * scalar;
						}	
					}
				}
			}
						
			int sum = 0;
			
			//check if valid or invalid result
			for (int m = 0; m < vectors.size(); m++) {
				sum = 0;
				for (int n = 0; n < dimension; n++) {
					sum += vectors.get(m).getVector()[n];
				}
				if (sum == 0 && constants.getVector()[m] != 0)
					return null;
			}
		
			return constants;
		} else {
			return null;
		}

	}
	
	public static int span (List<Vector> vectors, int dimension) {
		Gauss_Jordan(vectors, dimension, new Vector(vectors.size()));
				
		int span = 0;
		boolean nonzero = false;
		
		for (int i = 0; i < vectors.size(); i++) {
			for (int j = 0; j < dimension; j++) {
				if (vectors.get(i).getVector()[j] != 0) {
					nonzero = true;
					break;
				}
			}
			if (nonzero) {
				span += 1;
				nonzero = false;
			}
		}
		
		return span;
	}
	
	public double[] getVector () {
		return vector;
	}
	
	public int getDimension () {
		return dimension;
	}
	
	public boolean getZeroVector () {
		for (int i = 0; i < vector.length; i++)
			if (vector[i] != 0)
				return false;
		return true;
	}
	
}
