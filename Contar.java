import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Contar {
    public static void main(String[] args) {
        Scanner archivo = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo a contar: ");
        String nombre = archivo.nextLine();

        File file = new File(nombre);

        try {
            int numeroCaracteres = 0;
            int numeroPalabras = 0;
            int numeroDeLineas = 0;

            ArrayList<Character> lista = new ArrayList<>();
            Scanner LeerArchivo = new Scanner(file);

            while (LeerArchivo.hasNextLine()) {
                String data = LeerArchivo.nextLine(); 

                for (int i = 0; i < data.length(); i++) {
                    char caracter = data.charAt(i); 
                    lista.add(caracter);
                }
                numeroDeLineas++;
            }

            for (int i = 0; i < lista.size(); i++) {
                numeroCaracteres++;

                if (lista.get(i) == ' ' || lista.get(i) == '\n') {
                    numeroPalabras++;
                }
            }
            numeroPalabras++; 

            System.out.println("El archivo tiene: ");
            System.out.println(numeroCaracteres + " Caracteres");
            System.out.println(numeroPalabras + " Palabras");
            System.out.println(numeroDeLineas + " Líneas");

            LeerArchivo.close(); 
            archivo.close(); 
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
