import java.util.ArrayList;
import java.util.List;

/*
 * ACORDA, Luigi
 * GO, Timothy
 * SANTIAGO, Gabriel
 * 
 * ADVDISC S17
 */

public class Matrix {
	private int rows;
	private int columns;
	private Vector[] matrix;
	
	public Matrix (int dimension) {
		this.rows = dimension;
		this.columns = dimension;
		this.matrix = new Vector[dimension];
		for(int i = 0; i < matrix.length; i++){
			matrix[i] = new Vector(dimension);
			matrix[i].getVector()[i] = 1;
		}
	}
	
	public Matrix (List<Vector> list, int dimension) {
		this.columns = list.size();
		this.rows = dimension;
		this.matrix = new Vector[this.rows];
		
		for(int i = 0; i < rows; i++){
			matrix[i] = new Vector(columns);
			for(int j = 0; j < columns; j++){
				matrix[i].getVector()[j] = list.get(j).getVector()[i];
			}
		}
	}
	
	public Matrix times (Matrix other) {
		List<Vector> vectors = new ArrayList<Vector>();
		
		if(columns != other.getRows()){
			System.out.println("mismatch");
			return null;
		}else{
			for(int matrixRow = 0; matrixRow < rows; matrixRow++){
				Vector vector = new Vector(other.getColumns());
				
				for(int otherCol = 0; otherCol < other.getColumns(); otherCol++){
					double sum = 0;
					for(int i = 0; i < columns; i++){
						sum += matrix[matrixRow].getVector()[i] * other.getMatrix()[i].getVector()[otherCol];
					}
					vector.getVector()[otherCol] = sum;
				}
				
				vectors.add(vector);
			}
		}
		
		//transpose list of vectors
		//cause creating a new matrix with the vectors will transpose it back to the original
		List<Vector> transposedVectors = new ArrayList<Vector>();
		int vRow = vectors.size();
		int vCol = vectors.get(0).getDimension();
		
		for(int i = 0; i < vCol; i++){
			Vector vector = new Vector(vRow);
			for(int j = 0; j < vRow; j++){
				vector.getVector()[j] = vectors.get(j).getVector()[i];
			}
			transposedVectors.add(vector);
		}
		
		return new Matrix(transposedVectors, vRow);
	}
	
	public double det () {
		if (rows != columns)
			return 0;
		
		double det = 1;
		List<Vector> temp = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].getZeroVector())
				return 0;
			Vector v = new Vector(matrix[i].getVector(), matrix[i].getDimension());
			temp.add(v);
		}
		// Gauss Jordan
		
		//4 return to step 1
		for (int i = 0; i < temp.size(); i++) {
			
			int j = 0, k = i;
			double pivot = 0;
			
			//1 if matrix[i][j] == 0 swap some row below until matrix[i][j] != 0
			while (temp.get(i).getVector()[j] == 0) {
				if (k == temp.size()) {
					if (j == temp.get(i).getVector().length-1){
						break;
					}else {
						j++;
						k = i;
					}
				}else if (temp.get(k).getVector()[j] != 0) {
					//swap here
					System.out.println("SWAP");
					Vector vector = temp.get(i);
					temp.set(i, temp.get(k));
					temp.set(k, vector);
					
					det = -1 * det;
				} else
					k++;
			}
			
			
			//2 Divide the ith row by matrix[i][j] to make pivot value = 1
			if(temp.get(i).getVector()[j] != 0){
				pivot = temp.get(i).getVector()[j];
				temp.get(i).scale(1 / pivot);
				
				det = det * 1 / pivot;
				
				//3 Make values in jth column 0 by using elementary row operations
				for (int l = 0; l < temp.size(); l++) {
					if (l != i && temp.get(l).getVector()[l] != 0) {
						Vector scaledVector = new Vector(temp.get(i).getVector(), temp.get(i).getDimension());
						double scalar = temp.get(l).getVector()[j] * -1;
						
						scaledVector.scale(scalar);
						temp.get(l).add(scaledVector);
					}	
				}
			}
			
			System.out.println("step: " + i);
			for(int ii = 0; ii < rows; ii++){
				for(int jj = 0; jj < columns; jj++){
					System.out.print(temp.get(ii).getVector()[jj] + " ");
				}
				System.out.println("");
			}
		}
		
        return 1 / det;
	}
	
	public Matrix inverse () {
		Matrix inverse = new Matrix(rows);
		
		if(rows != columns){
			//has to be a perfect square
			return null;
		}else{
			//gauss jordan elimination
			
			//4 return to step 1
			for (int i = 0; i < matrix.length; i++) {
				
				int j = 0, k = i;
				double pivot = 0;
				
				//1 if matrix[i][j] == 0 swap some row below until matrix[i][j] != 0
				while (matrix[i].getVector()[j] == 0) {
					if (k == matrix.length) {
						if (j == matrix[i].getVector().length-1){
							break;
						}else {
							j++;
							k = i;
						}
					}else if (matrix[k].getVector()[j] != 0) {
						//swap here
						Vector vector = matrix[i];
						matrix[i] = matrix[k];
						matrix[k] = vector;
						
						Vector inverseVector = inverse.getMatrix()[i];
						inverse.getMatrix()[i] = inverse.getMatrix()[k];
						inverse.getMatrix()[k] = inverseVector;
					} else
						k++;
				}
				
				
				//2 Divide the ith row by matrix[i][j] to make pivot value = 1
				if(matrix[i].getVector()[j] != 0){
					pivot = matrix[i].getVector()[j];
					matrix[i].scale(1 / pivot);
					//scale here
					//constants.getVector()[i] *= 1 / pivot;
					inverse.getMatrix()[i].scale(1/pivot);
					
					//3 Make values in jth column 0 by using elementary row operations
					for (int l = 0; l < matrix.length; l++) {
						if (l != i && matrix[l].getVector()[l] != 0) {
							Vector scaledVector = new Vector(matrix[i].getVector(), matrix[i].getDimension());
							double scalar = matrix[l].getVector()[j] * -1;
							
							scaledVector.scale(scalar);
							matrix[l].add(scaledVector);
							
							//add here
							//constants.getVector()[l] += constants.getVector()[i] * scalar;
							Vector scaledInverseVector = new Vector(inverse.getMatrix()[i].getVector(), inverse.getMatrix()[i].getDimension());
							scaledInverseVector.scale(scalar);
							inverse.getMatrix()[l].add(scaledInverseVector);
						}	
					}
				}
			}
			
			for(int i = 0; i < matrix.length; i++){
				boolean allZeros = true;
				
				for(int j = 0; j < matrix[i].getDimension(); j++){
					if(matrix[i].getVector()[j] != 0)
						allZeros = false;
				}
				
				if(allZeros)
					return null;
			}
			
		}
		
		return inverse;
	}
	
	//just for printing
	public void printMatrix(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				System.out.print(matrix[i].getVector()[j] + " ");
			}
			System.out.println("");
		}
	}
	
	public Vector[] getMatrix(){
		return matrix;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}

}
