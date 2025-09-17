import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Arbol {
    Nodo raiz;
    public Arbol(Nodo raiz)
    {
        this.raiz=raiz;
    }
    public Nodo realizarBusquedaEnAnchura(String objetivo){
        Queue<Nodo> cola = new LinkedList<Nodo>();
        HashSet<String> visitados=new HashSet<String>();
        cola.add(raiz);
        visitados.add(raiz.estado);
        Nodo actual=null;
        boolean encontrado=false;
        while(!encontrado && cola.size()>0){
            actual=cola.poll();
            System.out.println("Procesando "+actual.estado);
            if(actual.estado.equals(objetivo)){
                encontrado=true;
            }else{
                List<String> sucesores = actual.obtenerSucesores(actual);
                for(String sucesor: sucesores){
                    //si ya fue procesado, ignorar
                    if(visitados.contains(sucesor))
                        continue;
                    System.out.println("Agregando a cola:"+sucesor);
                    cola.add(new Nodo(sucesor));
                    visitados.add(sucesor);
                }
            }       
        }
        return actual;
    }
}
