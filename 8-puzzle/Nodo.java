import java.util.ArrayList;
import java.util.List;

public class Nodo implements Comparable<Nodo> {//interfaz Comparable para que los nodos puedan comparar su prioridad para el costo uniforme
    String estado;
    Nodo padre;
    int costo;
    int profundidad;

    int heuristico; //valor de h(n)
    int f; //valor de f (n)= costo + heuristico
    

    public Nodo(String estado){
        this.estado=estado;
        this.f=0;
    }

    public static List<String> obtenerSucesores(Nodo nodo) {
        String estado=nodo.estado;
        List<String> successors = new ArrayList<String>();
        switch (estado.indexOf(" ")) {
            case 0: {
                successors.add(estado.replace(estado.charAt(0), '*').replace(estado.charAt(1), estado.charAt(0)).replace('*', estado.charAt(1)));
                successors.add(estado.replace(estado.charAt(0), '*').replace(estado.charAt(3), estado.charAt(0)).replace('*', estado.charAt(3)));
                break;
            }
            case 1: {
                successors.add(estado.replace(estado.charAt(1), '*').replace(estado.charAt(0), estado.charAt(1)).replace('*', estado.charAt(0)));
                successors.add(estado.replace(estado.charAt(1), '*').replace(estado.charAt(2), estado.charAt(1)).replace('*', estado.charAt(2)));
                successors.add(estado.replace(estado.charAt(1), '*').replace(estado.charAt(4), estado.charAt(1)).replace('*', estado.charAt(4)));
                break;
            }
            case 2: {

                successors.add(estado.replace(estado.charAt(2), '*').replace(estado.charAt(1), estado.charAt(2)).replace('*', estado.charAt(1)));
                successors.add(estado.replace(estado.charAt(2), '*').replace(estado.charAt(5), estado.charAt(2)).replace('*', estado.charAt(5)));
                break;
            }
            case 3: {
                successors.add(estado.replace(estado.charAt(3), '*').replace(estado.charAt(0), estado.charAt(3)).replace('*', estado.charAt(0)));
                successors.add(estado.replace(estado.charAt(3), '*').replace(estado.charAt(4), estado.charAt(3)).replace('*', estado.charAt(4)));
                successors.add(estado.replace(estado.charAt(3), '*').replace(estado.charAt(6), estado.charAt(3)).replace('*', estado.charAt(6)));
                break;
            }
            case 4: {
                successors.add(estado.replace(estado.charAt(4), '*').replace(estado.charAt(1), estado.charAt(4)).replace('*', estado.charAt(1)));
                successors.add(estado.replace(estado.charAt(4), '*').replace(estado.charAt(3), estado.charAt(4)).replace('*', estado.charAt(3)));
                successors.add(estado.replace(estado.charAt(4), '*').replace(estado.charAt(5), estado.charAt(4)).replace('*', estado.charAt(5)));
                successors.add(estado.replace(estado.charAt(4), '*').replace(estado.charAt(7), estado.charAt(4)).replace('*', estado.charAt(7)));
                break;
            }
            case 5: {
                successors.add(estado.replace(estado.charAt(5), '*').replace(estado.charAt(2), estado.charAt(5)).replace('*', estado.charAt(2)));
                successors.add(estado.replace(estado.charAt(5), '*').replace(estado.charAt(4), estado.charAt(5)).replace('*', estado.charAt(4)));
                successors.add(estado.replace(estado.charAt(5), '*').replace(estado.charAt(8), estado.charAt(5)).replace('*', estado.charAt(8)));
                break;
            }
            case 6: {
                successors.add(estado.replace(estado.charAt(6), '*').replace(estado.charAt(3), estado.charAt(6)).replace('*', estado.charAt(3)));
                successors.add(estado.replace(estado.charAt(6), '*').replace(estado.charAt(7), estado.charAt(6)).replace('*', estado.charAt(7)));
                break;

            }
            case 7: {
                successors.add(estado.replace(estado.charAt(7), '*').replace(estado.charAt(4), estado.charAt(7)).replace('*', estado.charAt(4)));
                successors.add(estado.replace(estado.charAt(7), '*').replace(estado.charAt(6), estado.charAt(7)).replace('*', estado.charAt(6)));
                successors.add(estado.replace(estado.charAt(7), '*').replace(estado.charAt(8), estado.charAt(7)).replace('*', estado.charAt(8)));
                break;
            }
            case 8: {
                successors.add(estado.replace(estado.charAt(8), '*').replace(estado.charAt(5), estado.charAt(8)).replace('*', estado.charAt(5)));
                successors.add(estado.replace(estado.charAt(8), '*').replace(estado.charAt(7), estado.charAt(8)).replace('*', estado.charAt(7)));
                break;
            }
        }
        return successors;
    }

    public void calcularHeuristica(String estadoObjetivo) {
        this.heuristico = 0;
        // Se recorre estadoObjetivo
        for (int i = 0; i < this.estado.length(); i++) {
            // Ignorar el espacio en blanco, ya que su posición no se cuenta como ficha mal colocada.
            if (this.estado.charAt(i) != ' ' && this.estado.charAt(i) != estadoObjetivo.charAt(i)) {
                this.heuristico++;
            }
        }
    }
    
    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

     public int compareTo(Nodo otro) {
        return this.costo - otro.costo; // menor costo primero
    }

    public int compareToFMC(Nodo otro) {
        return this.f - otro.f; // Menor costo primero para heuristica FMC
    }
}
