/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author Tatiana Acosta
 */
public class Ave extends Animal{
    private double envergadura;
    private boolean puedeVolar;
    
    //Constructor con los atributos
    public Ave (int codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String fechaIngreso, String habitatAsignado, double envergadura, boolean puedeVolar){
        super (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado);
        if(envergadura<0){
            throw new IllegalArgumentException("La envergadura no puede ser negativa");
        }
        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        if (envergadura<0){
            throw new IllegalArgumentException("La envergadura no puede ser negativa");
        }
        this.envergadura = envergadura;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Envergadura: " + envergadura);
        System.out.println("Vuela: " + (puedeVolar ? "Si" : "No"));    
        System.out.println("Alimentacion: " + obtenerTipoAlimentacion());
        System.out.println("Ración diaría recomendada: " + calcularRacionDiaria() + "kg");
    }
    
    //Aves del bioparque se alimentan de semillas, insectos o pescado. según su capacidad de vuelo y gasto energético al volar.
    @Override
    public String obtenerTipoAlimentacion(){
        return "Dieta de ave: semillas, insectos o pescado, ajustado a su capacidad de vuelo y gasto energético";
    }
    
    //Aves requieren acerca del 10% de su peso corporal al día
    @Override
    public double calcularRacionDiaria(){
        return getPeso() * 0.10;
    }
}
