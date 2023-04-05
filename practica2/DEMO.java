
package practica2;

import java.util.Scanner;

public class DEMO {

    public static void main(String[] args) {

       Scanner s = new Scanner(System.in);
		
		FuncionRecursiva sc = new FuncionRecursiva();
		ListaDeEnterosEnlazada resultado = sc.recursion(s.nextInt());
		s.close();
		
		resultado.comenzar();
		
		while (!resultado.fin()) System.out.println(resultado.proximo());
	}
       
    }
    

