package Arbol_binario;

public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Nodo raiz = null;

        // Insertar valores
        System.out.println();

        System.out.println("Recorrido In-Order:");
        arbol.ImprimirArbol(raiz);  // Resultado: 20 30 40 50 70
    }
}

