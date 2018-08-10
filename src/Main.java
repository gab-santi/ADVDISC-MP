import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		//----------MULTIPLICATION CASE #1
		/*
		Vector vec1 = new Vector(new double[]{1, 4}, 2);
		Vector vec2 = new Vector(new double[]{2, 5}, 2);
		Vector vec3 = new Vector(new double[]{3, 6}, 2);
		List<Vector> vectors = new ArrayList<Vector>();
		vectors.add(vec1);
		vectors.add(vec2);
		vectors.add(vec3);
		
		Vector vec4 = new Vector(new double[]{7,9,11},3);
		Vector vec5 = new Vector(new double[]{8,10,12},3);
		List<Vector> vectors2 = new ArrayList<Vector>();
		vectors2.add(vec4);
		vectors2.add(vec5);
		
		Matrix matrix = new Matrix(vectors, 2);
		matrix.printMatrix();
		
		System.out.println("");
		
		Matrix matrix2 = new Matrix(vectors2, 3);
		matrix2.printMatrix();
		*/
	
		//----------MULTIPLICATION CASE #2
		/*
		Vector vec1 = new Vector(new double[]{3}, 1);
		Vector vec2 = new Vector(new double[]{4}, 1);
		Vector vec3 = new Vector(new double[]{2}, 1);
		List<Vector> vectors = new ArrayList<Vector>();
		vectors.add(vec1);
		vectors.add(vec2);
		vectors.add(vec3);
		
		Vector vec4 = new Vector(new double[]{13, 8, 6},3);
		Vector vec5 = new Vector(new double[]{9, 7, 4},3);
		Vector vec6 = new Vector(new double[]{7, 4, 0},3);
		Vector vec7 = new Vector(new double[]{15, 6, 3},3);
		List<Vector> vectors2 = new ArrayList<Vector>();
		vectors2.add(vec4);
		vectors2.add(vec5);
		vectors2.add(vec6);
		vectors2.add(vec7);
		
		Matrix matrix = new Matrix(vectors, 1);
		matrix.printMatrix();
		
		System.out.println("");
		
		Matrix matrix2 = new Matrix(vectors2, 3);
		matrix2.printMatrix();
		*/
		
		//----------INVERSE CASE #1 2x2
		/*
		Vector vec1 = new Vector(new double[]{1, 2}, 2);
		Vector vec2 = new Vector(new double[]{3, 7}, 2);
		List<Vector> vectors = new ArrayList<Vector>();
		vectors.add(vec1);
		vectors.add(vec2);
		
		Matrix matrix = new Matrix(vectors, 2);
		matrix.printMatrix();
		*/
		
		//----------INVERSE CASE #2 3x3
		
		Vector vec1 = new Vector(new double[]{1, 2, 1}, 3);
		Vector vec2 = new Vector(new double[]{2, 5, 0}, 3);
		Vector vec3 = new Vector(new double[]{3, 3, 8}, 3);
		List<Vector> vectors = new ArrayList<Vector>();
		vectors.add(vec1);
		vectors.add(vec2);
		vectors.add(vec3);
		
		Matrix matrix = new Matrix(vectors, 3);
		matrix.printMatrix();
		
		
		System.out.println("\n"+"result: ");
		
		matrix.inverse().printMatrix();
		
		//matrix.times(matrix2).printMatrix();
	}
}