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
				
				/*DELETE THIS BEFORE SUBMISSION*/
				for(int counter = 0; counter < vectors.size(); counter++) {
					String vector = "";
					for(double d : vectors.get(counter).getVector())
						vector += d + " ";
					System.out.println(vector.trim() + " " + constants.getVector()[counter]);
				}
				System.out.println("");
				/*DELETE THIS BEFORE SUBMISSION*/
				
				if (vectors.get(i).getVector().length != dimension)
					return null;
				
				int j = 0, k = i;
				double pivot = 0;
				
				//1 if matrix[i][j] == 0 swap some row below until matrix[i][j] != 0
				while (vectors.get(i).getVector()[j] == 0) {
					if(k == vectors.size())
						return null;
					
					if (j == vectors.get(i).getVector().length - 1) {
						swap(vectors, constants, i, k);
						j = 0;
						k++;
					}
					else
						j++;
				}
				
				//2 Divide the ith row by matrix[i][j] to make pivot value = 1
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
			
			/*DELETE THIS BEFORE SUBMISSION*/
			for(int counter = 0; counter < vectors.size(); counter++) {
				String vector = "";
				for(double d : vectors.get(counter).getVector())
					vector += d + " ";
				System.out.println(vector.trim() + " " + constants.getVector()[counter]);
			}
			System.out.println("");
			/*DELETE THIS BEFORE SUBMISSION*/
			
			return constants;
		} else {
			return null;
		}

	}
	
	public int span (List<Vector> vectors, int dimension) {
		int span = 0;
		boolean nonzero = false;
		
		for (int i = 0; i < vectors.size(); i++) {
			for (int j = 0; j < dimension; j++) {
				if (vectors.get(i).getVector()[j] != 0) {
					nonzero = true;
					break;
				}
			}
			if (nonzero)
				span += 1;
		}
		
		return span;
	}
	
	public double[] getVector () {
		return vector;
	}
	
	public int getDimension () {
		return dimension;
	}
}
