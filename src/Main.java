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
		
		Matrix matrix = new Matrix(3);
		matrix.printMatrix();
	}
}