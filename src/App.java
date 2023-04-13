import java.io.File;
import java.io.FileNotFoundException;
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
        } else if (selectedMode == 2) {
            System.out.println("Modo 2 seleccionado.");
            HashMap<String, Integer> parameters = readFileMode2();
        } else {
            System.out.println("Modo no válido.");
        }

        mode.close();
    }

    

    public static HashMap<String, Integer> readFileMode1() {

    HashMap<String, Integer> parameters = new HashMap<>();

    System.out.println("Inserte el nombre del archivo (sin el .txt): ");
    Scanner sc = new Scanner(System.in);
    String fileName = sc.nextLine();

    try {
        Scanner scanner = new Scanner(new File("./data/" + fileName + ".txt"));

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

        // Print the parameters
        System.out.println("TP: " + parameters.get("TP"));
        System.out.println("NF: " + parameters.get("NF"));
        System.out.println("NC: " + parameters.get("NC"));
        System.out.println("NR: " + parameters.get("NR"));
        System.out.println("MP: " + parameters.get("MP"));

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
            Scanner scanner = new Scanner(new File("./data/" + fileName + ".txt"));
    
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
    
            }
            scanner.close();
    
            // Print the parameters

    
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        sc.close();
    
        return parameters;
    
        }

}
