/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author mannith
 */
public class Vehiculo {
    private int id;
    private String marca;
    private int prioridad;
    private double calidadCarroceria;
    private double calidadChasis;
    private double calidadMotor;
    private double calidadRueda;
    private int contadorRondas;

    public Vehiculo(int id, String marca, int prioridad, double calidadCarroceria, double calidadChasis, double calidadMotor, double calidadRueda) {
        this.id = id;
        this.marca = marca;
        this.prioridad = prioridad;
        this.calidadCarroceria = calidadCarroceria;
        this.calidadChasis = calidadChasis;
        this.calidadMotor = calidadMotor;
        this.calidadRueda = calidadRueda;
        this.contadorRondas = 0;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public double getCalidadCarroceria() {
        return calidadCarroceria;
    }

    public void setCalidadCarroceria(double calidadCarroceria) {
        this.calidadCarroceria = calidadCarroceria;
    }

    public double getCalidadChasis() {
        return calidadChasis;
    }

    public void setCalidadChasis(double calidadChasis) {
        this.calidadChasis = calidadChasis;
    }

    public double getCalidadMotor() {
        return calidadMotor;
    }

    public void setCalidadMotor(double calidadMotor) {
        this.calidadMotor = calidadMotor;
    }

    public double getCalidadRueda() {
        return calidadRueda;
    }

    public void setCalidadRueda(double calidadRueda) {
        this.calidadRueda = calidadRueda;
    }

    public int getContadorRondas() {
        return contadorRondas;
    }

    public void setContadorRondas(int contadorRondas) {
        this.contadorRondas = contadorRondas;
    }
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", prioridad=" + prioridad +
                ", calidadCarroceria=" + calidadCarroceria +
                ", calidadChasis=" + calidadChasis +
                ", calidadMotor=" + calidadMotor +
                ", calidadRueda=" + calidadRueda +
                ", contadorRondas=" + contadorRondas +
                '}';
    }
}
