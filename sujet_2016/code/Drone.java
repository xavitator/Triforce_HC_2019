
// enum DroneType {
// 	Transport,
// 	Livraison,
// }

import java.awt.*;

class Drone {
	Point pos;
	int			[]products;
	int			timeout;
	// DroneType	type;

	Drone(Point pos, int []products /*, DroneType type */)
	{
		this.pos = pos;
		this.products = products;
		this.timeout = -1;
		// this.type = type;
	}
}
