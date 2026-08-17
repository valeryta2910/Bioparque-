/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author Tatiana Acosta
 */
public class Reptil extends Animal{
    private String tipoEscamas;
 
    //Constructor con los atributos
    public Reptil (int codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String fechaIngreso, String habitatAsignado, String tipoEscamas){
        super (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado);
        if (tipoEscamas == null || tipoEscamas.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de escamas no puede estar vacío");
        }
        this.tipoEscamas = tipoEscamas;
    }

    public String getTipoEscamas() {
        return tipoEscamas;
    }

    public void setTipoEscamas(String tipoEscamas) {
        if(tipoEscamas == null || tipoEscamas.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de escamas no puede estar vacío");
        }
        this.tipoEscamas = tipoEscamas;
    }
    
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tipo de Escamas: " + tipoEscamas);
    }
}
