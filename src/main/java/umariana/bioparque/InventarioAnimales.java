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
    ArrayList<Habitat> misHabitats = new ArrayList<>();
    
    private int siguienteCodigo = 1;
    
    public InventarioAnimales(){
        //Los hpabitatas están definidos y delimintados desde el inicio.
        misHabitats.add(new Habitat("Sabana", 25, 10));
        misHabitats.add(new Habitat("Bosque tropical", 28, 8));
        misHabitats.add(new Habitat("Paramo", 12, 6));
        misHabitats.add(new Habitat("Acuario", 22, 15));
        misHabitats.add(new Habitat("Aviario", 20, 12));
    }
    
    private Animal buscarPorCodigo(int codigo) {
        for (Animal a : misAnimales) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }
    
    //Muestra la tabla fija de hábitats 
    private Habitat seleccionarHabitat(){
        System.out.println("Seleccione el hábitat: ");
        for(int i=0; i < misHabitats.size(); i++){
            Habitat h = misHabitats.get(i);
            System.out.println((i + 1) + ". " + h.getNombreHabitat() + " (Temperatura: " + h.getTemperatura() + "°C, cupos disponibles: " + (h.getCapacidadMaxima()-h.contarAnimales()) + "/" + h.getCapacidadMaxima() + ")");
        }
        int opcion = lector.nextInt();
        lector.nextLine();
        if (opcion < 1 || opcion > misHabitats.size()){
            throw new IllegalArgumentException("Hábitat no válido");
        }
        return misHabitats.get(opcion - 1);
    }
    
    //Iniciamos creando los métodos
    public void registrarAnimal() //void es para cuando hay un cambio de estructura en los datos, aquí voy a agregar información. Es público porque lo voy a llamar desde otras clases.
    {
        //PRUEBA intento controlado de instanciar Animal 
        //Animal test = new Animal (1, "Test", 2, 5.0, "M", EstadoSalud.SANO, EstadoInventario.ACTIVO, "2026-08-19, new Habitat("Sabana", 25, 15); 
                
        int codigo = siguienteCodigo;
        
        try{
            System.out.println("Ingrese el nombre del animal");
            String nombre = lector.nextLine();
            System.out.println("Ingrese la edad del animal");
            int edad = lector.nextInt();
            System.out.println("Ingrese el peso del animal");
            double peso = lector.nextDouble();
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
            Habitat habitatAsignado = seleccionarHabitat();

            //Categoría
            System.out.println("Seleccione la categoría: ");
            System.out.println("1. Mamífero");
            System.out.println("2. Ave");
            System.out.println("3. Reptil");
            int categoria = lector.nextInt();
            lector.nextLine();

            
            Animal miAnimal;
            switch (categoria){
                case 1:
                    System.out.println("Ingrese el tipo de pelaje: ");
                    String tipoPelaje = lector.nextLine();
                    miAnimal = new Mamifero(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, tipoPelaje);
                    break;
                case 2:
                    System.out.println("Ingrese la envergadura: ");
                    double envergadura = lector.nextDouble();
                    System.out.println("¿Puede volar? (True/False)");
                    boolean puedeVolar = lector.nextBoolean();
                    lector.nextLine();
                    miAnimal = new Ave (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, envergadura, puedeVolar);
                    break;
                case 3: 
                    System.out.println("Ingrese el tipo de escamas: ");
                    String tipoEscamas = lector.nextLine();
                    miAnimal = new Reptil (codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, fechaIngreso, habitatAsignado, tipoEscamas);
                    break;
                default:
                    System.out.println("Categoría no válida, no se registro el animal");
                    return;
            }

            misAnimales.add(miAnimal);
            System.out.println("Animal registrado con éxito. Código asignado: " + codigo);
            siguienteCodigo ++;

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo registrar el animal " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("No se pudo registrar el animal: dato con formato inválido");
            lector.nextLine();
        }
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
        if(misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        
        try{
            System.out.println("Ingrese el código del animal");
            int codigo = lector.nextInt();
        
            Animal encontrado = buscarPorCodigo(codigo);
        
            if (encontrado != null){
                System.out.println("Animal encontrado: ");
                encontrado.mostrarInfo();
            }
            else {
                System.out.println("El código del animal no está registrado");
            }
        } catch(InputMismatchException e){
            System.out.println("Debe ingresar un número válido para el código");
            lector.nextLine();
        }
    }
    
    public void actualizarDatosAnimal(){
        
        if (misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        
        try{
            
            System.out.println("Ingrese el código del animal a actualizar: ");
            int codigo = lector.nextInt();
            lector.nextLine();
        
            Animal encontrado = buscarPorCodigo(codigo);
        
            if (encontrado == null){
                System.out.println("El código del animal no está registrado");
                return;
            }
        
            System.out.println("¿Qué desea actualizar?");
            System.out.println("1. Peso");
            System.out.println("2. Hábitat");
            System.out.println("3. Estado de Salud");
            System.out.println("4. Nombre");
            System.out.println("5. Estado de inventario (ACTIVO/EN_OBSERVACIÓN/FALLECIDO)");
            System.out.println("6. Celebrar cumpleaños (Incrementar edad)");
            int opcion = lector.nextInt();
            lector.nextLine();
        
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nuevo peso: ");
                    double nuevoPeso = lector.nextDouble();
                    lector.nextLine();
                    encontrado.actualizarPeso(nuevoPeso);
                    System.out.println("Peso actualizado con éxito");
                    break;
                case 2:
                    Habitat nuevoHabitat = seleccionarHabitat();
                    encontrado.trasladarHabitat(nuevoHabitat);
                    System.out.println("Hábitat actualizado con éxito");
                    break;
                case 3:
                    System.out.println("Seleccione el nuevo estado de salud: ");
                    System.out.println("1. SANO");
                    System.out.println("2. ENFERMO");
                    System.out.println("3. EN_TRATAMIENTO");
                    int opcionSalud = lector.nextInt();
                    lector.nextLine();
                    EstadoSalud nuevoEstado;
                            
                    switch (opcionSalud){
                        case 1:
                            nuevoEstado = EstadoSalud.SANO;
                            break;
                        case 2:
                            nuevoEstado = EstadoSalud.ENFERMO;
                            break;
                        case 3:
                            nuevoEstado = EstadoSalud.EN_TRATAMIENTO;
                            break;
                        default:
                            System.out.println("Opción no válida");
                            return;
                    }
                    encontrado.cambiarEstadoSalud(nuevoEstado);
                    System.out.println("Estado de salud actualizado con éxito");
                    break;
                case 4: 
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nuevoNombre = lector.nextLine();
                    encontrado.corregirNombre(nuevoNombre);
                    System.out.println("Nombre actualizado con éxito");
                    break;
                case 5:
                    System.out.println("Seleccione el nuevo estado del inventario: ");
                    System.out.println("1. ACTIVO");
                    System.out.println("2. EN_OBSERVACIÓN");
                    System.out.println("3. FALLECIDO");
                    int opcionInv = lector.nextInt();
                    lector.nextLine();
                    
                    switch (opcionInv){
                        case 1:
                            encontrado.activar();
                            break;
                        case 2:
                            encontrado.ponerEnObservacion();
                            break;
                        case 3:
                            encontrado.registrarFallecimiento();
                            break;
                        default:
                            System.out.println("Opción no válida");
                            return;
                    }
                    
                    System.out.println("Estado del inventario actualizado con éxito");
                    break;
                case 6: 
                    encontrado.cumplirAnios();
                    System.out.println("Feliz cumpleaños a: " + encontrado.getNombre() + " Ahora tiene: " + encontrado.getEdad() + " años");
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;      
            }     
        } catch (IllegalArgumentException e){
            System.out.println("No se pudo actualizar: " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("No se pudo actualizar: dato con formato inválido");
            lector.nextLine();
        }
    }
    
    public void retirarAnimal(){
        if (misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        
        try{
            System.out.println("Ingrese el código del animal a retirar: ");
            int codigo = lector.nextInt();
        
            Animal encontrado = buscarPorCodigo(codigo);
        
            if(encontrado == null){
                System.out.println("El código del animal no está registrado");
                return;
            }
        
            encontrado.retirar();
            System.out.println("Animal retirado con éxito. Su registro se conserva en el inventario");
            
        } catch (IllegalArgumentException e) {
            System.out.println("El animal no se pudo retirar: " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Debe ingresar un número válido para el código");
            lector.nextLine();
        }
    }
    
    //Filtrar inventario por categoria o estado sin alterar la colleción original
    public void filtrarInventario(){
        if (misAnimales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        }
        
        try{
            System.out.println("¿Cómo desea filtrar?");
            System.out.println("1. Por categoría");
            System.out.println("2. Por estado de inventario");
            int opcionFiltro = lector.nextInt();
            lector.nextLine();
            
            switch (opcionFiltro){
                case 1: 
                    System.out.println("Seleccione la categoría: ");
                    System.out.println("1. Mamífero");
                    System.out.println("2. Ave");
                    System.out.println("3. Reptil");
                    int categoria = lector.nextInt();
                    lector.nextLine();
                    
                    boolean encontroCategoria = false;
                    for (Animal a : misAnimales){
                        if (categoria == 1 && a instanceof Mamifero){
                            a.mostrarInfo();
                            System.out.println("=======================");
                            encontroCategoria = true;
                        }
                        else if (categoria == 2 && a instanceof Ave){
                            a.mostrarInfo();
                            System.out.println("=======================");
                            encontroCategoria = true;
                        }
                        else if (categoria == 3 && a instanceof Reptil){
                            a.mostrarInfo();
                            System.out.println("=======================");
                            encontroCategoria = true;
                        }
                    }
                    if (!encontroCategoria){
                        System.out.println("No hay animales registrados");
                    }
                    break;
                    
                case 2: 
                    System.out.println("Seleccione el estado: ");
                    System.out.println("1. ACTIVO");
                    System.out.println("2. EN_OBSERVACION");
                    System.out.println("3. RETIRADO");
                    System.out.println("4. FALLECIDO");
                    int opcionEstado = lector.nextInt();
                    lector.nextLine();
                    EstadoInventario estadoBuscado;
                    switch (opcionEstado){
                        case 1: 
                            estadoBuscado = EstadoInventario.ACTIVO;
                            break;
                        case 2:
                            estadoBuscado = EstadoInventario.EN_OBSERVACION;
                            break;
                        case 3: 
                            estadoBuscado = EstadoInventario.RETIRADO;
                            break;
                        case 4:
                            estadoBuscado = EstadoInventario.FALLECIDO;
                            break;
                        default:
                            System.out.println("Opción no válida");
                            return;
                    }
                    
                    boolean encontroEstado = false;
                    for (Animal a : misAnimales){
                        if (a.getEstadoInventario() == estadoBuscado){
                            a.mostrarInfo();
                            System.out.println("=======================");
                            encontroEstado = true;
                        }
                    }
                    if (!encontroEstado){
                        System.out.println("No hay animales registrados");
                    }
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un número válido");
            lector.nextLine();
        }
    }
}    
    
