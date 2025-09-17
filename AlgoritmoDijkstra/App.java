
package AlgoritmoDijkstra;
public class App{
    public static void main(String[] args) {
                // Crear nodos
                Nodo nodo0 = new Nodo(0);
                Nodo nodo1 = new Nodo(1);
                Nodo nodo2 = new Nodo(2);
                Nodo nodo3 = new Nodo(3);

                // Conectar nodos (grafo dirigido)
                nodo0.vecinos.add(new Arista(nodo1, 1));
                nodo0.vecinos.add(new Arista(nodo2, 4));
                nodo1.vecinos.add(new Arista(nodo2, 2));
                nodo1.vecinos.add(new Arista(nodo3, 6));
                nodo2.vecinos.add(new Arista(nodo3, 3));

                // Ejecutar Algoritmo Dijkstra desde nodo0
                Dijkstra algoritmo = new Dijkstra();
                algoritmo.dijkstra(nodo0);
                
                // Imprimir distancias
                Nodo[] nodos = {nodo0, nodo1, nodo2, nodo3};
                for (Nodo n : nodos) {
                    System.out.println("Distancia desde nodo 0 a nodo " + n.id + " = " + n.distancia);
                }

                algoritmo.imprimirCamino(nodo3);
            
            }
    }