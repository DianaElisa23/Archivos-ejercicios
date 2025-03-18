import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemoverCadena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cadena para eliminar:");
        String cadena = scanner.nextLine();

        System.out.println("Ingresa el nombre del archivo txt:");
        String nombreArchivo = scanner.nextLine();

        File archivo = new File(nombreArchivo);

        try {
            Scanner LeerArchivo = new Scanner(archivo);
            String contenido = "";

            while (LeerArchivo.hasNextLine()) {
                contenido += LeerArchivo.nextLine().replace(cadena, "") + "\n";
            }
            LeerArchivo.close();

            FileWriter escritor = new FileWriter(archivo);
            escritor.write(contenido);
            escritor.close();

            System.out.println("Se elimino la cadena");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
