import java.awt.*;

/**
 * Objet représentant un entrepot
 */
class Warehouse {
	Point pos; // position en 2D de l'entrepot
	int		[]products; // nombre de produits contenu dans l'entrepot

	Warehouse(){}

	Warehouse(Point pt, int []products)
	{
		this.pos = pt;
		this.products = products;
	}

	/**
	 * On recupère le nombre, 'amont', du produit 'id'.
	 * On décrémente le nombre correspondant de produits s'il y a assez de produit (et on retourne true)
	 * sinon, on retourne false
	 * @param id id du produit à charger
	 * @param amount quantité du produit à charger
	 * @return true si tout s'est bien passé, false sinon.
	 */
	boolean	getProductAndLoad(int id, int amount)
	{
		if (products[id] < amount)
			return (false);
		products[id] -= amount;
		return (true);
	}
}
