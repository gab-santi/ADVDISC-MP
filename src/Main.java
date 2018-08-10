import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		/*List<Vector> vectors = new ArrayList<Vector>();
		//vectors.add(new Vector(new double[] {-20,-10,10},3));
		//vectors.add(new Vector(new double[] {0,10,-5},3));
		//vectors.add(new Vector(new double[] {-10,10,15},3));
		
		//Vector constants = Vector.Gauss_Jordan(vectors, 3, new Vector(3));
		
		vectors.add(new Vector(new double[] {-20,-10,10,-10},4));
		vectors.add(new Vector(new double[] {0,10,-5,10},4));	
		vectors.add(new Vector(new double[] {-10,10,15,20},4));	
		
		//Vector constants = Vector.Gauss_Jordan(vectors, 4, new Vector(new double[] {5,11,-6},3));
		
		//for (double d : constants.getVector())
			//System.out.print(d + " ");
		
		//span
		System.out.println(Vector.span(vectors, 4));*/
		
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
		

		System.out.println("result: ");
		matrix.times(matrix2).printMatrix();
	}
}