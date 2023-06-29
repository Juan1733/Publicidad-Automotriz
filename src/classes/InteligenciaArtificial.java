/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author mannith
 */
import interfaz.GlobalUi;
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
    
    public String[] winners = new String[500];
    private int winnersPointer = 0;
    public int lamboWins = 0;
    public int bgWins = 0;
    

    public InteligenciaArtificial() {
//        this.administrador = Main.sistemaOperativo;
        this.mutex = Main.mutex;
        // 10 segundos por defecto
        this.simulationTime = 10 * 1000;
    }

    @Override
    public void run() {
        try {
            while (true) {   
                
                long auxTime = simulationTime;
                this.mutex.acquire();
                
                if(this.carroLambo == null || this.carroBg == null){
                    this.administrador.regresarCarrosAColas(carroLambo, carroBg);
                    Thread.sleep(auxTime);
                    
                } else{
                    // Decidiendo
                    System.out.println("estoy decidiendo");
                    GlobalUi.getMainPage().getStatusLabel().setText("Decidiendo");
                    //tomar un numero random para determinar ganador. 0=lambo, 1=bugatti
                    int num = random.nextInt(2);
                    
                    Vehiculo winner = (num == 0) ? this.carroLambo : this.carroBg; 
//                    if(num == 0){ // gano lambo
//                        winner = this.carroLambo;
//                    }else if(num == 1){ //gano bugatti
//                        winner = this.carroBg;
//                    }
                    Thread.sleep((long) (auxTime * 0.3));
                    
                    // entero para determinar resultado de la simulacion
                    int decision = random.nextInt(100);
                    
                    if(decision <= 40){ //hay ganador
                        System.out.println("Gano alguien");
                        GlobalUi.getMainPage().getStatusLabel().setText("Hay un ganador");
                        String car = num == 0 ? "lambo" : "bugatti";
                        winners[winnersPointer] = car + "-" + Integer.toString(winner.getId());
                        if(winnersPointer < winners.length){
                            winnersPointer++;
                        }           
                        
                        GlobalUi.getMainPage().getWinnersLabel().setText(printWinners());
                        if(num == 0){ // es lambo
                            this.lamboWins++;
                            //sumar contador de carreras ganadas
                            GlobalUi.getMainPage().getLamboWinsLabel().setText(Integer.toString(lamboWins));
                            //decir que gano
                            GlobalUi.getMainPage().getLamboWinnerLabel().setText("Ganador!");
                            
                        }else if(num == 1){ //es bugatti                            
                            this.bgWins++;
                            GlobalUi.getMainPage().getBugattiWinsLabel().setText(Integer.toString(bgWins));
                            GlobalUi.getMainPage().getBugattiWinnerLabel().setText("Ganador!");
                        }
                        
                        System.out.println("Lambo ganadas: " + lamboWins);
                        System.out.println("Bugatti ganadas: " + bgWins);
                        Thread.sleep((long) (auxTime * 0.5));
                        
                    }else if(decision <= 67){ //hay empate
                        System.out.println("hubo empate");
                        GlobalUi.getMainPage().getStatusLabel().setText("Hubo Empate");
                        Thread.sleep((long) (auxTime * 0.5));
                        this.administrador.regresarVehiculoCola1(carroLambo);
                        this.administrador.regresarVehiculoCola1(carroBg);                        
                    }else{ //van a refuerzo
                        System.out.println("nos vamos a refuerzo");
                        GlobalUi.getMainPage().getStatusLabel().setText("Vamos a refuerzo");
                        Thread.sleep((long) (auxTime * 0.5));
                        //enviar a la cola de refuerzo
                        this.administrador.enviarCarrosColaRefuerzo(this.carroLambo, this.carroBg);
                    }                    
                    System.out.println("Esperando");
                    GlobalUi.getMainPage().getStatusLabel().setText("Esperando");
                }
                this.administrador.updateColasUi();
                System.out.println(this.administrador.bugattiColaNivel1.print());
                Thread.sleep((long) (auxTime * 0.2));
                
                GlobalUi.getMainPage().getLamboWinnerLabel().setText("");
                GlobalUi.getMainPage().getBugattiWinnerLabel().setText("");
                
                this.mutex.release();
                Thread.sleep(500);                
            }                                   
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    private String printWinners(){
        String text = "";
        for(int i = 0; i < winnersPointer; i++){
            String value = winners[i];
            text += value + ", ";
        }
        return text;
    }
    
    public void setCarroLambo(Vehiculo nuevoLambo){
        this.carroLambo = nuevoLambo;
    }
    
    public void setCarroBugatti(Vehiculo nuevoBg){
        this.carroBg = nuevoBg;
    }
    
    public void setSimulationTime(int timeSec){
        this.simulationTime = timeSec * 1000;
    }
    
    public void setAdministrador(){
        this.administrador = Main.sistemaOperativo;
    }
}   

