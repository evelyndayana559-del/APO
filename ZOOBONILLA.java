/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoobonilla;

/**
 *
 * @author Evelin
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ZOOBONILLA {
    private ArrayList<Animal> animales = new ArrayList<>();

    // ----- MÉTODOS -----

    public void agregarAnimal(Animal a) {
        animales.add(a);
        System.out.println("Animal agregado correctamente.");
    }

    public void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            System.out.println("\n--- LISTA DE ANIMALES ---");
            for (Animal a : animales) {
                System.out.println(a);
            }
        }
    }

    public void guardarAnimales() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("animales.txt"))) {
            for (Animal a : animales) {
                pw.println(a.toDataString());
            }
            System.out.println("Animales guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los animales.");
        }
    }

    public void cargarAnimales() {
        animales.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("animales.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipo = partes[0];
                String nombre = partes[1];
                int edad = Integer.parseInt(partes[2]);

                Animal a = null;
                if (tipo.equalsIgnoreCase("Mamifero")) {
                    a = new Mamifero(nombre, edad);
                } else if (tipo.equalsIgnoreCase("Ave")) {
                    a = new Ave(nombre, edad); //ATRIBUTOS CAMBIAN\\
                } else if (tipo.equalsIgnoreCase("Pez")) {
                    a = new Pez(nombre, edad);
                }

                if (a != null) {
                    animales.add(a);
                }
            }
            System.out.println("Animales cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo previo, iniciando zoologico vacio.");
        } catch (IOException e) {
            System.out.println("Error al cargar los animales.");
        }
    }

    // ----- MÉTODO PRINCIPAL -----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZOOBONILLA zoo = new ZOOBONILLA();
        zoo.cargarAnimales();

        int opcion;
        do {
            System.out.println("\n--- MENU ZOOLOGICO ---");
            System.out.println("1. Agregar animal");
            System.out.println("2. Mostrar animales");
            System.out.println("3. Guardar animales");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de animal (mamifero, ave, pez): ");
                    String tipo = sc.nextLine().toLowerCase();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    Animal a = null;
                    if (tipo.equals("mamifero")) {
                        a = new Mamifero(nombre, edad);
                    } else if (tipo.equals("ave")) {
                        a = new Ave(nombre, edad);
                    } else if (tipo.equals("pez")) {
                        a = new Pez(nombre, edad);
                    } else {
                        System.out.println("Tipo no valido.");
                    }

                    if (a != null) {
                        zoo.agregarAnimal(a);
                    }
                    break;

                case 2:
                    zoo.mostrarAnimales();
                    break;

                case 3:
                    zoo.guardarAnimales();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 4);
    }
}
    

