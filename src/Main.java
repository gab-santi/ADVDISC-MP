import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		List<Vector> vectors = new ArrayList<Vector>();
		//vectors.add(new Vector(new double[] {-20,-10,10},3));
		//vectors.add(new Vector(new double[] {0,10,-5},3));
		//vectors.add(new Vector(new double[] {-10,10,15},3));
		
		vectors.add(new Vector(new double[] {0,1,0},3));
		vectors.add(new Vector(new double[] {0,0,0},3));
		vectors.add(new Vector(new double[] {1,0,0},3));	
		
		//Vector.Gauss_Jordan(vectors, 3, new Vector(3));
		
		//span
		System.out.println(Vector.span(vectors, 3));
	}
}