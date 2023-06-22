/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaz.ColaUi;
import interfaz.GlobalUi;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mannith
 */
public class Administrador extends Thread {
    int counter = 0;
    boolean running = true;
    
    public InteligenciaArtificial ia;
    public Semaphore mutex;
    
    public Cola lamboColaNivel1;
    public Cola lamboColaNivel2;
    public Cola lamboColaNivel3;
    public Cola bugattiColaNivel1;
    public Cola bugattiColaNivel2;
    public Cola bugattiColaNivel3;
    public Cola lamboRefuerzo;
    public Cola bugattiRefuerzo;
    
    // colas de la interfaz
    public ColaUi colaLamboUi1;
    public ColaUi colaLamboUi2;
    public ColaUi colaLamboUi3;
    public ColaUi colaLamboUiRef;
    
    public ColaUi colaBgUi1;
    public ColaUi colaBgUi2;
    public ColaUi colaBgUi3;
    public ColaUi colaBgUiRef;
    
    final Random porcentaje = new Random();
    
    public Administrador(){
        creacionColas();
        this.mutex = Main.mutex;
        for (int i = 0; i < 10; i++) {
            this.createVehiculosIniciales("lambo");
//            System.out.println("cola numero 1 de lambo:" + this.lamboColaNivel1.print());
            this.createVehiculosIniciales("bugatti");
//            System.out.println("cola numero 1 de bugatti: " + this.bugattiColaNivel1.print());
        }
        updateColasUi();
        System.out.println("cola numero 1 de bugatti: " + this.bugattiColaNivel1.print());
        System.out.println("cola numero 2 de bugatti: " + this.bugattiColaNivel2.print());
        System.out.println("cola numero 3 de bugatti: " + this.bugattiColaNivel3.print());
        System.out.println("cola numero 1 de Lambo: " + this.lamboColaNivel1.print());
        System.out.println("cola numero 2 de Lambo: " + this.lamboColaNivel2.print());
        System.out.println("cola numero 3 de Lambo: " + this.lamboColaNivel3.print());
        this.ia = Main.ia;
//        try {
////            this.mutex.acquire();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.start();
//        iA.start();
    }

    private void creacionColas() {
        this.bugattiColaNivel1 = new Cola(); 
        this.bugattiColaNivel2 = new Cola(); 
        this.bugattiColaNivel3 = new Cola(); 
        this.lamboColaNivel1 = new Cola();
        this.lamboColaNivel2 = new Cola();
        this.lamboColaNivel3 = new Cola();
        this.lamboRefuerzo = new Cola();
        this.bugattiRefuerzo = new Cola();
        
        this.colaLamboUi1 = GlobalUi.getMainPage().getColaLamboUi1();
        this.colaLamboUi2 = GlobalUi.getMainPage().getColaLamboUi2();
        this.colaLamboUi3 = GlobalUi.getMainPage().getColaLamboUi3();
        this.colaLamboUiRef = GlobalUi.getMainPage().getColaLamboUiRef();
        
        this.colaBgUi1 = GlobalUi.getMainPage().getColaBgUi1();
        this.colaBgUi2 = GlobalUi.getMainPage().getColaBgUi2();
        this.colaBgUi3 = GlobalUi.getMainPage().getColaBgUi3();
        this.colaBgUiRef = GlobalUi.getMainPage().getColaBgUiRef();
    }
    
