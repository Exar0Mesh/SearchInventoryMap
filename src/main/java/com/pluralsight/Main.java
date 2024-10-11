package com.pluralsight;

import javax.lang.model.element.Name;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            HashMap<String, Product> inventory = loadInventory();

            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] lineSplit = input.split(Pattern.quote("|"));
                int id = Integer.parseInt(lineSplit[0]);
                String names = lineSplit[1];
                float price = Float.parseFloat(lineSplit[2]);

                inventory.put(names, new Product(id, names, price));
            }

                Scanner scanner = new Scanner(System.in);

                System.out.print("What item name are you interested in? ");
                String name = scanner.nextLine();

                Product matchedProduct = inventory.get(name);
                if (matchedProduct == null) {
                    System.out.println("We don't carry that product");
                    return;
                }
                System.out.printf("We carry %s and the price is $%.2f",
                        matchedProduct.getName(), matchedProduct.getPrice());

        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
        }

    }
    public static HashMap<String, Product> loadInventory() {
        HashMap<String, Product> inventory = new HashMap<String, Product>();
        return inventory;
        }
}