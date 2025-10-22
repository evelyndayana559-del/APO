/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalbonilla;

/**
 *
 * @author Evelin
 */
public abstract class Persona {
    protected String nombre;
    protected int edad;
    protected String documento;
    
    public Persona (String nombre, int edad,String docuento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento= documento;
        
    }
    
    public abstract String getTipo();
    
    @Override
    //Metodo para mostrar en consola
    public String toString() {
        return getTipo() + " - Nombre: " + nombre + ", Edad: " + edad +"- documento:"+ documento;
    }
     // Método para convertir a texto (para guardar)
    public String toDataString() {
        return getTipo() + ";" + nombre + ";" + edad + ";" + documento;
    
    }    
}
