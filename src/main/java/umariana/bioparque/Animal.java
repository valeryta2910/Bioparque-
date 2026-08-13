/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;

/**
 *
 * @author Tatiana Acosta
 */
public class Animal {
    //Atributos
    private int codigo;
    private String nombre;
    private int edad;
    private double peso;
    private String sexo;
    private EstadoSalud estadoSalud;
    private EstadoInventario estadoInventario;
    private String fechaIngreso;
    private String habitatAsignado;
    
    //Constructor vacío siempre
    public Animal(){
    }
    
    //Constructor con todos los atributos
    public Animal (int codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String fechaIngreso, String habitatAsignado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoSalud = estadoSalud;
        this.estadoInventario = estadoInventario;
        this.fechaIngreso = fechaIngreso;
        this.habitatAsignado = habitatAsignado;        
    }
    
    //Getter y Setter

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(EstadoSalud estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }

    public void setEstadoInventario(EstadoInventario estadoInventario) {
        this.estadoInventario = estadoInventario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHabitatAsignado() {
        return habitatAsignado;
    }

    public void setHabitatAsignado(String habitatAsignado) {
        this.habitatAsignado = habitatAsignado;
    }
    
    public void mostrarInfo(){
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);        
        System.out.println("Edad: " + edad);        
        System.out.println("Peso: " + peso);        
        System.out.println("Sexo: " + sexo);       
        System.out.println("Salud: " + estadoSalud);         
        System.out.println("Estado: " + estadoInventario);            
        System.out.println("Ingreso: " + fechaIngreso);        
        System.out.println("Hábitat: " + habitatAsignado);        
    }
}
