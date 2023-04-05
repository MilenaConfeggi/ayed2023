/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Milena
 */
public class TestListaEnlazadaGenerica {
    
    
    public static void main (String[] args){
        
        ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
        
        Estudiante est1 = new Estudiante("pepe", "pupu", 2, "aa", "12");
        lista.agregarFinal(est1);
        Estudiante est2 = new Estudiante("lula", "sanchez", 1, "ab", "4");
        lista.agregarFinal(est2);
        Estudiante est3 = new Estudiante("martina", "gonzales", 2, "ac", "7");
        lista.agregarFinal(est3);
        Estudiante est4 = new Estudiante("sol", "perez", 7, "ad", "4");
        lista.agregarFinal(est4);
    
       lista.comenzar();
		
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
                }
    }
}
