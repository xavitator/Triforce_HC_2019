package code;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;

public class ReadFile {
    static Iterator<String> lignes;

    /**
     * Constructeur
     * @param src fichier à lire
     */
    ReadFile(String src) {
        try {
        lignes = (new BufferedReader(new InputStreamReader(
                new FileInputStream(src)
            ))).lines().iterator();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    String[] getintel() {
        String[] mapintel = lignes.next().split(" ");
        return mapintel;
    }

    int getNbProduct() {
        return Integer.parseInt(lignes.next());
    }

    int[] getProductWeight() {
        String[] products = lignes.next().split(" ");
        int[] weight = new int[products.length];
        for (int i = 0 ; i < products.length ; i++) {
            weight[i] = Integer.parseInt(products[i]);
        }
        return weight;
    }

    int getNbWarehouses() {
        return Integer.parseInt(lignes.next());
    }

    int[] getWarehouseIntel(int nbProduct) {
        int[] tmp = new int[2+nbProduct];
        String[] line = lignes.next().split(" ");
        tmp[0] = Integer.parseInt(line[0]);
        tmp[1] = Integer.parseInt(line[1]);
        line = lignes.next().split(" ");
        for(int i = 0 ; i  < line.length ; i++) {
            tmp[i+2] = Integer.parseInt(line[i]);
        }
        return tmp;
    }

    int[][] getWarehousesIntel(int nbProduct) {
        int n = getNbWarehouses();
        int [][] tab = new int[n][];
        for(int i = 0 ; i < n ; i++) {
            tab[i] = getWarehouseIntel(nbProduct);
            i++;
        }
        return tab;
    }

    int nbCustomers() {
        return Integer.parseInt(lignes.next());
    }

    int[] CustomerOrder() {
        String[] values = lignes.next().split(" ");
        Point p = new Point(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
        int nbProducts = Integer.parseInt(lignes.next());
        int [] customer = new int[2 + nbProducts];
        customer[0] = p.x;
        customer[1] = p.y;
        values = lignes.next().split(" ");
        for (int i = 0 ; i < nbProducts ; i++) {
            customer[i+2] = Integer.parseInt(values[i]);
        }
        return customer;
    }

    int[][] CustomersOrders() {
        int n = nbCustomers();
        int[][] customers = new int[n][];
        for (int i = 0 ; i < n ; i++) {
            customers[i] = CustomerOrder();
        }
        return customers;
    }


}
