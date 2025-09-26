public class TablaComparativa {
    public static long tiempo;       
    public static int nodosCreados;   

    public static long tiempoBA;
    public static int nodosBA;

    public static long tiempoBP;
    public static int nodosBP;

    public static long tiempoBCU;
    public static int nodosBCU;

    public static long tiempoFMC;
    public static int nodosFMC;
    
    public static void imprimirTabla() {
        System.out.println("-----------------------------------------------------------");
        System.out.println(" Método                       |Tiempo(s)   | Nodos");
        System.out.println("-----------------------------------------------------------");
        System.out.printf(" Busqueda en anchura          | %10d | %d%n", tiempoBA, nodosBA);
        System.out.printf(" Busqueda en profundidad      | %10d | %d%n", tiempoBP, nodosBP);
        System.out.printf(" Costo Uniforme.              | %10d | %d%n", tiempoBCU, nodosBCU);
        System.out.printf(" Fichas mal colocadas         | %10d | %d%n", tiempoFMC, nodosFMC);
        System.out.println("------------------------------------------------------------");
    }
}