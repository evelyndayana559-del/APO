/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoobonilla;

/**
 *
 * @author Evelin
 */
public abstract class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " - Nombre: " + nombre + ", Edad: " + edad;
    }

    // Método para convertir a texto (para guardar)
    public String toDataString() {
        return getTipo() + ";" + nombre + ";" + edad;
    }
}

