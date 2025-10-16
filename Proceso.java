import java.util.LinkedList; // IMPORTA LA CLASE LINKEDLIST PARA USARLA COMO COLA
import java.util.Queue;      // IMPORTA LA INTERFAZ QUE DEFINE LA ESTRUCTURA DE COLA
import java.util.Scanner;    // IMPORTA SCANNER PARA LEER DATOS DEL USUARIO

// CLASE PRINCIPAL Y DEFINICIÓN DE PROCESO
public class Proceso implements Runnable { // IMPLEMENTA RUNNABLE PARA PODER EJECUTAR PROCESOS EN HILOS

    // VARIABLES DEL PROCESO
    private String tipoProceso;   // TIPO DE PROCESO (Contar Letras, Mostrar Números, Mostrar Palabra N Veces)
    private String entradaTexto;  // TEXTO O PALABRA INGRESADA POR EL USUARIO
    private int entradaNumero;    // NÚMERO ASOCIADO (LÍMITE DE NÚMEROS O REPETICIONES)

    // CONSTRUCTOR DEL PROCESO
    public Proceso(String tipoProceso, String entradaTexto, int entradaNumero) {
        this.tipoProceso = tipoProceso; // ASIGNA EL TIPO DE PROCESO
        this.entradaTexto = entradaTexto; // ASIGNA EL TEXTO INGRESADO
        this.entradaNumero = entradaNumero; // ASIGNA EL NÚMERO INGRESADO
    }

    // MÉTODO RUN: DEFINE LA ACCIÓN DEL PROCESO
    @Override
    public void run() { // SE EJECUTA CUANDO SE INICIA EL HILO
        switch (tipoProceso) { // EVALÚA EL TIPO DE PROCESO
            case "Contar Letras": // SI ES CONTAR LETRAS
                System.out.println("La palabra \"" + entradaTexto + "\" tiene " + entradaTexto.length() + " letras."); // MUESTRA CUÁNTAS LETRAS TIENE LA PALABRA
                break;

            case "Mostrar Números": // SI ES MOSTRAR NÚMEROS
                for (int i = 1; i <= entradaNumero; i++) { // BUCLE DESDE 1 HASTA EL NÚMERO INGRESADO
                    System.out.print(i + " "); // IMPRIME CADA NÚMERO EN LA MISMA LÍNEA
                }
                System.out.println(); // SALTO DE LÍNEA AL TERMINAR
                break;

            case "Mostrar Palabra N Veces": // SI ES MOSTRAR PALABRA N VECES
                for (int i = 0; i < entradaNumero; i++) { // BUCLE PARA REPETIR LA PALABRA N VECES
                    System.out.println(entradaTexto); // IMPRIME LA PALABRA
                }
                break;
        }
    }

    // MÉTODO toString: MUESTRA INFORMACIÓN DEL PROCESO
    @Override
    public String toString() { 
        return "Proceso: " + tipoProceso + " | Texto: " + entradaTexto + " | Número: " + entradaNumero; // RETORNA LA INFORMACIÓN DEL PROCESO
    }

    // MÉTODO PRINCIPAL Y MENÚ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // CREA UN SCANNER PARA LEER DATOS DEL USUARIO
        Queue<Proceso> cola = new LinkedList<>(); // CREA UNA COLA PARA GUARDAR LOS PROCESOS
        int opcion; // VARIABLE PARA GUARDAR LA OPCIÓN DEL MENÚ

