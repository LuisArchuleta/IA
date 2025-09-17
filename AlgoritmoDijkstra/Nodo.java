package AlgoritmoDijkstra;
import java.util.ArrayList;
import java.util.List;
public class Nodo implements Comparable<Nodo> {
    public int id;//identificador del nodo
    public int distancia = Integer.MAX_VALUE; // distancia desde el origen
    public List<Arista> vecinos = new ArrayList<>(); //lista de aristas conectados al nodo
    public Nodo padre= null;
    public Nodo(int id) {
        this.id = id;
        this.padre=null;
    }

    @Override
    public int compareTo(Nodo otro) { 
        return Integer.compare(this.distancia, otro.distancia); // distancia entre nodos
    }
}