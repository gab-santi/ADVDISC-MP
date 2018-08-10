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
		for(int i = 0; i < columns; i++){
			for(int j = 0; j < rows; j++){
				
			}
		}
	}
	
	public Matrix times (Matrix other) {
		int dimension = min(rows, columns);
		Matrix product = new Matrix(dimension);
		
		if(columns != other.getRows() || rows != other.getColumns()){
			System.out.println("mismatch");
		}else{
			for(int i = 0; i < dimension; i++){
				
			}
		}
		
		return product;
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
	
	public int min(int a, int b){
		if(a < b)
			return a;
		else
			return b;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}

}
