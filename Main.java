/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol_B;

import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el grado del árbol B: ");
        int grado = scanner.nextInt();
        ArbolB arbolB = new ArbolB(grado);

        // Ejemplo de inserción y búsqueda
        arbolB.insertar(10);
        arbolB.insertar(5);
        arbolB.insertar(6);
        arbolB.insertar(20);

        System.out.println("Búsqueda:");
        System.out.println("¿La clave 6 está en el árbol? " + arbolB.buscar(6));
        System.out.println("¿La clave 15 está en el árbol? " + arbolB.buscar(15));

        // Ejemplo de eliminación
        arbolB.eliminar(10);
        System.out.println("nodo 10 eliminado..");

        scanner.close();
    }
}
   
    

