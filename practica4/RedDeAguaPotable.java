/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import practica2.ColaGenerica;
import practica2.ListaGenerica;

/**
 *
 * @author Milena
 */
public class RedDeAguaPotable {
    private ArbolGeneral<Integer> a;
    
    public double minimoCaudal(double caudal){
        double min = 9999;
        return minimoC(caudal, min, this.getA());
        }
    
    private double minimoC (double caudal, double min, ArbolGeneral<Integer> a){
        if (!a.esVacio()){
            if (a.esHoja())
                min = Math.min(caudal, min);
            else{
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                while (!hijos.fin())
                    min = minimoC(caudal/hijos.tamanio(), min, hijos.proximo());
            }
        }
        return min;
    }

    public RedDeAguaPotable(ArbolGeneral<Integer> a) {
        this.a = a;
    }

    public ArbolGeneral<Integer> getA() {
        return a;
    }

    public void setA(ArbolGeneral<Integer> a) {
        this.a = a;
    }
    
}
