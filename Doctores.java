/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalbonilla;

/**
 *
 * @author Evelin
 */
public class Doctores extends Persona {
    public Doctores (String nombre,int edad,String documento){
        super(nombre,edad,documento);
    }
 @Override
 public String getTipo(){
     return"Doctores";
 }
            
    
}
