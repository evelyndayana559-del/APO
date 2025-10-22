/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



/**
 *
 * @author Evelin
 */

package gymapo2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GYMAPO2 {
    private String gerente;
    private String nombre;
    private String direccion;
    private boolean tiene24Horas;
    private ArrayList<Coach> coaches;
    private final int CAPACIDAD_MAXIMA = 50;
    
    public GYMAPO2(String gerente, String nombre, String direccion, boolean tiene24Horas) {
        this.gerente = gerente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tiene24Horas = tiene24Horas;
        this.coaches = new ArrayList<>();
    }

    public void agregarCoach(Coach coach) {
        if (coaches.size() < CAPACIDAD_MAXIMA) {
            coaches.add(coach);
            System.out.println("Coach agregado: " + coach.getNombre());
        } else {
            System.out.println("El gym está lleno. No se pueden agregar más coaches.");
        }
    }

    public void eliminarCoach(String nombre) {
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getNombre().equalsIgnoreCase(nombre)) {
                coaches.remove(i);
                System.out.println("Coach eliminado: " + nombre);
                return;
            }
        }
        System.out.println("Coach no encontrado: " + nombre);
    }

    public Coach consultarCoach(int indice) {
        if (indice >= 0 && indice < coaches.size()) {
            return coaches.get(indice);
        } else {
            return null;
        }
    }

    public void mostrarCoaches() {
        System.out.println("\n=== LISTA DE COACHES ===");
        if (coaches.isEmpty()) {
            System.out.println("No hay coaches en el gym.");
        } else {
            for (int i = 0; i < coaches.size(); i++) {
                System.out.println("[" + i + "] " + coaches.get(i).toString());
            }
            System.out.println("Total de coaches: " + coaches.size() + " / " + CAPACIDAD_MAXIMA);
        }
    }

    public void mostrarInfo() {
        System.out.println("\n--- Información del Gym ---");
        System.out.println("Gerente: " + gerente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Abierto 24 horas: " + (tiene24Horas ? "Sí" : "No"));
        System.out.println("---------------------------");
    }

    public int getCantidadCoaches() {
        return coaches.size();
    }

    public String getGerente() {
        return gerente;
    }

    // =====================================================
    // GUARDAR / CARGAR COACHES
    // =====================================================

    public void guardarCoaches(String archivo) {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8"))) {
            for (Coach c : coaches) {
                if (c instanceof CoachNutricionista) {
                    CoachNutricionista cn = (CoachNutricionista) c;
                    writer.println(String.join(";",
                            "N",
                            String.valueOf(cn.getId()),
                            cn.getNombre(),
                            String.valueOf(cn.getAnosExperiencia()),
                            cn.getEspecialidad(),
                            String.valueOf(cn.getSalarioBase()),
                            String.valueOf(cn.getBonoNutricionista())
                    ));
                } else if (c instanceof CoachEjercicios) {
                    CoachEjercicios ce = (CoachEjercicios) c;
                    writer.println(String.join(";",
                            "E",
                            String.valueOf(ce.getId()),
                            ce.getNombre(),
                            String.valueOf(ce.getAnosExperiencia()),
                            ce.getTipoEntrenamiento(),
                            String.valueOf(ce.getSalarioBase()),
                            String.valueOf(ce.getBonoEjercicios())
                    ));
                }
            }
            System.out.println("Coaches guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarCoaches(String archivo) {
        coaches.clear();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "UTF-8"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");
                String tipo = datos[0];
                int id = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                int anos = Integer.parseInt(datos[3]);

                if (tipo.equals("N")) {
                    String especialidad = datos[4];
                    double base = Double.parseDouble(datos[5]);
                    double bono = Double.parseDouble(datos[6]);
                    coaches.add(new CoachNutricionista(nombre, id, anos, especialidad, base, bono));
                } else if (tipo.equals("E")) {
                    String tipoEntrenamiento = datos[4];
                    double base = Double.parseDouble(datos[5]);
                    double bono = Double.parseDouble(datos[6]);
                    coaches.add(new CoachEjercicios(nombre, id, anos, tipoEntrenamiento, base, bono));
                }
            }
            System.out.println("Coaches cargados correctamente desde " + archivo);
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }

    // =====================================================
    // MENÚ PRINCIPAL
    // =====================================================
    public static void main(String[] args) {
        GYMAPO2 miGym = new GYMAPO2("Julian Alvarez", "PowerGym", "Calle Falsa 123", true);
        Scanner sc = new Scanner(System.in, "UTF-8");
        int opcion;
        String archivo = "coaches.txt";

        do {
            System.out.println("\n=== MENÚ GYM ===");
            System.out.println("1. Agregar coach");
            System.out.println("2. Mostrar coaches");
            System.out.println("3. Eliminar coach");
            System.out.println("4. Guardar coaches en archivo");
            System.out.println("5. Cargar coaches desde archivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de coach (N=Nutricionista / E=Ejercicios): ");
                    String tipo = sc.nextLine().toUpperCase();
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Años de experiencia: ");
                    int anos = Integer.parseInt(sc.nextLine());
                    System.out.print("Salario base: ");
                    double base = Double.parseDouble(sc.nextLine());
                    System.out.print("Bono: ");
                    double bono = Double.parseDouble(sc.nextLine());

                    if (tipo.equals("N")) {
                        System.out.print("Especialidad: ");
                        String esp = sc.nextLine();
                        miGym.agregarCoach(new CoachNutricionista(nombre, id, anos, esp, base, bono));
                    } else if (tipo.equals("E")) {
                        System.out.print("Tipo de entrenamiento: ");
                        String te = sc.nextLine();
                        miGym.agregarCoach(new CoachEjercicios(nombre, id, anos, te, base, bono));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    miGym.mostrarCoaches();
                    break;

                case 3:
                    System.out.print("Nombre del coach a eliminar: ");
                    miGym.eliminarCoach(sc.nextLine());
                    break;

                case 4:
                    miGym.guardarCoaches(archivo);
                    break;

                case 5:
                    miGym.cargarCoaches(archivo);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
    


   