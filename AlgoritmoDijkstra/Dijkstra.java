package AlgoritmoDijkstra;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
public class Dijkstra {

    public static void dijkstra(Nodo origen) {
        PriorityQueue<Nodo> listap = new PriorityQueue<>();//Cola pero ordenada por prioridad
        origen.distancia = 0;
        listap.add(origen);

        while (!listap.isEmpty()) {
            Nodo actual = listap.poll();//agrega el nodo y lo elimina de la lista

            for (Arista arista : actual.vecinos) {
                Nodo vecino = arista.destino;
                int nuevoCosto = actual.distancia + arista.peso;
                if (nuevoCosto < vecino.distancia) {
                    vecino.distancia = nuevoCosto;
                    vecino.padre= actual;
                    listap.add(vecino);
                }
            }
        }
    }

    public static void imprimirCamino(Nodo destino) {
    Stack<Nodo> stack = new Stack<>();
    for (Nodo n = destino; n != null; n = n.padre) {
        stack.push(n);
    }

    int distanciaAcumulada;
    System.out.println("Camino mas corto desde el nodo raiz " +stack.peek().id +" hasta el nodo destino " + destino.id);
    while (stack.size()>1) {
        distanciaAcumulada=+ stack.peek().distancia;
        System.out.print("Nodo: "+stack.pop().id + " "); //Imprime el id del nodo raiz al destino 
        System.out.println("Distancia acumulada:"+ distanciaAcumulada);
    }
    System.out.println();
}
}

