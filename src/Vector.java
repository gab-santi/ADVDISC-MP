import java.util.List;

/*
 * ACORDA, Luigi
 * GO, Timothy
 * SANTIAGO, Gabriel
 * 
 * ADVDISC S17
 */

public class Vector {
	private int content[]; 
	
	public Vector (int dimension) {
		// to-do: initialize content
	}
	
	public Vector (double[] array, int dimension) {
		// to-do: initialize content
	}
	
	public static Vector scale (double scalar) {
		Vector v = new Vector((int)scalar);
		
		// to-do: scale content
		
		return v;
	}
	
	public static Vector add (Vector addend) {
		Vector v = new Vector(addend.getContent().length);
		
		// to-do: add addend to content
		
		return v;
	}
	
	public static boolean isSolvable (List<Vector> vectors, Vector contraints) {
		// to-do: check if vector is solvable by Gauss-Jordan
		return true; // else return false
	}
	
	public static Vector Gauss_Jordan (List<Vector> vectors, int dimension, Vector constraints) {
		Vector v = new Vector (dimension);
		
		if (isSolvable(vectors, constraints)) {
			// to-do: perform Gauss-Jordan algorithm
			
			return v;
		} else {
			return null;
		}

	}
	
	public static int span (List<Vector> vectors, int dimension) {
		int span = 0;
		
		// to-do: count span of vector list
		
		return span;
	}
	
	public int[] getContent () {
		return content;
	}
}
