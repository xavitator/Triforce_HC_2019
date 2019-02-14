import java.awt.*;

class Warehouse {
	Point pos;
	int		[]products;

	Warehouse(){}

	Warehouse(Point pt, int []products)
	{
		this.pos = pt;
		this.products = products;
	}
}
