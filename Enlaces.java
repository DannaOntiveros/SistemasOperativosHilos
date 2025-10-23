import java.io.IOException; // IMPORTA LA CLASE PARA MANEJAR ERRORES DE ENTRADA/SALIDA
import java.util.Scanner; // IMPORTA LA CLASE PARA LEER DATOS DEL USUARIO

public class Enlaces { // DECLARA LA CLASE PRINCIPAL
    public static void main(String[] args) { // MÉTODO PRINCIPAL DONDE INICIA EL PROGRAMA
        Scanner sc = new Scanner(System.in); // CREA UN OBJETO SCANNER PARA LEER LA ENTRADA DEL USUARIO
        int opcion; // VARIABLE PARA GUARDAR LA OPCIÓN DEL MENÚ

        do { // INICIA UN BUCLE DO-WHILE PARA MOSTRAR EL MENÚ REPETIDAMENTE
            System.out.println("\n--- MENU DE ENLACES ---"); // IMPRIME EL ENCABEZADO DEL MENÚ
            System.out.println("1. Abrir Google"); // OPCIÓN 1: ABRIR GOOGLE
            System.out.println("2. Abrir Spotify"); // OPCIÓN 2: ABRIR SPOTIFY
            System.out.println("3. Abrir Word"); // OPCIÓN 3: ABRIR MICROSOFT WORD
            System.out.println("4. Abrir la página del TESCHA"); // OPCIÓN 4: ABRIR PÁGINA DEL TESCHA
            System.out.println("5. Abrir Classroom"); // OPCIÓN 5: ABRIR CLASSROOM
            System.out.println("0. Salir"); // OPCIÓN 0: SALIR DEL PROGRAMA
            System.out.print("Selecciona una opción: "); // PIDE AL USUARIO QUE INGRESE UNA OPCIÓN
            opcion = sc.nextInt(); // LEE LA OPCIÓN INGRESADA POR EL USUARIO

            switch (opcion) { // INICIA EL SWITCH PARA ELEGIR LA ACCIÓN SEGÚN LA OPCIÓN
                case 1: // SI EL USUARIO ELIGE 1
                    abrirURL("https://www.google.com"); // LLAMA AL MÉTODO PARA ABRIR GOOGLE
                    break; // SALE DEL CASO 1
                case 2: // SI EL USUARIO ELIGE 2
                    abrirAplicacion("C:\\Users\\danna\\AppData\\Roaming\\Spotify\\Spotify.exe"); // ABRE SPOTIFY
                    break; // SALE DEL CASO 2
                case 3: // SI EL USUARIO ELIGE 3
                    abrirAplicacion("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE"); // ABRE MICROSOFT WORD
                    break; // SALE DEL CASO 3
                case 4: // SI EL USUARIO ELIGE 4
                    abrirURL("https://www.tescha.edu.mx"); // ABRE LA PÁGINA DEL TESCHA
                    break; // SALE DEL CASO 4
                case 5: // SI EL USUARIO ELIGE 5
                    abrirURL("https://classroom.google.com"); // ABRE GOOGLE CLASSROOM
                    break; // SALE DEL CASO 5
                case 0: // SI EL USUARIO ELIGE 0
                    System.out.println("Saliendo..."); // MENSAJE DE SALIDA
                    break; // SALE DEL CASO 0
                default: // SI EL USUARIO INGRESA UNA OPCIÓN NO VÁLIDA
                    System.out.println("Opción no válida"); // MENSAJE DE ERROR
            }

        } while (opcion != 0); // REPITE EL MENÚ HASTA QUE EL USUARIO ELIJA 0

        sc.close(); // CIERRA EL SCANNER PARA LIBERAR RECURSOS
    }

    // MÉTODO PARA ABRIR UNA URL EN EL NAVEGADOR
    public static void abrirURL(String url) {
        try { // INTENTA ABRIR LA URL
            new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", url).start(); // ABRE CHROME CON LA URL
        } catch (IOException e) { // SI HAY ERROR
            e.printStackTrace(); // IMPRIME EL ERROR
        }
    }

    // MÉTODO PARA ABRIR UNA APLICACIÓN LOCAL
    public static void abrirAplicacion(String ruta) {
        try { // INTENTA ABRIR LA APLICACIÓN
            new ProcessBuilder(ruta).start(); // ABRE LA APLICACIÓN
        } catch (IOException e) { // SI HAY ERROR
            e.printStackTrace(); // IMPRIME EL ERROR
        }
    }
}
