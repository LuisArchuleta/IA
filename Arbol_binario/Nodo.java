package Arbol_binario;

public class Nodo {
    int valor;
    Nodo izq, der;

    public Nodo(int valor) {
        this.valor = valor;
        izq = der = null;
    }
}