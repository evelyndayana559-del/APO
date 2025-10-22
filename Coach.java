/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapo2;

/**
 *
 * @author Evelin
 */
public abstract class Coach {
    protected String nombre;
    protected int id;
    protected int anosExperiencia;

    public Coach(String nombre, int id, int anosExperiencia) {
        this.nombre = nombre;
        this.id = id;
        this.anosExperiencia = anosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public abstract double calcularSalarioTotal();

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Años de experiencia: " + anosExperiencia;
    }
}