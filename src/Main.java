import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		List<Vector> vectors = new ArrayList<Vector>();
		//vectors.add(new Vector(new double[] {-20,-10,10},3));
		//vectors.add(new Vector(new double[] {0,10,-5},3));
		//vectors.add(new Vector(new double[] {-10,10,15},3));
		
		//Vector constants = Vector.Gauss_Jordan(vectors, 3, new Vector(3));
		
		vectors.add(new Vector(new double[] {1,0,0},3));
		vectors.add(new Vector(new double[] {0,0,0},3));	
		vectors.add(new Vector(new double[] {0,1,0},3));	
		
		Vector constants = Vector.Gauss_Jordan(vectors, 3, new Vector(3));
		
//		vectors.add(new Vector(new double[] {4,3},2));
//		vectors.add(new Vector(new double[] {1,5},2));
//		Vector constants = Vector.Gauss_Jordan(vectors, 2, new Vector(new double[] {10,11},2));
		
		for (double d : constants.getVector())
			System.out.print(d + " ");
		
		//span
		//System.out.println(Vector.span(vectors, 2));
	}
}