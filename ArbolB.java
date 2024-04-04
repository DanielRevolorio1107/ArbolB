/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol_B;


public class ArbolB {
    private Nodo raiz;
    private int grado;

    public ArbolB(int grado) {
        this.grado = grado;
        raiz = new Nodo(grado);
    }

    public void insertar(int clave) {
        if (raiz.claves.size() == grado - 1) {
            Nodo nuevaRaiz = new Nodo(grado);
            nuevaRaiz.hijos.add(raiz);
            dividirHijo(nuevaRaiz, 0);
            raiz = nuevaRaiz;
        }
        insertarNoLleno(raiz, clave);
    }

    private void insertarNoLleno(Nodo nodo, int clave) {
        int i = nodo.claves.size() - 1;
        if (nodo.esHoja) {
            while (i >= 0 && clave < nodo.claves.get(i)) {
                i--;
            }
            nodo.claves.add(i + 1, clave);
        } else {
            while (i >= 0 && clave < nodo.claves.get(i)) {
                i--;
            }
            i++;
            if (nodo.hijos.get(i).claves.size() == grado - 1) {
                dividirHijo(nodo, i);
                if (clave > nodo.claves.get(i)) {
                    i++;
                }
            }
            insertarNoLleno(nodo.hijos.get(i), clave);
        }
    }

    private void dividirHijo(Nodo padre, int indiceHijo) {
        Nodo hijoAdividir = padre.hijos.get(indiceHijo);
        Nodo nuevoHijo = new Nodo(grado);
        nuevoHijo.esHoja = hijoAdividir.esHoja;

        padre.claves.add(indiceHijo, hijoAdividir.claves.get(grado / 2));
        padre.hijos.add(indiceHijo + 1, nuevoHijo);

        for (int i = 0; i < grado / 2; i++) {
            nuevoHijo.claves.add(hijoAdividir.claves.remove(grado / 2));
        }
        if (!hijoAdividir.esHoja) {
            for (int i = 0; i <= grado / 2; i++) {
                nuevoHijo.hijos.add(hijoAdividir.hijos.remove(grado / 2));
            }
        }
    }

    public boolean buscar(int clave) {
        return buscar(raiz, clave);
    }

    private boolean buscar(Nodo nodo, int clave) {
        int i = 0;
        while (i < nodo.claves.size() && clave > nodo.claves.get(i)) {
            i++;
        }
        if (i < nodo.claves.size() && clave == nodo.claves.get(i)) {
            return true;
        }
        if (nodo.esHoja) {
            return false;
        }
        return buscar(nodo.hijos.get(i), clave);
    }

    
    
    public void eliminar(int clave) {
    eliminar(raiz, clave);
}

private void eliminar(Nodo nodo, int clave) {
    int indice = nodo.claves.indexOf(clave);
    if (indice != -1) { // Si la clave está en el nodo
        if (nodo.esHoja) {
            nodo.claves.remove(indice);
        } else {
            // Reemplazar la clave por la clave más a la izquierda del subárbol derecho
            Nodo sucesor = encontrarSucesor(nodo.hijos.get(indice + 1));
            nodo.claves.set(indice, sucesor.claves.get(0));
            eliminar(nodo.hijos.get(indice + 1), sucesor.claves.get(0));
        }
    } else { // Si la clave no está en el nodo
        int i = 0;
        while (i < nodo.claves.size() && clave > nodo.claves.get(i)) {
            i++;
        }
        if (!nodo.esHoja) {
            if (i < nodo.claves.size() && clave == nodo.claves.get(i)) {
                eliminar(nodo.hijos.get(i + 1), clave);
            } else {
                eliminar(nodo.hijos.get(i), clave);
            }
        }
    }
}

private Nodo encontrarSucesor(Nodo nodo) {
    while (!nodo.esHoja) {
        nodo = nodo.hijos.get(0);
    }
    return nodo;
}
}
