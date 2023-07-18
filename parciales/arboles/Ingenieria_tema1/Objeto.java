/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;
import practica2.ListaEnlazadaGenerica;
import practica2.ListaGenerica;
/**
 *
 * @author Milena
 */
public class Objeto {
    private ListaGenerica<Integer> LI;
    private int impares;

    public Objeto(ListaGenerica<Integer> LI, int impares) {
        this.LI = LI;
        this.impares = impares;
    }

    public ListaGenerica<Integer> getLI() {
        return LI;
    }

    public void setLI(ListaGenerica<Integer> LI) {
        this.LI = LI;
    }

    public int getImpares() {
        return impares;
    }

    public void setImpares(int impares) {
        this.impares = impares;
    }
    
}
