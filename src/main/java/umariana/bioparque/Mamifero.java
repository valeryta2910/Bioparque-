/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author Tatiana Acosta
 */
public class Mamifero extends Animal{
    private String tipoPelaje;
    
    //Constructor con los atributos
    public Mamifero (int codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String fechaIngreso, String habitatAsignado, String tipoPelaje){
        super (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado);
        if(tipoPelaje == null || tipoPelaje.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de pelaje no puede estar vacío");
        }
        this.tipoPelaje = tipoPelaje;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }
    public void setTipoPelaje(String tipoPelaje){
        if(tipoPelaje == null || tipoPelaje.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de pelaje no puede estar vacío");
        }
        this.tipoPelaje = tipoPelaje;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tipo de Pelaje: " + tipoPelaje);
        System.out.println("Alimentación: " + obtenerTipoAlimentacion());
        System.out.println("Ración diaría recomendada: " + calcularRacionDiaria() + "kg");
    }
    
    //Mamíferos de Bioparque combinan forraje, frutas y proteina
    @Override
    public String obtenerTipoAlimentacion(){
        return "Dieta de mamífero: forraje, frutas y proteina animal, ajustada según la especie";
    }
    
    //Un mamífero requiere en promedio cerca del 5% de su peso corporal en alimento al día.
    @Override
    public double calcularRacionDiaria(){
        return getPeso() * 0.05;
    }
}