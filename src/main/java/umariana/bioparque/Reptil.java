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
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tipo de Escamas: " + tipoEscamas);
        System.out.println("Alimentación: " + obtenerTipoAlimentacion());
        System.out.println("Ración diaría recomendada: " + calcularRacionDiaria() + "kg");
    }
    
    //Reptiles en bioparque se alimentan de insectos, roedores pequeños o vegetación
    @Override
    public String obtenerTipoAlimentacion(){
        return "Dieta de reptil: insectos, roedores pequeños o vegetación con baja frecuencia por su metabolismo lento";
    }
    
    //Reptiles tienen metabolismo lento, por eso su ración diaria equivale a aproximadamente el 2% de su peso
    @Override
    public double calcularRacionDiaria(){
        return getPeso() * 0.02;
    }
}
