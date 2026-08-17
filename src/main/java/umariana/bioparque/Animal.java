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
    private final int codigo;
    private String nombre;
    private int edad;
    private double peso;
    private String sexo;
    private EstadoSalud estadoSalud;
    private EstadoInventario estadoInventario;
    private final String fechaIngreso;
    private String habitatAsignado;
    
    //Constructor con todos los atributos
    public Animal (int codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String fechaIngreso, String habitatAsignado){
        
        if(codigo<=0){
            throw new IllegalArgumentException("El código debe ser un número positivo");
        }
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if(peso <= 0){
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
        if(sexo == null || sexo.trim().isEmpty()){
            throw new IllegalArgumentException("El sexo no puede estar vacío");
        }
        if(habitatAsignado == null || habitatAsignado.trim().isEmpty()){
            throw new IllegalArgumentException("El hábitat asignado no puede estar vacío");
        }
        if(fechaIngreso == null || fechaIngreso.trim().isEmpty()){
            throw new IllegalArgumentException("La fecha de ingreso no puede estar vacía");
        }
        
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

    public String getNombre() {
        return nombre;
    }
    public void corregirNombre(String nuevoNombre){
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nuevoNombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }
    public void validarQueSigaBajoCuidado(){
        if(this.estadoInventario == EstadoInventario.RETIRADO){
            throw new IllegalArgumentException("No se puede actualizar este dato: el animal está retirado");
        }
        if(this.estadoInventario == EstadoInventario.FALLECIDO){
            throw new IllegalArgumentException("No se puede actualizar este dato: el animal está fallecido");
        }
    }
    public void actualizarPeso(double nuevoPeso){
        validarQueSigaBajoCuidado();
        if(nuevoPeso<=0){
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
        this.peso = nuevoPeso;
    }

    public String getSexo() {
        return sexo;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }
    public void cambiarEstadoSalud(EstadoSalud nuevoEstado){
        validarQueSigaBajoCuidado();
        if(nuevoEstado == null){
            throw new IllegalArgumentException("El estado de salud no puede ser nulo");
        }
        this.estadoSalud = nuevoEstado;
    }

    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }
    public void ponerEnObservacion(){
        if(this.estadoInventario == EstadoInventario.RETIRADO){
            throw new IllegalArgumentException("No se puede poner en observación un animal retirado");
        }
        if(this.estadoInventario == EstadoInventario.FALLECIDO){
            throw new IllegalArgumentException("No se puede poner en observación un animal fallecido");
        }
        this.estadoInventario = EstadoInventario.EN_OBSERVACION;
    }
    public void activar(){
        if(this.estadoInventario == EstadoInventario.RETIRADO){
            throw new IllegalArgumentException("No se puede activar un animal retirado");
        }
        if(this.estadoInventario == EstadoInventario.FALLECIDO){
            throw new IllegalArgumentException("No se puede activar un animal fallecido");
        }
        this.estadoInventario = EstadoInventario.ACTIVO;
    }
    //retirar(). No falleció, rpresenta que el animal salió de bioparque, pero sigue vivo
    public void retirar(){
        if(this.estadoInventario == EstadoInventario.RETIRADO){
            throw new IllegalArgumentException("El animal ya esta retirado");
        }
        if(this.estadoInventario == EstadoInventario.FALLECIDO){
            throw new IllegalArgumentException("No se puede retirar un animal fallecido");
        }
        this.estadoInventario = EstadoInventario.RETIRADO;
    }
    // Fallecimiento, irreversible, el animal murió, no salió vivo de bioparque, se conserva en el inventario su historial
    public void registrarFallecimiento(){
        if(this.estadoInventario == EstadoInventario.FALLECIDO){
            throw new IllegalArgumentException("El animal ya esta registrado como fallecido");
        }
        if(this.estadoInventario == EstadoInventario.RETIRADO){
            throw new IllegalArgumentException("No se puede registrar el fallecimiento de un animal ya retirado del bioparque");
        }
        this.estadoInventario = EstadoInventario.FALLECIDO;
    }
    
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHabitatAsignado() {
        return habitatAsignado;
    }
    public void trasladarHabitat(String nuevoHabitat){
        validarQueSigaBajoCuidado();
        if(nuevoHabitat == null || nuevoHabitat.trim().isEmpty()){
            throw new IllegalArgumentException("El hábitat no puede estar vacío");
        }
        this.habitatAsignado = nuevoHabitat;
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
