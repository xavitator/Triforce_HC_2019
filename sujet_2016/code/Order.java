
class Order {
	Point pos;
	int []products;
	boolean finished;

	Order(Point pos, int []products, boolean finished) {
		this.pos = pos;
		this.products = products;
		this.finished = finished;
	}
}
