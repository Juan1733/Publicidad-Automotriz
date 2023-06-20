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
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InteligenciaArtificial extends Thread {

    private Administrador administrador;
    Vehiculo carroLambo;
    Vehiculo carroBg;
    
    int simulationTime;
    Random random = new Random();
    public Semaphore mutex;
    
    public String[] ganadores = new String[100];
    public int lamboWins = 0;
    public int bgWins = 0;
    

    public InteligenciaArtificial(Cola colaBugatti, Cola colaLamborghini) {
        this.administrador = Main.sistemaOperativo;
        this.mutex = Main.mutex;
        // 10 segundos por defecto
        this.simulationTime = 10 * 1000;
    }

    @Override
    public void run() {
        try {
            while (true) {   
                int auxTime = simulationTime;
                this.mutex.acquire();
                
                if (this.carroLambo != null && this.carroBg != null){
                    // Decidiendo
                    //tomar un numero random para determinar ganador. 0=lambo, 1=bugatti
                    int num = random.nextInt(2);
                    
                    Vehiculo winner; 
                    if(num == 0){
                        winner = this.carroLambo;
                    }else if(num == 1){
                        winner = this.carroBg;
                    }
                    
                }                                                
            }                                   
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

}   

