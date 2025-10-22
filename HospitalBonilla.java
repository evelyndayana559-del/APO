/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalbonilla;

/**
 *
 * @author Evelin
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalBonilla { 
    private String gerente;
    private String nombre;
    private String direccion;
    private boolean tiene24Horas;
    private ArrayList<Persona> personas;
    private final int CAPACIDAD_MAXIMA = 100;
    
    public HospitalBonilla(String gerente, String nombre, String direccion,boolean tiene24horas ){
        this.gerente = gerente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tiene24Horas = tiene24Horas;
        this.personas= new ArrayList<>();
    }
    
    public HospitalBonilla() {
    this.nombre = "Sin nombre";
    this.direccion = "Sin dirección";
    this.gerente = "Sin gerente";
    this.tiene24Horas = false;
}
    
    public void agregarPersonas(Persona p) {
        personas.add(p);
        System.out.println("Persona agregada correctamente.");
    }
    
    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("\n--- LISTA DE PERSONAS ---");
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
    }

    public void guardarPersonas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("animales.txt"))) {
            for (Persona p : personas) {
                pw.println(p.toDataString());
            }
            System.out.println("Personas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las personas.");
        }
    }

    public void cargarPersonas() {
        personas.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String documento = partes[0];
                String nombre = partes[1];
                int edad = Integer.parseInt(partes[2]);

                Persona p = null;
                if (documento.equalsIgnoreCase("Doctores")) {
                    p = new Doctores(nombre, edad,documento);
                } else if (documento.equalsIgnoreCase("Enfermeros")) {
                    p = new Enfermeros(nombre, edad,documento); //ATRIBUTOS CAMBIAN\\
                }

                if (p != null) {
                    personas.add(p);
                }
            }
            System.out.println("Personas cargadas correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo previo, iniciando hospital vacio.");
        } catch (IOException e) {
            System.out.println("Error al cargar las personas.");
        }
    }
    
    // ----- MÉTODO PRINCIPAL -----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalBonilla hospital = new HospitalBonilla();

        int opcion;
        do {
            System.out.println("\n--- MENU HOSPITAL BONILLA ---");
            System.out.println("1. Agregar personas");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Guardar personas");
            System.out.println("4. Cargar personas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de persona (Doctores o Enfermeros): ");
                    String tipo = sc.nextLine().toLowerCase();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("documento: ");
                    String documento = sc.nextLine();

                    Persona p = null;
                    if (tipo.equals("Doctores")) {
                        p = new Doctores(nombre,edad,documento);
                    } else if (tipo.equals("Enfermero")) {
                        p = new Enfermeros(nombre, edad,documento);
                    } {
                        System.out.println("Tipo no valido.");
                    }

                    if (p != null) {
                        hospital.agregarPersonas(p);
                    }
                    break;

                case 2:
                    hospital.mostrarPersonas();
                    break;

                case 3:
                    hospital.guardarPersonas();
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
    //public void agregarPersona() {
   // Scanner sc = new Scanner(System.in);
    //System.out.print("Tipo de persona (Doctores o Enfermeros): ");
    //String tipo = sc.nextLine().trim();

    //System.out.print("Nombre: ");
    //String nombre = sc.nextLine().trim();

    //System.out.print("Edad: ");
    //int edad = Integer.parseInt(sc.nextLine().trim());

    //System.out.print("Documento: ");
    //String documento = sc.nextLine().trim();

    //Persona p = null;

    //if (tipo.equalsIgnoreCase("Doctores")) {
        //p = new Doctores(nombre, edad, documento);
    //} else if (tipo.equalsIgnoreCase("Enfermeros")) {
        //p = new Enfermeros(nombre, edad, documento);
    //} else {
        //System.out.println("Tipo no válido. Escriba 'Doctores' o 'Enfermeros'.");
        //return;
    //}

    //personas.add(p);
    ///System.out.println("✅ Persona agregada correctamente.\n");//*