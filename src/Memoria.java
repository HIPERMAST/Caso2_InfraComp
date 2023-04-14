import java.util.ArrayList;

public class Memoria {
    public ArrayList<Pagina> paginas;
    public int fallosPagina;

    public Memoria( ArrayList<Pagina> paginas) {
        this.paginas = paginas;
        this.fallosPagina = 0;
    }

    public void referenciarPagina(int id) {
        for (Pagina pagina : paginas) {
            if (pagina.getId() == id) {
                if(pagina.getUbicacion() == "RAM") {
                    pagina.referenciar();
                    return;
                } else {
                    falloPagina();
                    pagina.setUbicacion("RAM");
                    pagina.setContador(0);
                    pagina.referenciar();
                }
            }
        }
    }

    public void falloPagina() {
        Pagina min = paginas.get(0);
        int minContador = min.getContador();
        for(Pagina pagina : paginas) {
            if(pagina.getContador() < minContador) {
                min = pagina;
                minContador = pagina.getContador();
            }
        }
        min.setUbicacion("DISCO");
        fallosPagina++;
    }
}
