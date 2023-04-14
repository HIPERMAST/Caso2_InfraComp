import java.util.HashMap;

public class References {

    private int TP;  // Tamaño de página
    private int NF;  // Número de filas de la matriz
    private int NC;  // Número de columnas de la matriz
    private int NR;  // Número total de referencias
    private int cantMatrix; // Cantidad de matrices

    public References(int TP, int NF, int NC, int NR) {
        this.TP = TP;
        this.NF = NF;
        this.NC = NC;
        this.NR = NR;
        this.cantMatrix = 3;
    }

    public String generateReferences() {
        String references = "";
        HashMap<String, String> pages = new HashMap<String, String>();
        int cont = -4;

        if (TP == (NF * NC) * 4) {

            pages.put("A", "0");
            pages.put("B", "1");
            pages.put("C", "2");

            for (int i = 0; i < NF; i++) {
                for (int j = 0; j < NC; j++) {

                    cont += 4;

                    if (NR > 0) {
                        references += "\n[" + "A" + "-" + i + "-" + j + "]" + "," + pages.get("A") + "," + cont;
                        NR--;
                    }
                    if (NR > 0) {
                        references += "\n[" + "B" + "-" + i + "-" + j + "]" + "," + pages.get("B") + "," + cont;
                        NR--;
                    }
                    if (NR > 0) {
                        references += "\n[" + "C" + "-" + i + "-" + j + "]" + "," + pages.get("C") + "," + cont;
                        NR--;
                    }

                }
            }
        } else if (TP > (NF * NC) * 4) {

            int mp = (TP / ((NF * NC) * 4));

            int matrixIndex = 0;
            int pageNumber = 0;
            int letterNumber = 65;
            for (int i = 0; i < cantMatrix * mp; i+=mp) {
                char letterMatrix = (char) (letterNumber);
                String letter = Character.toString(letterMatrix);
                pages.put(letter, "" + pageNumber);
                matrixIndex++;
                letterNumber++;
                if (matrixIndex == mp) {
                    matrixIndex = 0;
                    pageNumber++;

                }
            }

            for (int i = 0; i < NF; i++) {
                for (int j = 0; j < NC; j++) {

                    cont += 4;

                    if (NR > 0) {
                        references += "\n[" + "A" + "-" + i + "-" + j + "]" + "," + pages.get("A") + "," + cont;
                        NR--;
                    }
                    if (NR > 0) {
                        references += "\n[" + "B" + "-" + i + "-" + j + "]" + "," + pages.get("B") + "," + cont;
                        NR--;
                    }
                    if (NR > 0) {
                        references += "\n[" + "C" + "-" + i + "-" + j + "]" + "," + pages.get("C") + "," + cont;
                        NR--;
                    }

                }
            }

        } else if (TP < (NF * NC) * 4) {

            int mp = (((NF * NC) * 4) / TP);

            int matrixIndex = 0;
            int pageNumber = 0;
            int letterNumber = 65;
            for (int i = 0; i < cantMatrix * mp; i++) {
                char letterMatrix = (char) (letterNumber);
                String letter = Character.toString(letterMatrix);
                pages.put(letter, "" + pageNumber);
                pageNumber++;
                matrixIndex++;
                if (matrixIndex == mp) {
                    matrixIndex = 0;
                    letterNumber++;

                }
            }

            int tamPage = TP;

            for (int k = 0, contM = 3; k < pageNumber/cantMatrix; k++) {
                for (int i = 0; i < (NF ); i++) {
                    for (int j = 0; j < (NC); j++) {

                        cont += 4;
                        if (cont == tamPage) {
                            tamPage += TP;
                            contM--;
                        }
                        if (NR > 0) {
                            references += "\n[" + "A" + "-" + i + "-" + j + "]" + "," + (Integer.parseInt(pages.get("A"))-contM)  + "," + cont;
                            NR--;
                        }
                        if (NR > 0) {
                            references += "\n[" + "B" + "-" + i + "-" + j + "]" + "," + (Integer.parseInt(pages.get("B"))-contM)  + "," + cont;
                            NR--;
                        }
                        if (NR > 0) {
                            references += "\n[" + "C" + "-" + i + "-" + j + "]" + "," + (Integer.parseInt(pages.get("C"))-contM)  + "," + cont;
                            NR--;
                        }

                    }
                }
            }
        }
        
        return references;
    }
    
}
