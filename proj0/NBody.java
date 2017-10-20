public class NBody {

	public static double readRadius(String path){
		In in = new In(path);
		String[] radius = in.readAllLines();
		//String to double
		return Double.valueOf(radius[1]).doubleValue();
	}

	public static Planet[] ReadPlanets(String path){
		In in = new In(path);
		int numOfPlanet = in.readInt();
		String[] lines = in.readAllLines();
		String[] Planet = new Planet();
		for (int i = 2; i < numOfPlanet + 2; i++) {
			double info[] = In.readDoubles(lines[i]);
		}
	}
}