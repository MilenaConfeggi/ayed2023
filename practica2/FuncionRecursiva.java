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
public class FuncionRecursiva {
    ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    
    public ListaDeEnterosEnlazada recursion (int n){
        lista.agregarFinal (n);
        if (n==1){
            return lista;
        }
        else
            if(n%2 != 0){
               return recursion(n/2);
            }
            else{
               return recursion(3*n + 1);         
            }
     }
}
