
// enum DroneType {
// 	Transport,
// 	Livraison,
// }

import java.awt.*;

/**
 * Classe correspondant à un drone
 */
class Drone {
	Point pos; // position du drone
	// int			[]products; // quantité de chaque produit que contient le drone
	int			timeout; // timeout du drone
	// DroneType	type; // type du drone

	Drone(/*, DroneType type */)
	{
		this.pos = new Point(0, 0);
		// this.products = products;
		this.timeout = -1;
		// this.type = type;
	}
}
