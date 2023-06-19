/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan
 */
public class Main {
    public static Semaphore mutex = new Semaphore(1);
    public static Administrador sistemaOperativo = new Administrador();
//    public static InteligenciaArtificial iA = new InteligenciaArtificial();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sistemaOperativo.start();
    }
    
}
