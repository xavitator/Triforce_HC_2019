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

	boolean	getProductAndLoad(int id, int amount)
	{
		if (products[id] < amount)
			return (false);
		products[id] -= amount;
		return (true);
	}
}
