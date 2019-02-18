import java.awt.*;
import java.io.*;
import java.util.*;

public class ReadFile {
    static Iterator<String> lignes;

    /**
     * Constructeur
     * @param src fichier à lire
     */

    static void setup(String src) {
        try {
            lignes = (new BufferedReader(new InputStreamReader(
                    new FileInputStream(src)
            ))).lines().iterator(); // Itérateur sur les lignes
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    static String[] getintel() {
        String[] mapintel = lignes.next().split(" "); // Récupère la première ligne
        return mapintel;
    }

    static int getNbProduct() { // Récupère le nombre de produits globaux
        return Integer.parseInt(lignes.next());
    }

    static int[] getProductWeight() { // Récupère le poids de chaque produit
        String[] products = lignes.next().split(" ");
        int[] weight = new int[products.length];
        for (int i = 0 ; i < products.length ; i++) {
            weight[i] = Integer.parseInt(products[i]);
        }
        return weight;
    }

    static int getNbWarehouses() { // Donne le nombre total d'entrepots
        return Integer.parseInt(lignes.next());
    }

    static Warehouse getWarehouseIntel(int nbProduct) { // Rempli les données pour un entrepot
        Warehouse w = new Warehouse();
        String[] line = lignes.next().split(" ");
        w.pos = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])); // Position
        line = lignes.next().split(" ");
        w.products = new int[nbProduct];
        for(int i = 0 ; i  < line.length ; i++) {
            w.products[i] = Integer.parseInt(line[i]); // Indice produit et le nombre
        }
        return w;
    }

    static Warehouse[] getWarehousesIntel(int nbProduct) { // Ensemble des données des entrepots
        int n = getNbWarehouses();
        Warehouse [] intels = new Warehouse[n];
        for(int i = 0 ; i < n ; i++) {
            intels[i] = getWarehouseIntel(nbProduct);
        }
        return intels;
    }

    static int nbCustomers() { // Nombre de clients globaux
        return Integer.parseInt(lignes.next());
    }

    static Order CustomerOrder() { // Récupère les commandes d'un client
        String[] values = lignes.next().split(" ");
        Order o = new Order();
        o.pos = new Point(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
        int nbProducts = Integer.parseInt(lignes.next());
        o.products = new ArrayList<>();
        values = lignes.next().split(" ");
        for (int i = 0 ; i < nbProducts ; i++) {
           o.products.add(Integer.parseInt(values[i]));
        }
        return o;
    }

    static  Order[] CustomersOrders() { // Récupère l'ensemble des données de commandes des clients
        int n = nbCustomers();
        Order [] customers = new Order[n];
        for (int i = 0 ; i < n ; i++) {
            customers[i] = CustomerOrder();
        }
        return customers;
    }


}
