import java.util.ArrayList;

class Nodo {
    private final String dato;
    private final ArrayList<Arista> listaAdyacencia;

    public Nodo(String dato) {
        this.dato = dato;
        this.listaAdyacencia = new ArrayList<>();
    }

    public String getDato() {
        return dato;
    }

    public ArrayList<Arista> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void agregarArista(Nodo nodoFinal, double peso) {
        Arista arista = new Arista(this, nodoFinal, peso);
        listaAdyacencia.add(arista);
    }
}
