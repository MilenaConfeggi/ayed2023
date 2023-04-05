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
public class RecursionInversa {
    
    public static void imprimirInversa (ListaDeEnteros args){
        
        int pos = args.tamanio();
        impresionrec (args, pos);
    }
    
    private static void impresionrec (ListaDeEnteros args, int pos){
        
        if (pos>=1){
            System.out.print(args.elemento(pos) + " ");
            impresionrec (args, pos - 1);
        }
    }
}
