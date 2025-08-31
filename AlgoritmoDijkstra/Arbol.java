package AlgoritmoDijkstra;
class Arbol {
    Nodo raiz;

    // Insertar un valor en el ABB
    Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }
        if (valor < raiz.valor) {
            raiz.izq = insertar(raiz.izq, valor);
        } else {
            raiz.der = insertar(raiz.der, valor);
        }
        return raiz;
    }

    // Recorrido In-Order (izquierda - raíz - derecha)
    public void ImprimirArbol(Nodo raiz) {
        if (raiz != null) {
            ImprimirArbol(raiz.izq);
            System.out.print(raiz.valor + " ");
            ImprimirArbol(raiz.der);
        }
    }

    public void buscarNodo(Nodo raiz, int valor){
        if(raiz != null){
            if(raiz.valor == valor){
                System.out.println("El nodo con valor " + valor + " ha sido encontrado.");
            }
            if(valor < raiz.valor){
                buscarNodo(raiz.izq, valor);
            }else {
                buscarNodo(raiz.der, valor);
            }
        } else {
            System.out.println("El nodo con valor " + valor + " no existe en el árbol.");
        }
    }
}