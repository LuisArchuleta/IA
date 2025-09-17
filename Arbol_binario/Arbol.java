package Arbol_binario;
public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    // Método vacio
    public boolean vacio() {
        return raiz == null;
    }

    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        Nodo actual = raiz;
        Nodo padre = null;

        while (actual != null) {
            padre = actual;
            if (valor < actual.valor) {
                actual = actual.izquierda;
            } else if (valor > actual.valor) {
                actual = actual.derecha;
            } else {
                return;
            }
        }

        if (valor < padre.valor) {
            padre.izquierda = nuevo;
        } else {
            padre.derecha = nuevo;
        }
    }


    public Nodo buscarNodo(int valor) {
        Nodo actual = raiz;
        while (actual != null) {
            if (valor == actual.valor) {
                return actual;
            } else if (valor < actual.valor) {
                actual = actual.izquierda;
            } else {
                actual = actual.derecha;
            }
        }
        return null; // no encontrado
    }

    // Método imprimirArbol (inOrden sin recursión)
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }

        java.util.Stack<Nodo> pila = new java.util.Stack<>();
        Nodo actual = raiz;

        while (actual != null || !pila.isEmpty()) {
            while (actual != null) {
                pila.push(actual);
                actual = actual.izquierda;
            }
            actual = pila.pop();
            System.out.print(actual.valor + " ");
            actual = actual.derecha;
        }
        System.out.println();
    }
}
