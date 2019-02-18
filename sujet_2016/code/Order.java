import java.awt.*;
import java.util.ArrayList;

/**
 * Classe correspondant à un client et aux ordres à donner au drone
 */

class Order {
	Point pos; // position du client
	ArrayList<Integer> products; // Liste des produits dont a besoin le client
	boolean finished; // boolean correspondant à si le client a recu sa commande

	Order(){}

	Order(Point pos, ArrayList<Integer> products, boolean finished) {
		this.pos = pos;
		this.products = products;
		this.finished = finished;
	}
}
