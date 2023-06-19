/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author mannith
 */
import java.util.Random;

public class InteligenciaArtificial extends Thread {
    private Cola colaBugatti;
    private Cola colaLamborghini;
    private Cola ganadores;
    private boolean running;

    public InteligenciaArtificial(Cola colaBugatti, Cola colaLamborghini) {
        this.colaBugatti = colaBugatti;
        this.colaLamborghini = colaLamborghini;
        this.ganadores = new Cola();
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            // Seleccionar vehículos para la carrera
            Vehiculo vehiculo1 = seleccionarVehiculo(colaBugatti);
            Vehiculo vehiculo2 = seleccionarVehiculo(colaLamborghini);

            // Procesar características de los vehículos y determinar el resultado de la carrera
            double resultado = determinarResultado(vehiculo1, vehiculo2);

            if (resultado > 0) {
                // Hay un ganador
                int ganadorId = (resultado == 1) ? vehiculo1.getId() : vehiculo2.getId();
                ganadores.encolar(new Nodo(ganadorId));
                eliminarPerdedor(vehiculo1, vehiculo2);
                System.out.println("El vehículo ganador es: " + ganadorId);
            } else if (resultado < 0) {
                // Empate
                volverAEncolar(vehiculo1, colaBugatti);
                volverAEncolar(vehiculo2, colaLamborghini);
                System.out.println("Empate. Ambos vehículos vuelven a la cola.");
            } else {
                // Suspensión de la carrera
                enviarARefuerzo(vehiculo1);
                enviarARefuerzo(vehiculo2);
                System.out.println("Carrera suspendida. Ambos vehículos enviados a refuerzo.");
            }

            try {
                Thread.sleep(10000); // Esperar 10 segundos antes de la próxima carrera
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSimulation() {
        running = false;
    }

    public Cola getGanadores() {
        return ganadores;
    }

    private Vehiculo seleccionarVehiculo(Cola cola) {
        int prioridad = 1;
        Vehiculo vehiculo = null;

        while (vehiculo == null && prioridad <= 3) {
            if (!cola.isEmpty()) {
                Nodo nodo = (Nodo) cola.getHead().getElement();
                if (nodo != null && nodo.getElement() instanceof Vehiculo) {
                    Vehiculo v = (Vehiculo) nodo.getElement();
                    if (v.getPrioridad() == prioridad) {
                        vehiculo = v;
                        cola.desencolar();
                    }
                }
            }
            prioridad++;
        }

        return vehiculo;
    }


    private double determinarResultado(Vehiculo vehiculo1, Vehiculo vehiculo2) {
        // Lógica para determinar el resultado de la carrera (puedes adaptarla según tus criterios)
        double calidad1 = calcularCalidadTotal(vehiculo1);
        double calidad2 = calcularCalidadTotal(vehiculo2);

        if (calidad1 > calidad2) {
            return 1; // vehiculo1 gana
        } else if (calidad1 < calidad2) {
            return -1; // vehiculo2 gana
        } else {
            // Empate
            return 0;
        }
    }

    private double calcularCalidadTotal(Vehiculo vehiculo) {
        // Lógica para calcular la calidad total del vehículo (puedes adaptarla según tus criterios)
        double calidadCarroceria = vehiculo.getCalidadCarroceria();
        double calidadChasis = vehiculo.getCalidadChasis();
        double calidadMotor = vehiculo.getCalidadMotor();
        double calidadRueda = vehiculo.getCalidadRueda();

        return (calidadCarroceria + calidadChasis + calidadMotor + calidadRueda) / 4;
    }

    private void eliminarPerdedor(Vehiculo vehiculo1, Vehiculo vehiculo2) {
        // Eliminar el vehículo perdedor de la simulación
        if (vehiculo1.getMarca().equals("Bugatti")) {
            colaBugatti.desencolar();
        } else if (vehiculo1.getMarca().equals("Lamborghini")) {
            colaLamborghini.desencolar();
        }
    }

    private void volverAEncolar(Vehiculo vehiculo, Cola cola) {
        // Volver a encolar el vehículo en su respectiva cola
        cola.encolar(new Nodo(vehiculo));
        System.out.println("Vehículo " + vehiculo.getId() + " volvió a la cola.");
    }

    private void enviarARefuerzo(Vehiculo vehiculo) {
        // Enviar el vehículo a la cola de refuerzo
        // Aquí deberías tener una cola de refuerzo específica para cada marca de vehículo (Bugatti y Lamborghini)
        // Puedes adaptar el código para incluir esa funcionalidad.
        System.out.println("Vehículo " + vehiculo.getId() + " enviado a refuerzo.");
    }
}
