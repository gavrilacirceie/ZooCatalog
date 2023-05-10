package org.example;

import java.io.*;
import java.util.*;

public class ZooCatalog {
    private static final String CSV_FILE_PATH = "zoo_catalog.csv";
    private Map<String, String> animalMap;

    public ZooCatalog() {
        animalMap = new HashMap<>();
        loadCatalog();
    }

    public void addNameToAnimal(String animal, String name) {
        if (!animalMap.containsKey(animal)) {
            animalMap.put(animal, name);
            saveCatalog();
            System.out.println("Name '" + name + "' added to animal '" + animal + "' successfully.");
        } else {
            System.out.println("Animal '" + animal + "' already exists.");
        }
    }

    public String readNameOfAnimal(String animal) {
        if (animalMap.containsKey(animal)) {
            return animalMap.get(animal);
        } else {
            System.out.println("Animal '" + animal + "' does not exist.");
            return null;
        }
    }

    public void updateNameOfAnimal(String animal, String newName) {
        if (animalMap.containsKey(animal)) {
            animalMap.put(animal, newName);
            saveCatalog();
            System.out.println("Name of animal '" + animal + "' updated to '" + newName + "' successfully.");
        } else {
            System.out.println("Animal '" + animal + "' does not exist.");
        }
    }

    public void deleteAnimal(String animal) {
        if (animalMap.containsKey(animal)) {
            animalMap.remove(animal);
            saveCatalog();
            System.out.println("Animal '" + animal + "' entry deleted successfully.");
        } else {
            System.out.println("Animal '" + animal + "' does not exist.");
        }
    }

    private void loadCatalog() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    String animal = values[0];
                    String name = values[1];
                    animalMap.put(animal, name);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load the zoo catalog.");
            e.printStackTrace();
        }
    }

    private void saveCatalog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Map.Entry<String, String> entry : animalMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save the zoo catalog.");
            e.printStackTrace();
        }
    }
}

