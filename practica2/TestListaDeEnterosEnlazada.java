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
public class TestListaDeEnterosEnlazada {
    private static ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    
    public static void main(String[] args) {
		for (String arg : args) {
			lista.agregarFinal(Integer.parseInt(arg));
		}

		lista.comenzar();
		
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
