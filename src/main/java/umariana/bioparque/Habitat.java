/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.bioparque;
import java.util.*;

/**
 *
 * @author Tatiana Acosta
 */
public class Habitat {
    private String nombreHabitat;
    private int temperatura;
    private int capacidadMaxima;
    private ArrayList<Animal>animalesEnHabitat;
    
    public Habitat(String nombreHabitat, int temperatura, int capacidadMaxima) {
        if (nombreHabitat == null || nombreHabitat.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del hábitat no puede estar vacío");
        }
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0");
        }
        this.nombreHabitat = nombreHabitat;
        this.temperatura = temperatura;
        this.capacidadMaxima = capacidadMaxima;
        this.animalesEnHabitat = new ArrayList<>();
    }
 
    public String getNombreHabitat() {
        return nombreHabitat;
    }
 
    public int getTemperatura() {
        return temperatura;
    }
 
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
 
    public ArrayList<Animal> getAnimalesEnHabitat() {
        return animalesEnHabitat;
    }
 
    public int contarAnimales() {
        return animalesEnHabitat.size();
    }
 
    public boolean hayEspacioDisponible() {
        return animalesEnHabitat.size() < capacidadMaxima;
    }
 
    /**
     * Agrega un animal al hábitat, solo si hay espacio disponible. Es el
     * propio Habitat el que protege esta invariante, no quien lo use.
     */
    public void agregarAnimal(Animal animal) {
        if (!hayEspacioDisponible()) {
            throw new IllegalArgumentException("El hábitat " + nombreHabitat + " ya alcanzó su capacidad máxima (" + capacidadMaxima + ")");
        }
        animalesEnHabitat.add(animal);
    }
 
    /**
     * Quita un animal de este hábitat (se usa cuando el animal se traslada
     * a otro hábitat distinto).
     */
    public void retirarAnimalDeHabitat(Animal animal) {
        animalesEnHabitat.remove(animal);
    }
}

