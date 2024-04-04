/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol_B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nodo {
    List<Integer> claves;
    List<Nodo> hijos;
    boolean esHoja;

    public Nodo(int grado) {
        claves = new ArrayList<>(grado - 1);
        hijos = new ArrayList<>(grado);
        esHoja = true;
    }
}