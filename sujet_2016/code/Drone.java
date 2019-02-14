
// enum DroneType {
// 	Transport,
// 	Livraison,
// }

class Drone {
	Point		pos;
	int			[]products;
	// DroneType	type;

	Drone(Point pos, int []products /*, DroneType type */)
	{
		this.pos = pos;
		this.products = products;
		// this.type = type;
	}
}
