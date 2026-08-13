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
public class InventarioAnimales {
        //Clase de todos los métodos y procesos

    Scanner lector = new Scanner(System.in);
    ArrayList<Animal> misAnimales = new ArrayList<>();
    
    //Constructor vacío siempre 
    public InventarioAnimales(){
    }
    
    //Iniciamos creando los métodos
    public void registrarAnimal() //void es para cuando hay un cambio de estructura en los datos, aquí voy a agregar información. Es público porque lo voy a llamar desde otras clases.
    {
        System.out.println("Ingrese el código");
        int codigo = lector.nextInt(); 
       
        // Validación: código no repetido
        boolean codigoRepetido = true;
        while (codigoRepetido) {
            codigoRepetido = false;
        for (Animal a : misAnimales) {
            if (a.getCodigo() == codigo) {
                codigoRepetido = true;
                break;
            }
        }
            if (codigoRepetido) {
                System.out.println("Ese código ya existe. Ingrese un código diferente");
                codigo = lector.nextInt();
            }
        }
        lector.nextLine(); //Limpieza del buffer
        
        System.out.println("Ingrese el nombre del animal");
        String nombre = lector.nextLine();
        System.out.println("Ingrese la edad del animal");
        int edad = lector.nextInt();
        while (edad<0){
            System.out.println("La edad no puede ser negativa. Ingrese nuevamente");
            edad = lector.nextInt();
        }
        System.out.println("Ingrese el peso del animal");
        double peso = lector.nextDouble();
        while (peso<0){
            System.out.println("El peso no puede ser negativo. Ingrese nuevamente");
            peso = lector.nextDouble();
        }
        lector.nextLine(); 
        
        System.out.println("Ingrese el sexo del animal");
        String sexo = lector.nextLine();
        
        //Estado de Salud
        System.out.println("Seleccione el estado de salud: ");
        System.out.println("1. SANO");
        System.out.println("2. ENFERMO");
        System.out.println("3. EN_TRATAMIENTO");
        int opcionSalud = lector.nextInt();
        EstadoSalud estadoSalud;
        switch (opcionSalud){
            case 1:
                estadoSalud = EstadoSalud.SANO;
                break;
            case 2:
                estadoSalud = EstadoSalud.ENFERMO;
                break;
            case 3: 
                estadoSalud = EstadoSalud.EN_TRATAMIENTO;
                break;
            default:
                System.out.println("Opcion no válida. Se asigna SANO por defecto");
                estadoSalud = EstadoSalud.SANO;
                break;
        }
        
        //Estado de Inventario
        System.out.println("Seleccione el estado del inventario");
        System.out.println("1. ACTIVO");
        System.out.println("2. EN_OBSERVACION");
        System.out.println("3. RETIRADO");
        int opcionInventario = lector.nextInt();
        EstadoInventario estadoInventario;
        switch (opcionInventario){
            case 1:
                estadoInventario = EstadoInventario.ACTIVO;
                break;
            case 2:
                estadoInventario = EstadoInventario.EN_OBSERVACION;
                break;
            case 3:
                estadoInventario = EstadoInventario.RETIRADO;
                break;
            default:
                System.out.println("Opción no válida. Se asigna ACTIVO por defecto");
                estadoInventario = EstadoInventario.ACTIVO;
                break;
        }
        lector.nextLine();
        
        System.out.println("Ingrese la fecha de ingreso del animal");
        String fechaIngreso = lector.nextLine();
        System.out.println("Ingrese el hábitat asignado");
        String habitatAsignado = lector.nextLine();
        
        //Categoría
        System.out.println("Seleccione la categoría: ");
        System.out.println("1. Mamífero");
        System.out.println("2. Ave");
        System.out.println("3. Reptil");
        int categoria = lector.nextInt();
        lector.nextLine();
        
        Animal miAnimal = null;
        
        switch (categoria){
            case 1:
                System.out.println("Ingrese el tipo de pelaje: ");
                String tipoPelaje = lector.nextLine();
                miAnimal = new Mamifero(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, tipoPelaje);
                break;
            case 2:
                System.out.println("Ingrese la envergadura");
                double envergadura = lector.nextDouble();
                System.out.println("¿Puede volar? (True/False)");
                boolean puedeVolar = lector.nextBoolean();
                lector.nextLine();
                miAnimal = new Ave(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, envergadura, puedeVolar);
                break;
            case 3: 
                System.out.println("Ingrese el tipo de escamas: ");
                String tipoEscamas = lector.nextLine();
                miAnimal = new Reptil(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, tipoEscamas);
                break;
            default:
                System.out.println("Categoría no válida, no se registro el animal");
                return;
        }
        
        misAnimales.add(miAnimal);
        System.out.println("Animal registrado con exito");
    }
    
    public void listarAnimales(){
        if(misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        else{
            System.out.println("====LISTADO DE ANIMALES REGISTRADOS====");
            for(Animal a: misAnimales){
                a.mostrarInfo();
                System.out.println("=====================");
            }
        }
    }
    
    public void buscarAnimal(){
        System.out.println("Ingrese el código del animal");
        int codigo = lector.nextInt();
        
        if(misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        
        boolean encontrado = false;
        
        for(Animal a: misAnimales){
            if(a.getCodigo() == codigo){
                encontrado = true;
                System.out.println("Animal encontrado");
                a.mostrarInfo();
                break;
            }
        }
        
        if (encontrado == false){
            System.out.println("El codigo del animal no está registrado");
        }
    }
}    
    
