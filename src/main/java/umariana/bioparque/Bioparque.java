/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.bioparque;
import java.util.*;

/**
 *
 * @author Tatiana Acosta
 */
public class Bioparque {

    public static void main(String[] args) {
        InventarioAnimales gestionar = new InventarioAnimales();
        Scanner lector = new Scanner(System.in);
        boolean activo = true;
        int opc;
        
        // contruir el menú
        do {
            System.out.println("==== BIENVENIDO A BIOPARQUE PASTO====");
            System.out.println("1. Registar animal");
            System.out.println("2. Listar todos los animales");
            System.out.println("3. Buscar animal por codigo");
            System.out.println("4. Actualizar datos de un animal");
            System.out.println("5. Retirar animal");
            System.out.println("6. Fltrar por categoria o estado");
            System.out.println("7. Ejecutar comportamientos");
            System.out.println("8. Ver resumen del inventario");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            
            try {
                opc = Integer.parseInt(lector.nextLine());
            } catch (NumberFormatException e) {
                opc = -1; // Le asignamos -1 para que caiga en el default del switch
            }
            
            switch (opc) {
                case 1 ->gestionar.registrarAnimal();
                case 2 ->gestionar.listarAnimales();  
                case 3 ->gestionar.buscarAnimal();  
                case 4 ->gestionar.actualizarDatosAnimal(); 
                case 5 ->gestionar.retirarAnimal();
                case 6 ->gestionar.filtrarInventario();
                case 7 ->System.out.println("ejecutarComportamiento");
                case 8 ->System.out.println("resumenInventario");
                case 0 ->{
                    activo = false;
                    System.out.println("usted ha salido del sistema ");
                }
                default ->
                    System.out.println("Ha ingresado mal la opcion");
            }

        } while (activo);
    }
}
