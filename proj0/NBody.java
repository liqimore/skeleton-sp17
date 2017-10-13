public class NBody {

	public static double readRadius(String path){
		System.out.println("E:\\sp17\\skeleton-sp17\\proj0\\data\\planets.txt");
		In in = new In("E:\\sp17\\skeleton-sp17\\proj0\\data\\planets.txt");
		double radius = 0;
		while(!in.isEmpty()) {
			radius = in.readDouble();		
		}
		return radius;
	}
}
