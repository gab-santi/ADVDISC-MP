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
		
		return 0.0;
	}
	
	public Matrix inverse () {
		
		return null;
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
