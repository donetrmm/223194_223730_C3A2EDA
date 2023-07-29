import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear grafo");
            System.out.println("2. Mostrar grafo");
            System.out.println("3. Mostrar cantidad de nodos del grafo");
            System.out.println("4. Búsqueda de nodo");
            System.out.println("5. Recorrido en profundidad");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> crearGrafo(grafo, scanner);
                case 2 -> grafo.mostrarGrafo();
                case 3 -> System.out.println("Cantidad de nodos del grafo: " + grafo.getCantidadNodos());
                case 4 -> buscarNodo(grafo, scanner);
                case 5 -> {
                    System.out.print("Ingrese el dato del nodo inicial para el recorrido en profundidad: ");
                    String datoInicial = scanner.next();
                    grafo.recorridoEnProfundidad(datoInicial);
                }
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 6);
    }

    private static void crearGrafo(Grafo grafo, Scanner scanner) {
        System.out.print("Ingrese la cantidad de nodos del grafo: ");
        int cantidadNodos = scanner.nextInt();

        for (int i = 0; i < cantidadNodos; i++) {
            System.out.print("Ingrese el dato del nodo " + (i + 1) + ": ");
            String dato = scanner.next();
            Nodo nodo = new Nodo(dato);
            grafo.agregarNodo(nodo);
        }

        for (Nodo nodo : grafo.getListaNodos()) {
            System.out.print("¿El nodo " + nodo.getDato() + " tiene conexiones? (s/n): ");
            String tieneConexiones = scanner.next();
            if (tieneConexiones.equalsIgnoreCase("s")) {
                crearConexiones(nodo, grafo, scanner);
            }
        }
    }

    private static void crearConexiones(Nodo nodo, Grafo grafo, Scanner scanner) {
        System.out.print("Ingrese la cantidad de nodos adyacentes a " + nodo.getDato() + ": ");
        int cantidadAdyacentes = scanner.nextInt();

        for (int i = 0; i < cantidadAdyacentes; i++) {
            System.out.print("Ingrese el dato del nodo adyacente " + (i + 1) + ": ");
            String datoAdyacente = scanner.next();
            System.out.print("Ingrese el peso de la arista: ");
            double peso = scanner.nextDouble();

            int posicion = grafo.posicionNodo(datoAdyacente);
            if (posicion != -1) {
                Nodo nodoAdyacente = grafo.getListaNodos().get(posicion);
                nodo.agregarArista(nodoAdyacente, peso);
            } else {
                System.out.println("El nodo adyacente no existe. La arista no se ha agregado.");
                i=i-1;
            }
        }
    }

    private static void buscarNodo(Grafo grafo, Scanner scanner) {
        System.out.print("Ingrese el dato del nodo que desea buscar: ");
        String dato = scanner.next();
        boolean encontrado = grafo.buscarNodo(dato);

        if (encontrado) {
            int posicion = grafo.posicionNodo(dato);
            System.out.println("El nodo " + dato + " se encuentra en la posición " + posicion + " del grafo.");
        } else {
            System.out.println("El nodo " + dato + " no se encuentra en el grafo.");
        }
    }
}
