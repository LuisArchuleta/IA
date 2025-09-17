import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String a[]){
        String estadoInicial ="7245 6831";
        String estadoFinal =" 12345678";
        Arbol arbol= new Arbol(new Nodo(estadoInicial));
        Nodo nodo = new Nodo("");
        nodo =arbol.realizarBusquedaEnAnchura(estadoFinal);
        System.out.println("El nodo final es");
        List<String> sucesores= new ArrayList<>();
        sucesores=nodo.obtenerSucesores(nodo);
        System.out.println("Sucesores");
        for(String sucesor:sucesores){
            System.out.println(sucesor);
        }

    }

   
}

   
