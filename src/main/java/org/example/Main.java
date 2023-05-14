package org.example;

public class Main {
    public static void main(String[] args) {

        ZooCatalog zooCatalog = new ZooCatalog();

        zooCatalog.addAnimal("Caine", "Rex");
        zooCatalog.addAnimal("Maimuta", "Lola");
        zooCatalog.addAnimal("Tigru", "Zorro");
        zooCatalog.addAnimal("Leu", "Regele");

        zooCatalog.updateNameOfAnimal("Tigru", "Pisicuta");

        zooCatalog.deleteAnimal("Caine");

    }
}