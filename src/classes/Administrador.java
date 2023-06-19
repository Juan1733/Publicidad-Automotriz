/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

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
    
    public InteligenciaArtificial iA;
    public Semaphore mutex;
    
    public Cola lamboColaNivel1;
    public Cola lamboColaNivel2;
    public Cola lamboColaNivel3;
    public Cola bugattiColaNivel1;
    public Cola bugattiColaNivel2;
    public Cola bugattiColaNivel3;
    public Cola lamboRefuerzo;
    public Cola bugattiRefuerzo;
    
    final Random porcentaje = new Random();
    
    public Administrador(){
        creacionColas();
        this.mutex = Main.mutex;
//        for (int i = 0; i < 20; i++) {
//            this.addVehiculo("lambo");
//            this.addVehiculo("bugatti");
//        }
//        this.iA = Main.iA;
        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.start();
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
    }
    
    @Override
    public void run(){
        try {
            while(this.running){
                this.mutex.acquire();
                this.addVehiculo("lambo");
                this.mutex.release();
                Thread.sleep(500);
                this.mutex.acquire();
            }
            
        } catch (InterruptedException e){
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void addVehiculo(String marca) {
        int result = porcentaje.nextInt(100);
        if (result <= 80) {
            if(this.counter >= 2){
                if(marca.equals("lambo")){
                    System.out.println("es lambo y entro en el 80% por lo que se anade un carro a alguna cola");
                }else{
                    System.out.println("es bugatti y se anade un carro a alguna cola");
                }
                this.setCounter(0);
            }
            
            this.setCounter(this.counter + 1);
        }
    }
    
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
