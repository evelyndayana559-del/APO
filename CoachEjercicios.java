/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapo2;

/**
 *
 * @author Evelin
 */

public class CoachEjercicios extends Coach {
    private String tipoEntrenamiento;
    private double salarioBase;
    private double bonoEjercicios;

    public CoachEjercicios(String nombre, int id, int anosExperiencia, String tipoEntrenamiento, double salarioBase, double bonoEjercicios) {
        super(nombre, id, anosExperiencia);
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.salarioBase = salarioBase;
        this.bonoEjercicios = bonoEjercicios;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBonoEjercicios() {
        return bonoEjercicios;
    }

    
    public double calcularSalarioTotal() {
        return salarioBase + bonoEjercicios;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo entrenamiento: " + tipoEntrenamiento +
               " | Salario total: " + calcularSalarioTotal();
    }
}