import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		List<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {-20,-10,10,-10},3));
		vectors.add(new Vector(new double[] {0,10,-5,10},3));
		vectors.add(new Vector(new double[] {-10,10,15,20},3));
		
		//vectors.add(new Vector(new double[] {2,5},2));
		//vectors.add(new Vector(new double[] {6,15},2));
		
		//Vector constant = new Vector(new double[] {7,21},2);
		
		Vector.Gauss_Jordan(vectors, 3, new Vector(3));
	
	}
}