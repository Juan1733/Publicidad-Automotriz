/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Random;

/**
 *
 * @author mannith
 */
public class Administrador extends Thread {
//    private InteligenciaArtificial inteligenciaArtificial;
//    private Cola colaBugattiNivel1;
//    private Cola colaBugattiNivel2;
//    private Cola colaBugattiNivel3;
//    private Cola colaLamborghiniNivel1;
//    private Cola colaLamborghiniNivel2;
//    private Cola colaLamborghiniNivel3;
//    private Random random;
//
//    public Administrador(InteligenciaArtificial inteligenciaArtificial,
//                         Cola colaBugattiNivel1, Cola colaBugattiNivel2, Cola colaBugattiNivel3,
//                         Cola colaLamborghiniNivel1, Cola colaLamborghiniNivel2, Cola colaLamborghiniNivel3) {
//        this.inteligenciaArtificial = inteligenciaArtificial;
//        this.colaBugattiNivel1 = colaBugattiNivel1;
//        this.colaBugattiNivel2 = colaBugattiNivel2;
//        this.colaBugattiNivel3 = colaBugattiNivel3;
//        this.colaLamborghiniNivel1 = colaLamborghiniNivel1;
//        this.colaLamborghiniNivel2 = colaLamborghiniNivel2;
//        this.colaLamborghiniNivel3 = colaLamborghiniNivel3;
//        this.random = new Random();
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            // Esperar a que la inteligencia artificial termine de revisar un vehículo
//            inteligenciaArtificial.esperar();
//
//            // Actualizar las colas y agregar un nuevo vehículo con una probabilidad del 80%
//            actualizarColas();
//
//            // Indicar a la inteligencia artificial que puede comenzar a trabajar con los vehículos seleccionados
//            inteligenciaArtificial.empezar();
//        }
//    }
//
//    private void actualizarColas() {
//        if (debeAgregarVehiculo()) {
//            agregarNuevoVehiculo(colaBugattiNivel1, colaBugattiNivel2, colaBugattiNivel3);
//            agregarNuevoVehiculo(colaLamborghiniNivel1, colaLamborghiniNivel2, colaLamborghiniNivel3);
//        }
//    }
//
//    private boolean debeAgregarVehiculo() {
//        return random.nextDouble() < 0.8;
//    }
//
//    private void agregarNuevoVehiculo(Cola colaNivel1, Cola colaNivel2, Cola colaNivel3) {
//        int prioridad = seleccionarPrioridad();
//        Vehiculo vehiculo = crearNuevoVehiculo(prioridad);
//        encolarVehiculo(vehiculo, colaNivel1, colaNivel2, colaNivel3);
//        System.out.println("Nuevo vehículo agregado a la cola: " + vehiculo);
//    }
//
//    private int seleccionarPrioridad() {
//        int prioridad = random.nextInt(3) + 1;
//        return prioridad;
//    }
//
//    private Vehiculo crearNuevoVehiculo(int prioridad) {
//        int id = generarIdUnico();
//        String marca = seleccionarMarcaAleatoria();
//        // Resto de la lógica para crear un nuevo vehículo
//        return new Vehiculo(id, marca, prioridad, 0, 0, 0, 0);
//    }
//
//    private void encolarVehiculo(Vehiculo vehiculo, Cola colaNivel1, Cola colaNivel2, Cola colaNivel3) {
//        switch (vehiculo.getPrioridad()) {
//            case 1:
//                colaNivel1.encolar(new Nodo(vehiculo));
//                break;
//            case 2:
//                colaNivel2.encolar(new Nodo(vehiculo));
//                break;
//            case 3:
//                colaNivel3.encolar(new Nodo(vehiculo));
//                break;
//            default:
//                break;
//        }
//    }
//
//    private int generarIdUnico() {
//        // Lógica para generar un ID único para cada vehículo
//        // Puedes implementar tu propia lógica aquí, por ejemplo, utilizando un contador incremental o un UUID
//        return UUID.randomUUID().hashCode();
//    }
//
//    private String seleccionarMarcaAleatoria() {
//        // Lógica para seleccionar una marca aleatoria (Bugatti o Lamborghini)
//        String[] marcas = {"Bugatti", "Lamborghini"};
//        int indiceAleatorio = random.nextInt(marcas.length);
//        return marcas[indiceAleatorio];
//    }
}
