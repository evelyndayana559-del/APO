/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapo2;

/**
 *
 * @author Evelin
 */

public class CoachNutricionista extends Coach {
    private String especialidad;
    private double salarioBase;
    private double bonoNutricionista;

    public CoachNutricionista(String nombre, int id, int anosExperiencia, String especialidad, double salarioBase, double bonoNutricionista) {
        super(nombre, id, anosExperiencia);
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;
        this.bonoNutricionista = bonoNutricionista;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBonoNutricionista() {
        return bonoNutricionista;
    }

    
    public double calcularSalarioTotal() {
        return salarioBase + bonoNutricionista;
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: " + especialidad +
               " | Salario total: " + calcularSalarioTotal();
    }
}
