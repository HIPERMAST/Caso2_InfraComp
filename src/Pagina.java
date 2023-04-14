public class Pagina {
    private int contador=0;
    private int id;
    private String ubicacion;
    private int tamanio;

    public Pagina(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }
    public void referenciar() {
        contador++;
    }
    public int getContador() {
        return contador;
    }
}
