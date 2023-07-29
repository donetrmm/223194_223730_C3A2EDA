import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Grafo {
    private ArrayList<Nodo> listaNodos;

    public Grafo() {
        listaNodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        listaNodos.add(nodo);
    }

    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public int getCantidadNodos() {
        return listaNodos.size();
    }

    public void mostrarGrafo() {
        for (Nodo nodo : listaNodos) {
            System.out.print(nodo.getDato() + " -> ");
            ArrayList<Arista> listaAdyacencia = nodo.getListaAdyacencia();
            for (Arista arista : listaAdyacencia) {
                System.out.print(arista.getNodoFinal().getDato() + "(" + arista.getPeso() + ") ");
            }
            System.out.println();
        }
    }

    public boolean buscarNodo(String dato) {
        for (Nodo nodo : listaNodos) {
            if (nodo.getDato().equals(dato)) {
                return true;
            }
        }
        return false;
    }

    public int posicionNodo(String dato) {
        for (int i = 0; i < listaNodos.size(); i++) {
            if (listaNodos.get(i).getDato().equals(dato)) {
                return i;
            }
        }
        return -1;
    }

    public void recorridoEnProfundidad(String datoInicial) {
        Nodo nodoInicial = buscarNodoPorDato(datoInicial);
        if (nodoInicial == null) {
            System.out.println("El nodo inicial no existe en el grafo.");
            return;
        }

        Set<Nodo> visitados = new HashSet<>();
        Stack<Nodo> pila = new Stack<>();

        pila.push(nodoInicial);

        while (!pila.isEmpty()) {
            Nodo nodoActual = pila.pop();

            if (!visitados.contains(nodoActual)) {
                System.out.print(nodoActual.getDato() + " -> ");
                visitados.add(nodoActual);

                for (Arista arista : nodoActual.getListaAdyacencia()) {
                    Nodo nodoAdyacente = arista.getNodoFinal();
                    if (!visitados.contains(nodoAdyacente)) {
                        pila.push(nodoAdyacente);
                    }
                }
            }
        }
    }

    private Nodo buscarNodoPorDato(String dato) {
        for (Nodo nodo : listaNodos) {
            if (nodo.getDato().equals(dato)) {
                return nodo;
            }
        }
        return null;
    }
}