    @Override
    public void run(){
        try {
            while(this.running){
                this.mutex.acquire();
                this.setCounter(this.counter + 1);
                
                this.desencolarRefuerzoVehiculo(lamboRefuerzo);
                this.desencolarRefuerzoVehiculo(bugattiRefuerzo);
                
                int result = porcentaje.nextInt(100);

                this.addVehiculo("lambo", result);
//                System.out.println("cola numero 1 de lambo: " + this.lamboColaNivel1.print());
                this.addVehiculo("bugatti", result);
//                System.out.println("cola numero 1 de bugatti: " + this.bugattiColaNivel1.print());   
           

                this.sumarContadorCambiarPrioridad(lamboColaNivel2);
                this.sumarContadorCambiarPrioridad(lamboColaNivel3);
                this.sumarContadorCambiarPrioridad(bugattiColaNivel2);
                this.sumarContadorCambiarPrioridad(bugattiColaNivel3);
                
                updateColasUi();

                // obtener los carros
                Vehiculo lambo = this.getVehiculoColas(lamboColaNivel1, lamboColaNivel2, lamboColaNivel3);
                Vehiculo bugatti = this.getVehiculoColas(bugattiColaNivel1, bugattiColaNivel2, bugattiColaNivel3);
                
                // pasarle a la ia los carros
                ia.setCarroLambo(lambo);
                ia.setCarroBugatti(bugatti);
                
                // setear en 0 el contador de inanicion de cada carro
                if(lambo != null){
                    lambo.setContadorRondas(0);
                }
                if(bugatti != null){
                    bugatti.setContadorRondas(0);
                }
                
                updateColasUi();
                this.mutex.release();
                Thread.sleep(500);
//                this.mutex.acquire();
            }
            
        } catch (InterruptedException e){
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void addVehiculo(String marca, int result) { // todo agregar vehiculo a su cola de prioridad
//        int result = porcentaje.nextInt(100);
//        System.out.println("porcentaje para add vehiculo: "+ result +"%");
        if (result <= 80) {
            if(this.counter >= 2){
                if(marca.equals("lambo")){
//                    System.out.println("es lambo y entro en el 80% por lo que se anade un carro a la cola 1");
                    Vehiculo lambo = this.crearVehiculo(result, marca, 1, MIN_PRIORITY, MIN_PRIORITY, counter, counter);
//                    System.out.println(lambo);
                    this.regresarVehiculoCola1(lambo);
                    
                }else if(marca.equals("bugatti")){
//                    System.out.println("es bugatti y se anade un carro a la cola 1");
                    Vehiculo bugatti = this.crearVehiculo(result, marca, 1, MIN_PRIORITY, MIN_PRIORITY, counter, counter);
//                    System.out.println(bugatti);
                    this.regresarVehiculoCola1(bugatti);
                }
                this.setCounter(0);
            }
        }
    }
    
    private void createVehiculosIniciales(String marca){
        int prioridadRandom = porcentaje.nextInt(3);
        int result = porcentaje.nextInt(100);
        if(marca.equals("lambo")){
            Vehiculo lambo = this.crearVehiculo(result, marca, prioridadRandom, MIN_PRIORITY, MIN_PRIORITY, counter, counter);
            if(lambo.getPrioridad() == 0){
                this.lamboColaNivel1.encolar(lambo);
            }else if(lambo.getPrioridad() == 1){
                this.lamboColaNivel2.encolar(lambo);
            }else if(lambo.getPrioridad() == 2){
                this.lamboColaNivel3.encolar(lambo);
            }                
        }else if(marca.equals("bugatti")){ 
            Vehiculo bugatti = this.crearVehiculo(result, marca, prioridadRandom, MIN_PRIORITY, MIN_PRIORITY, counter, counter);
            if(bugatti.getPrioridad() == 0){
                this.bugattiColaNivel1.encolar(bugatti);
//                System.out.println(this.bugattiColaNivel1.print());
            }else if(bugatti.getPrioridad() == 1){
                this.bugattiColaNivel2.encolar(bugatti);
//                System.out.println(this.bugattiColaNivel2.print());
            }else if(bugatti.getPrioridad() == 2){
                this.bugattiColaNivel3.encolar(bugatti);
//                System.out.println(this.bugattiColaNivel3.print());
            }                
        }
    }
    
    private void desencolarRefuerzoVehiculo(Cola refuerzo) {
        if (refuerzo.isEmpty()) {
            return;
        }else {
            int result = porcentaje.nextInt(100);
            if (result <= 40) {
                Vehiculo vehiculo = refuerzo.dispatch();
                vehiculo.setPrioridad(1);
                this.regresarVehiculoCola1(vehiculo);
            } else {
                Vehiculo vehiculo = refuerzo.dispatch();
                refuerzo.encolar(vehiculo);
            }
        }       
    }
    
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public Vehiculo crearVehiculo(int id, String marca, int prioridad, double calidadCarroceria, double calidadChasis, double calidadMotor, double calidadRueda){
        return new Vehiculo(id, marca, prioridad, calidadCarroceria, calidadChasis, calidadMotor, calidadRueda);
        
    }
    public void regresarVehiculoCola1(Vehiculo marca){
//        System.out.println("holaaaaa");
        if(marca.getMarca().equals("lambo")){
            this.lamboColaNivel1.encolar(marca);
        }else if(marca.getMarca().equals("bugatti")){
//            System.out.println(marca + "entro a regresarvehiculo");
            this.bugattiColaNivel1.encolar(marca);
        }
    }
    
    private void sumarContadorCambiarPrioridad(Cola cola){
        int longitud = cola.getSize();
        int i = 0;
        
        while(i<longitud){
            Vehiculo vehiculo = cola.dispatch();
            vehiculo.setContadorRondas(vehiculo.getContadorRondas() + 1);         
            
            if(vehiculo.getContadorRondas()>=8){
                if (vehiculo.getPrioridad()>1){
                    vehiculo.setPrioridad(vehiculo.getPrioridad() - 1);
                    if(vehiculo.getMarca().equals("lambo")){
                        if(vehiculo.getPrioridad() == 1){
                            this.lamboColaNivel1.encolar(vehiculo);
                        }else if(vehiculo.getPrioridad() == 2){
                            this.lamboColaNivel2.encolar(vehiculo);
                        }else if(vehiculo.getPrioridad() == 3){
                            this.lamboColaNivel3.encolar(vehiculo);
                        }
                    }else if(vehiculo.getMarca().equals("bugatti")){
                        if(vehiculo.getPrioridad() == 1){
                            this.bugattiColaNivel1.encolar(vehiculo);
                        }else if(vehiculo.getPrioridad() == 2){
                            this.bugattiColaNivel2.encolar(vehiculo);
                        }else if(vehiculo.getPrioridad() == 3){
                            this.bugattiColaNivel3.encolar(vehiculo);
                        }
                    }
                }else{
                    cola.encolar(vehiculo);
                }
                vehiculo.setContadorRondas(1);
            }else{
                cola.encolar(vehiculo);
            }
            i++;
        }
    }
    
    public void enviarCarrosColaRefuerzo(Vehiculo lambito, Vehiculo bugga){
        if(lambito != null ){
            this.lamboRefuerzo.encolar(lambito);
        }
        if(bugga != null){
            this.bugattiRefuerzo.encolar(bugga);
        }
    }
    
    private Vehiculo getVehiculoColas(Cola cola1, Cola cola2, Cola cola3) {
        
        if (!cola1.isEmpty()) {
            return cola1.dispatch();
        } else if (!cola2.isEmpty()) {
            return cola2.dispatch();
        } else if (!cola3.isEmpty()) {
            return cola3.dispatch();
        }
        return null;
    }
    
    public void updateColasUi(){
        this.colaLamboUi1.updateUiQueue(lamboColaNivel1);
        this.colaLamboUi2.updateUiQueue(lamboColaNivel2);
        this.colaLamboUi3.updateUiQueue(lamboColaNivel3);
        this.colaLamboUiRef.updateUiQueue(lamboRefuerzo);
        
        this.colaBgUi1.updateUiQueue(bugattiColaNivel1);
        this.colaBgUi2.updateUiQueue(bugattiColaNivel2);
        this.colaBgUi3.updateUiQueue(bugattiColaNivel3);
        this.colaBgUiRef.updateUiQueue(bugattiRefuerzo);
    }
    
    public void regresarCarrosAColas(Vehiculo lambo, Vehiculo bugatti) {
        if (lambo != null) {
            if(lambo.getPrioridad() == 1){
                this.lamboColaNivel1.encolar(lambo);
            }else if(lambo.getPrioridad() == 2){
                this.lamboColaNivel2.encolar(lambo);
            }else if(lambo.getPrioridad() == 3){
                this.lamboColaNivel3.encolar(lambo);
            }
        }
        if (bugatti != null) {
            if(bugatti.getPrioridad() == 1){
                this.bugattiColaNivel1.encolar(bugatti);
            }else if(bugatti.getPrioridad() == 2){
                this.bugattiColaNivel2.encolar(bugatti);
            }else if(bugatti.getPrioridad() == 3){
                this.bugattiColaNivel3.encolar(bugatti);
            }
        }
    }
    
}
