import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String a[]){
        String estadoInicial ="7245 6831";
        String estadoFinal =" 12345678";
        Arbol arbol= new Arbol(new Nodo(estadoInicial));
        Nodo nodoSolucion = new Nodo("");
        nodoSolucion =arbol.realizarBusquedaEnAnchura(estadoFinal);
        LinkedList<Nodo> camino = new LinkedList<>();
        Nodo actual = nodoSolucion;
        //llenar lista enlazada con los antecesesores de nodo solucion.
        while(actual!=null){
            camino.addFirst(actual);
            actual=actual.getPadre();
        }

        for(Nodo paso: camino){
            for(int i=0;i<paso.estado.length();i++){
                System.out.print(paso.estado.charAt(i)+" ");
                if((i+1)%3==0) System.out.println();
            }
            System.out.println("------");
        }
        
        System.out.println("Movimientos: " +(camino.size()-1));

    }

   
}

   
