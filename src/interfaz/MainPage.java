/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import classes.Main;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Juan
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        colaLamboUi1 = new interfaz.ColaUi();
        colaLamboUi2 = new interfaz.ColaUi();
        colaLamboUi3 = new interfaz.ColaUi();
        colaLamboUiRef = new interfaz.ColaUi();
        colaBgUi1 = new interfaz.ColaUi();
        colaBgUi2 = new interfaz.ColaUi();
        colaBgUi3 = new interfaz.ColaUi();
        colaBgUiRef = new interfaz.ColaUi();
        lights = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoLambo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lamboWinsLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logoBg = new javax.swing.JLabel();
        bgWinsLabel1 = new javax.swing.JLabel();
        racePanel = new javax.swing.JPanel();
        sliderPane = new javax.swing.JPanel();
        timeSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        winnersPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        winnersScrollPane = new javax.swing.JScrollPane();
        winnersLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(colaLamboUi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        jPanel2.add(colaLamboUi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));
        jPanel2.add(colaLamboUi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));
        jPanel2.add(colaLamboUiRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));
        jPanel2.add(colaBgUi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, -1, -1));
        jPanel2.add(colaBgUi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, -1, -1));
        jPanel2.add(colaBgUi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, -1, -1));
        jPanel2.add(colaBgUiRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, -1, -1));
        jPanel2.add(lights, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 220, 100));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(logoLambo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 180, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carreras ganadas");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        lamboWinsLabel.setBackground(new java.awt.Color(51, 51, 51));
        lamboWinsLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lamboWinsLabel.setForeground(new java.awt.Color(255, 255, 255));
        lamboWinsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lamboWinsLabel.setText("0");
        jPanel3.add(lamboWinsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 70, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 310, 110));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carreras ganadas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel1.add(logoBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -10, 140, 130));

        bgWinsLabel1.setBackground(new java.awt.Color(51, 51, 51));
        bgWinsLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        bgWinsLabel1.setForeground(new java.awt.Color(255, 255, 255));
        bgWinsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgWinsLabel1.setText("0");
        jPanel1.add(bgWinsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 70, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 310, 110));

        racePanel.setBackground(new java.awt.Color(51, 51, 51));
        racePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(racePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 420, 370));

        sliderPane.setBackground(new java.awt.Color(153, 153, 153));
        sliderPane.setForeground(new java.awt.Color(255, 255, 255));
        sliderPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeSlider.setBackground(new java.awt.Color(153, 153, 153));
        timeSlider.setForeground(new java.awt.Color(0, 0, 0));
        timeSlider.setMajorTickSpacing(10);
        timeSlider.setMaximum(60);
        timeSlider.setMinimum(1);
        timeSlider.setMinorTickSpacing(5);
        timeSlider.setPaintLabels(true);
        timeSlider.setPaintTicks(true);
        timeSlider.setToolTipText("");
        timeSlider.setValue(10);
        timeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSliderStateChanged(evt);
            }
        });
        sliderPane.add(timeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccionar tiempo de simulacion");
        sliderPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));

        jPanel2.add(sliderPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, 300, 90));

        winnersPane.setBackground(new java.awt.Color(51, 51, 51));
        winnersPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ganadores");
        winnersPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        winnersScrollPane.setViewportView(winnersLabel);

        winnersPane.add(winnersScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, 50));

        jPanel2.add(winnersPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 420, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fondo2.jpg"))); // NOI18N
        jPanel2.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 750));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_timeSliderStateChanged
        // TODO add your handling code here:
        Main.ia.setSimulationTime(this.timeSlider.getValue());
    }//GEN-LAST:event_timeSliderStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bgWinsLabel1;
    private interfaz.ColaUi colaBgUi1;
    private interfaz.ColaUi colaBgUi2;
    private interfaz.ColaUi colaBgUi3;
    private interfaz.ColaUi colaBgUiRef;
    private interfaz.ColaUi colaLamboUi1;
    private interfaz.ColaUi colaLamboUi2;
    private interfaz.ColaUi colaLamboUi3;
    private interfaz.ColaUi colaLamboUiRef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lamboWinsLabel;
    private javax.swing.JLabel lights;
    private javax.swing.JLabel logoBg;
    private javax.swing.JLabel logoLambo;
    private javax.swing.JPanel racePanel;
    private javax.swing.JPanel sliderPane;
    private javax.swing.JSlider timeSlider;
    private javax.swing.JLabel winnersLabel;
    private javax.swing.JPanel winnersPane;
    private javax.swing.JScrollPane winnersScrollPane;
    // End of variables declaration//GEN-END:variables

    private void init(){
        setTitulosColas();
        setImageLabel(logoLambo, "src/imgs/logoLambo.png");
        setImageLabel(logoBg, "src/imgs/logoBg.png");
        setImageLabel(lights, "src/imgs/lights.jpg");
    }
    
    private void setTitulosColas(){
        this.colaLamboUi1.setTitulo("Cola de prioridad 1");
        this.colaLamboUi2.setTitulo("Cola de prioridad 2");
        this.colaLamboUi3.setTitulo("Cola de prioridad 3");
        this.colaLamboUiRef.setTitulo("Cola de refuerzo");
        
        this.colaBgUi1.setTitulo("Cola de prioridad 1");
        this.colaBgUi2.setTitulo("Cola de prioridad 2");
        this.colaBgUi3.setTitulo("Cola de prioridad 3");
        this.colaBgUiRef.setTitulo("Cola de refuerzo");
    }
    
    private void setImageLabel(JLabel labelName, String root){
        ImageIcon img = new ImageIcon(root);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    public ColaUi getColaLamboUi1(){
        return this.colaLamboUi1;
    }
    public ColaUi getColaLamboUi2(){
        return this.colaLamboUi2;
    }
    public ColaUi getColaLamboUi3(){
        return this.colaLamboUi3;
    }
    public ColaUi getColaLamboUiRef(){
        return this.colaLamboUiRef;
    }
    
    public ColaUi getColaBgUi1(){
        return this.colaBgUi1;
    }
    public ColaUi getColaBgUi2(){
        return this.colaBgUi2;
    }
    public ColaUi getColaBgUi3(){
        return this.colaBgUi3;
    }
    public ColaUi getColaBgUiRef(){
        return this.colaBgUiRef;
    }
    
    public JLabel getWinnersLabel(){
        return this.winnersLabel;
    }
    
    public JLabel getLamboWinsLabel(){
        return this.lamboWinsLabel;
    }
    
    public JLabel getBugattiWinsLabel(){
        return this.bgWinsLabel1;
    }
    
}