        // BUCLE DEL MENÚ PRINCIPAL
        do {
            System.out.println("\n=== MENU PRINCIPAL ==="); // IMPRIME EL MENÚ
            System.out.println("1. Crear Proceso"); 
            System.out.println("2. Mostrar Cola");
            System.out.println("3. Ejecutar Procesos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); // LEE LA OPCIÓN DEL USUARIO
            sc.nextLine(); // LIMPIA EL BUFFER DEL SCANNER

            // OPCIONES DEL MENÚ PRINCIPAL
            switch (opcion) {

                // CREAR PROCESO
                case 1:
                    System.out.println("\n--- CREAR PROCESO ---"); // IMPRIME SUBMENÚ DE CREACIÓN DE PROCESO
                    System.out.println("A. Contar letras"); 
                    System.out.println("B. Mostrar números hasta N");
                    System.out.println("C. Mostrar palabra N veces");
                    System.out.print("Seleccione una opción: ");
                    char sub = sc.next().toUpperCase().charAt(0); // LEE LA OPCIÓN DE TIPO DE PROCESO
                    sc.nextLine(); // LIMPIA EL BUFFER DEL SCANNER

                    switch (sub) { // SWITCH PARA OPCIONES A, B, C
                        // OPCIÓN A: CONTAR LETRAS
                        case 'A':
                            String palabraA; // VARIABLE PARA GUARDAR LA PALABRA
                            do { // BUCLE PARA VALIDAR QUE SOLO INGRESE LETRAS
                                System.out.print("Ingrese una palabra: ");
                                palabraA = sc.nextLine(); // LEE LA PALABRA
                                if (!palabraA.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { // SI INGRESA CARACTER NO PERMITIDO
                                    System.out.println("Entrada inválida. Solo se permiten letras."); // MENSAJE DE ERROR
                                }
                            } while (!palabraA.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")); // REPITE HASTA QUE SEA VÁLIDO
                            cola.add(new Proceso("Contar Letras", palabraA, 0)); // AGREGA EL PROCESO A LA COLA
                            break;

                        // OPCIÓN B: MOSTRAR NÚMEROS
                        case 'B':
                            int numeroB; // VARIABLE PARA EL NÚMERO FINAL
                            while (true) { // BUCLE PARA VALIDAR ENTRADA NUMÉRICA
                                System.out.print("Ingrese el número final: ");
                                String entrada = sc.nextLine(); // LEE COMO TEXTO
                                try {
                                    numeroB = Integer.parseInt(entrada); // INTENTA CONVERTIR A NÚMERO
                                    break; // SALE SI ES VÁLIDO
                                } catch (NumberFormatException e) { // SI NO ES NÚMERO
                                    System.out.println(" Entrada inválida. Debe ingresar un número."); // MENSAJE DE ERROR
                                }
                            }
                            cola.add(new Proceso("Mostrar Números", "", numeroB)); // AGREGA EL PROCESO A LA COLA
                            break;

                        // OPCIÓN C: MOSTRAR PALABRA N VECES
                        case 'C':
                            String palabraC; // VARIABLE PARA LA PALABRA
                            do { // BUCLE PARA VALIDAR SOLO LETRAS
                                System.out.print("Ingrese una palabra (sin números): ");
                                palabraC = sc.nextLine();
                                if (!palabraC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { 
                                    System.out.println("❌ Entrada inválida. Solo se permiten letras."); 
                                }
                            } while (!palabraC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")); 

                            int vecesC; // VARIABLE PARA REPETICIONES
                            while (true) { // BUCLE PARA VALIDAR NÚMERO DE REPETICIONES
                                System.out.print("Ingrese cuántas veces desea mostrar la palabra: ");
                                String entrada = sc.nextLine();
                                try {
                                    vecesC = Integer.parseInt(entrada); // CONVIERTE A NÚMERO
                                    break; // SALE SI ES VÁLIDO
                                } catch (NumberFormatException e) { 
                                    System.out.println("❌ Entrada inválida. Debe ingresar un número."); 
                                }
                            }
                            cola.add(new Proceso("Mostrar Palabra N Veces", palabraC, vecesC)); // AGREGA EL PROCESO
                            break;

                        default: // OPCIÓN INVÁLIDA
                            System.out.println("Opción no válida.");
                    }
                    break;

                // MOSTRAR COLA DE PROCESOS
                case 2:
                    System.out.println("\n--- COLA DE PROCESOS ---");
                    if (cola.isEmpty()) { // SI NO HAY PROCESOS
                        System.out.println("La cola está vacía."); 
                    } else {
                        for (Proceso p : cola) { // RECORRE LA COLA
                            System.out.println(p); // IMPRIME CADA PROCESO
                        }
                    }
                    break;

                // EJECUTAR PROCESOS
                case 3:
                    System.out.println("\n--- EJECUTANDO PROCESOS ---");
                    while (!cola.isEmpty()) { // MIENTRAS HAYA PROCESOS
                        Proceso p = cola.poll(); // SACA EL PRIMER PROCESO DE LA COLA
                        Thread hilo = new Thread(p); // CREA UN HILO CON EL PROCESO
                        hilo.start(); // INICIA EL HILO
                        try {
                            hilo.join(); // ESPERA A QUE TERMINE EL HILO ANTES DE CONTINUAR
                        } catch (InterruptedException e) { // CAPTURA EXCEPCIONES
                            e.printStackTrace(); 
                        }
                    }
                    break;

                // SALIR
                case 4:
                    System.out.println("Saliendo del programa..."); // MENSAJE DE SALIDA
                    break;

                default: // OPCIÓN INVÁLIDA
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4); // REPITE HASTA QUE EL USUARIO ELIGA SALIR

        sc.close(); // CIERRA EL SCANNER
    }
}

