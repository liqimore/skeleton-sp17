public class NBody {

	public static double readRadius(String path){
		In in = new In(path);
		String[] radius = in.readAllLines();
		//String to double
		return Double.valueOf(radius[1]).doubleValue();
	}
	
	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int numOfPlanet = in.readInt();
		String[] lines = in.readAllLines();
		Planet[] arrayOfPlanet;
		for (int i = 2; i < numOfPlanet + 2; i++) {
			String info[] = In.readDoubles(lines[i]);
			for (int j = 0; j < 6; j++) {
				arrayOfPlanet[j] = new Planet(Double.parseDouble(info[0]), Double.parseDouble(info[1])
											  Double.parseDouble(info[2]), Double.parseDouble(info[3])
											  Double.parseDouble(info[4]), info[5]);
			}
		}
		return arrayOfPlanet;
	}
	
}