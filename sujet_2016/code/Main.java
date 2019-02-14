
class Main {
	static int row = 0;
	static int col = 0;
	static int deadline = 0;
	static int droneCapacity = 0;
	static int []products;
	static Warehouse []warehouses;
	static Order []orders;
	static Drone []drones;

	public static void main(String[] args) {
		ReadFile.setup("../busy_day.in");
		String [] intel  = ReadFile.getintel();
		row = Integer.parseInt(intel[0]);
		col = Integer.parseInt(intel[1]);
		deadline = Integer.parseInt(intel[3]);
		drones = new Drone[Integer.parseInt(intel[2])];
		droneCapacity = Integer.parseInt(intel[4]);
	}
}
