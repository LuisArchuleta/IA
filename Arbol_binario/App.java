package Arbol_binario;

public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Arbol:");
        arbol.imprimirArbol();

        int buscado1 = 100;
        Nodo nodo = arbol.buscarNodo(buscado1);
        if (nodo != null) {
            System.out.println("Nodo encontrado: " + nodo.valor);
        } else {
            System.out.println("Nodo " + buscado1 + " no encontrado.");
        }
        int buscado2 = 30;
        Nodo nodo2 = arbol.buscarNodo(buscado2);
        if (nodo2 != null) {
            System.out.println("Nodo " + nodo2.valor + " encontrado.");
        } else {
            System.out.println("Nodo " + buscado2 + " no encontrado.");
        }
    }
}

