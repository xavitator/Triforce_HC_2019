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
            ))).lines().iterator();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    static String[] getintel() {
        String[] mapintel = lignes.next().split(" ");
        return mapintel;
    }

    static int getNbProduct() {
        return Integer.parseInt(lignes.next());
    }

    static int[] getProductWeight() {
        String[] products = lignes.next().split(" ");
        int[] weight = new int[products.length];
        for (int i = 0 ; i < products.length ; i++) {
            weight[i] = Integer.parseInt(products[i]);
        }
        return weight;
    }

    static int getNbWarehouses() {
        return Integer.parseInt(lignes.next());
    }

    static Warehouse getWarehouseIntel(int nbProduct) {
        Warehouse w = new Warehouse();
        String[] line = lignes.next().split(" ");
        w.pos = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        line = lignes.next().split(" ");
        w.products = new int[nbProduct];
        for(int i = 0 ; i  < line.length ; i++) {
            w.products[i] = Integer.parseInt(line[i]);
        }
        return w;
    }

    static Warehouse[] getWarehousesIntel(int nbProduct) {
        int n = getNbWarehouses();
        Warehouse [] intels = new Warehouse[n];
        for(int i = 0 ; i < n ; i++) {
            intels[i] = getWarehouseIntel(nbProduct);
        }
        return intels;
    }

    static int nbCustomers() {
        return Integer.parseInt(lignes.next());
    }

    static Order CustomerOrder() {
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

    static  Order[] CustomersOrders() {
        int n = nbCustomers();
        Order [] customers = new Order[n];
        for (int i = 0 ; i < n ; i++) {
            customers[i] = CustomerOrder();
        }
        return customers;
    }


}
