import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String a[]){
        Scanner leer=new Scanner(System.in);
        String estadoInicial ="7245 6831";
        String estadoFinal =" 12345678";
        Arbol arbol= new Arbol(new Nodo(estadoInicial));
        Nodo nodoSolucion = new Nodo("");
        boolean ciclo=true;
        boolean mostrartabla=false;
        while (ciclo) {
         System.out.println("¿Que metodo de busqueda deseas utilizar?");  
         System.out.println("1.-Busqueda en anchura"+"\n"+
                            "2-Busqueda en profundidad"+"\n"+
                            "3.-Busqueda Costo Uniforme"+"\n"+
                            "4.-Heuristica Fichas mal colocadas"+"\n"+
                            "5.-Tabla comparativa (3 metodos juntos)");
         int opcion=leer.nextInt();
         switch (opcion) {
            case 1:
                nodoSolucion =arbol.realizarBusquedaEnAnchura(estadoFinal);
                ciclo=false;
                break;
            case 2:
                nodoSolucion =arbol.realizarBusquedaEnProfundidad(estadoFinal);
                ciclo=false;
                break;
            case 3:
                nodoSolucion=arbol.realizarBusquedaCostoUniforme(estadoFinal);
                ciclo=false;
                break;
            case 4:
                //Fichas mal colocadas es un metodo heuristico que utiliza busqueda A* con la funcion
                //f(n)=g(n)+h 
                //donde f(n) es la estimacion del costo total, desde la raiz hasta nodo objetivo
                //g(n) es el costo acumulado, desde el nodo raiz hasta el nodo actual n
                //h es la estimacion del costo del camino mas, desde el nodo actual hasta el nodo objetivo
                //elegi este metodo heuristico ya que es parecido a la busqueda en costo uniforme pero con el meotdo de busqueda A* 
                //hace que sea mas eficiente ya que es una busqueda informada que guia a la solucion
                nodoSolucion=arbol.realizarFichasMalColocadas(estadoFinal);
                ciclo=false;
            case 5:
                nodoSolucion =arbol.realizarBusquedaEnAnchura(estadoFinal);
                nodoSolucion =arbol.realizarBusquedaEnProfundidad(estadoFinal);
                nodoSolucion=arbol.realizarBusquedaCostoUniforme(estadoFinal);
                nodoSolucion=arbol.realizarFichasMalColocadas(estadoFinal);
                ciclo=false;
                mostrartabla=true;
                break;
            default:
                System.out.println("Opcion invalida");
                break;
         }
        }
        LinkedList<Nodo> camino = new LinkedList<>();
        Nodo actual = nodoSolucion;
        //llenar lista enlazada con los antecesesores de nodo solucion.
        while(actual!=null){
            camino.addFirst(actual);
            actual=actual.getPadre();
        }

        for(Nodo paso: camino){//recorrido de la lista enlazada 
            for(int i=0;i<paso.estado.length();i++){
                System.out.print(paso.estado.charAt(i)+" ");
                if((i+1)%3==0) System.out.println();//cada tercer iteracion se hace salto de linea
            }
            System.out.println("------");
        }
        System.out.println("Movimientos: " +(camino.size()-1));
        if(mostrartabla){
            TablaComparativa.imprimirTabla();
        }
    }

   
}

   
