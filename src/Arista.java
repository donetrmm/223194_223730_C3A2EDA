class Arista {
    private final Nodo nodoInicial;
    private final Nodo nodoFinal;
    private final double peso;

    public Arista(Nodo nodoInicial, Nodo nodoFinal, double peso) {
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
        this.peso = peso;
    }


    public Nodo getNodoFinal() {
        return nodoFinal;
    }

    public double getPeso() {
        return peso;
    }
}
