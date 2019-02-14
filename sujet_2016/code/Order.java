import java.awt.*;
import java.util.ArrayList;

class Order {
	Point pos;
	ArrayList<Integer> products;
	boolean finished;

	Order(){}

	Order(Point pos, ArrayList<Integer> products, boolean finished) {
		this.pos = pos;
		this.products = products;
		this.finished = finished;
	}
}
