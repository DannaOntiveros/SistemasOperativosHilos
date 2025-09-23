import java.util.Random;  // Random para números aleatorios
import java.util.Scanner; // 

public class Proyecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // objeto Scanner 
        Random ale = new Random(); // Objeto Random números aleatorios

        // cuántos hilos crea lo digita
        System.out.print("¿Cuántos hilos quieres crear? ");
        int numHilos = sc.nextInt(); // Guarda

        // Repetimos
        for (int i = 1; i <= numHilos; i++) {
            System.out.println("\nConfiguración del Hilo " + i + ":");

            //  ingresa el rango de inicio y fin para este hilo
            System.out.print("Ingresa el valor de inicio: ");
            int inicio = sc.nextInt();

            System.out.print("Ingresa el valor de fin: ");
            int fin = sc.nextInt();

            // Generamos un número aleatorio entre 0 y 150
            int numero = ale.nextInt(151);
            System.out.println("Número aleatorio generado para Hilo " + i + ": " + numero);

            // Guardamos en variables finales para usarlas dentro del Runnable
            int finalNumero = numero;
            int finalInicio = inicio;
            int finalFin = fin;

            // Definimos la tarea que hará este hilo
            Runnable tarea = new Runnable() {
                @Override
                public void run() {
                    // número aleatorio está dentro del rango dado por el usuario
                    if (finalNumero >= finalInicio && finalNumero <= finalFin) {
                        int suma = 0;
                        String operacion = ""; // Guardará la cadena con la suma progresiva

                        // Calculamos la suma paso a paso
                        for (int j = 1; j <= finalNumero; j++) {
                            suma += j; // acumulamos el número
                            if (j == 1) {
                                operacion = "1";
                            } else {
                                operacion += " + " + j;
                            }
                            // Mostrar cada paso de la suma
                            System.out.println(Thread.currentThread().getName() +
                                    " → " + operacion + " = " + suma);
                        }

                        //  total
                        System.out.println(Thread.currentThread().getName() +
                                " terminó. Resultado final: " + suma);
                    } else {
                        // no está dentro del rango,no hace la suma
                        System.out.println(Thread.currentThread().getName() +
                                " no realiza la suma porque el número está fuera de " +
                                finalInicio + "-" + finalFin);
                    }
                }
            };

            // Creamos el hilo, tarea mas nombre
            Thread hilo = new Thread(tarea, "Hilo " + i + " (" + inicio + "-" + fin + ")");

            // ejecución del hilo
            hilo.start();
        }

        sc.close(); // 
    }
}
