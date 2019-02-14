
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
		ReadFile.setup("../test.in");
		String [] intel  = ReadFile.getintel();
		row = Integer.parseInt(intel[0]);
		col = Integer.parseInt(intel[1]);
		System.out.println("Row : " + row);
		System.out.println("Column : " + col);
		deadline = Integer.parseInt(intel[3]);
		System.out.println("Deadline : " + deadline);
		drones = new Drone[Integer.parseInt(intel[2])];
		System.out.println("Drone 0 : " + drones[0]);
		droneCapacity = Integer.parseInt(intel[4]);
		System.out.println("Capacity : " + droneCapacity);
		int nbProducts = ReadFile.getNbProduct();
		products = ReadFile.getProductWeight();
		warehouses = ReadFile.getWarehousesIntel(nbProducts);
		orders = ReadFile.CustomersOrders();
	}
}
