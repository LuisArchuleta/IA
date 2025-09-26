import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Arbol {
    Nodo raiz;
    public int contadorNodo;//
    public Arbol(Nodo raiz)
    {
        this.raiz=raiz;
    }
    public Nodo realizarBusquedaEnAnchura(String objetivo){
        long start=System.nanoTime();
        TablaComparativa.nodosCreados=0;
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
                    Nodo hijo = new Nodo(sucesor);
                    hijo.setPadre(actual);
                    cola.add(hijo);
                    TablaComparativa.nodosCreados++;
                    visitados.add(sucesor);
                }
            }       
        }
        long end = System.nanoTime();
        TablaComparativa.nodosBA=TablaComparativa.nodosCreados;
        TablaComparativa.tiempoBA=(end-start)/1000000000;
        return actual;
    }
    public Nodo realizarBusquedaEnProfundidad(String objetivo) {
        long start=System.nanoTime();
        TablaComparativa.nodosCreados=0;
        Stack<Nodo> pila = new Stack<>();
        HashSet<String> visitados = new HashSet<>();
        pila.push(raiz);
        visitados.add(raiz.estado);
        Nodo actual = null;
        boolean encontrado = false;

        while (!encontrado && !pila.isEmpty()) {
            actual = pila.pop();
            System.out.println("Procesando " + actual.estado);

            if (actual.estado.equals(objetivo)) {
                encontrado = true;
            } else {
                List<String> sucesores = actual.obtenerSucesores(actual);
                for (String sucesor : sucesores) {
                    if (visitados.contains(sucesor)) continue;
                    Nodo hijo = new Nodo(sucesor);
                    hijo.setPadre(actual);
                    pila.push(hijo);  
                    visitados.add(sucesor);
                    TablaComparativa.nodosCreados++;
                }
            }
        }
        long end = System.nanoTime();
        TablaComparativa.nodosBP=TablaComparativa.nodosCreados;
        TablaComparativa.tiempoBP=(end-start)/1000000000;
        return actual;
    }

    public Nodo realizarBusquedaCostoUniforme(String objetivo) {
        long start=System.nanoTime();
        TablaComparativa.nodosCreados=0;

        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>();//Se utiliza cola de prioridad
        HashSet<String> visitados = new HashSet<>();
        raiz.costo = 0; // costo inicial
        colaPrioridad.add(raiz);
        Nodo actual = null;
        boolean encontrado = false;

        while (!encontrado && !colaPrioridad.isEmpty()) {
            actual = colaPrioridad.poll(); // nodo con menor costo
            System.out.println("Procesando " + actual.estado + " con costo: " + actual.costo);

            if (actual.estado.equals(objetivo)) {
                encontrado = true;
            } else {
                List<String> sucesores = Nodo.obtenerSucesores(actual);
                for (String estadoHijo : sucesores) {
                    if (visitados.contains(estadoHijo)) continue;
                    Nodo hijo = new Nodo(estadoHijo);
                    hijo.setPadre(actual);
                    hijo.costo = actual.costo + 1; // costo de 1 por movimiento
                    colaPrioridad.add(hijo);
                    TablaComparativa.nodosCreados++;
                    visitados.add(estadoHijo);
                }
            }
        }
        long end = System.nanoTime();
        TablaComparativa.nodosBCU=TablaComparativa.nodosCreados;
        TablaComparativa.tiempoBCU=(end-start)/1000000000;
        return actual;
    }
     public Nodo realizarFichasMalColocadas(String objetivo) {
        long start = System.nanoTime();
        TablaComparativa.nodosCreados = 0;
        // Se utiliza una cola de prioridad, que ahora usa el valor f (costo + heurístico)
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(new java.util.Comparator<Nodo>() {
        @Override
        public int compare(Nodo n1, Nodo n2) {
        //Se utiliza el compareTo de FMC 
        return n1.compareToFMC(n2); 
        }
        });
        HashSet<String> visitados = new HashSet<>();
        //Se Inicializa la raíz
        raiz.costo = 0; 
        raiz.calcularHeuristica(objetivo); // Se calcula h(n) 
        raiz.f = raiz.costo + raiz.heuristico; // Se calcula f(n)
        colaPrioridad.add(raiz);
        Nodo actual = null;
        boolean encontrado = false;

        while (!encontrado && !colaPrioridad.isEmpty()) {
            actual = colaPrioridad.poll(); 
            // Se marca como visitado para no procesar estados repetidos
            visitados.add(actual.estado); 
            System.out.println("Procesando " + actual.estado + " con f: " + actual.f);
            if (actual.estado.equals(objetivo)) {
                encontrado = true;
            } else {
                List<String> sucesores = Nodo.obtenerSucesores(actual);
                for (String estadoHijo : sucesores) {
                    if (visitados.contains(estadoHijo)) continue;
                    Nodo hijo = new Nodo(estadoHijo);
                    hijo.setPadre(actual);
                    //Se calcula g(n) para el hijo
                    hijo.costo = actual.costo + 1; 
                    //Se calcula h(n) y f(n) para el hijo
                    hijo.calcularHeuristica(objetivo); // Se calcula h0
                    hijo.f = hijo.costo + hijo.heuristico; // f(n) = g(n) + h(n)
                    colaPrioridad.add(hijo);
                    TablaComparativa.nodosCreados++;
                    // No se marca el nodo como visitado hasta que se extrae
                }
            }
        }
        long end = System.nanoTime();
        TablaComparativa.nodosFMC=TablaComparativa.nodosCreados;
        TablaComparativa.tiempoFMC = (end - start) / 1000000000;
        return actual;
    }

    
}
