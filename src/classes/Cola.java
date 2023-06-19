/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Cola {

    private Nodo head;
    private Nodo tail;
    private int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void empty() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void encolar(Nodo nuevo) { //queue
        if (this.isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.setNext(nuevo);
            tail = nuevo;
        }
        size++;
    }

    public void desencolar() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else if (size == 1) {
            this.empty();
        } else {
            head = head.getNext();
            size--;
        }
    }

    public String print() {
        if (!this.isEmpty()) {
            String printCola = "";
            for (int i = 0; i < size; i++) {
                Nodo actual = head;
                this.desencolar();
                printCola += actual.getElement() + ",";
                this.encolar(actual);
            }
            return printCola;
        }
        return null;
    }
    
    public void reverse(){
        if (!this.isEmpty()) {
            Nodo nodo = this.head;
            this.desencolar();
            this.reverse();
            this.encolar(nodo);
        }
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
