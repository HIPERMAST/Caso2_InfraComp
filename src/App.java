import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("Elige el modo de la aplicación: ");
        System.out.println("1 - Modo 1");
        System.out.println("2 - Modo 2");
        Scanner mode = new Scanner(System.in);

        int selectedMode = Integer.parseInt(mode.nextLine());

        if (selectedMode == 1) {
            System.out.println("Modo 1 seleccionado.");
            HashMap<String, Integer> parameters = readFileMode1();
            References references = new References(parameters.get("TP"), parameters.get("NF"), parameters.get("NC"), parameters.get("NR"));
            saveReferences(references, parameters.get("NC"));
        } else if (selectedMode == 2) {
            System.out.println("Modo 2 seleccionado.");
            HashMap<String, Integer> parameters = readFileMode2();
        } else {
            System.out.println("Modo no válido.");
        }

        mode.close();
    }


    public static void saveReferences(References references, int NC) {
        String referencesString = references.generateReferences();
        
        String fileRoot = "./References/" + NC + ".txt";

        try {
            File archivo = new File(fileRoot);
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(referencesString);
            escritor.close();
            System.out.println("Archivo guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el archivo: " + e.getMessage());
        }
    }

    

    public static HashMap<String, Integer> readFileMode1() {

    HashMap<String, Integer> parameters = new HashMap<>();

    System.out.println("Inserte el nombre del archivo (sin el .txt): ");
    Scanner sc = new Scanner(System.in);
    String fileName = sc.nextLine();

    try {
        Scanner scanner = new Scanner(new File("./files/" + fileName + ".txt"));

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();

            if (linea.startsWith("TP=")) {
                parameters.put("TP", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NF=")) {
                parameters.put("NF", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NC=")) {
                parameters.put("NC", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NR=")) {
                parameters.put("NR", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("MP=")) {
                parameters.put("MP", Integer.parseInt(linea.substring(3)));
            }
        }
        scanner.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        e.printStackTrace();
    }

    sc.close();

    return parameters;

    }


    public static HashMap<String, Integer> readFileMode2() {

        HashMap<String, Integer> parameters = new HashMap<>();
    
        System.out.println("Inserte el nombre del archivo (sin el .txt): ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
    
        try {
            Scanner scanner = new Scanner(new File("./files/" + fileName + ".txt"));
    
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();

            if (linea.startsWith("TP=")) {
                parameters.put("TP", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NF=")) {
                parameters.put("NF", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NC=")) {
                parameters.put("NC", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("NR=")) {
                parameters.put("NR", Integer.parseInt(linea.substring(3)));
            } else if (linea.startsWith("MP=")) {
                parameters.put("MP", Integer.parseInt(linea.substring(3)));
            }
            else {
                // TODO: Read the rest of the parameters
            }
        }
            scanner.close();

    
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        sc.close();
    
        return parameters;
    
        }

}
