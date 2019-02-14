
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

	public static void runStupid() {
		int		idOrder = 0;

		for (int turnActu = 0; turnActu < deadline; ++turnActu) {
			if (idOrder >= orders.length)
				break ;

			for (int idDrone = 0; idDrone < drones.length; ++idDrone) {
				Drone drone = drones[idDrone];
				if (drone.timeout >= turnActu)
					continue ;

				int		nextTimeOut = turnActu;
				Order	orderactu = orders[idOrder];

				for (int idProduct : orderactu.products) {
					for (int idWarehouse = 0; idWarehouse < warehouses.length; ++idWarehouse) {
						Warehouse wh = warehouses[idWarehouse];
						if (wh.getProductAndLoad(idProduct, 1)) {
							// Go to Warehouse
							Output.addInstruction(idDrone, Command.Load, idWarehouse, idProduct, 1);
							nextTimeOut += 1 + (int) Math.ceil(drone.pos.distance(wh.pos));
							drone.pos.setLocation(wh.pos);

							// Go to order
							Output.addInstruction(idDrone, Command.Deliver, idOrder, idProduct, 1);
							nextTimeOut += 1 + (int) Math.ceil(drone.pos.distance(orderactu.pos));
							drone.pos.setLocation(orderactu.pos);

							break ;
						}
					}
				}

				drone.timeout = nextTimeOut;
				orderactu.finished = true;
				idOrder++;
				if (idOrder >= orders.length)
					break ;
			}
		}
	}
}
