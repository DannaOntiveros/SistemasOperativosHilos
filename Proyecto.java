import java.util.Random; //clase destina a crear numeros aleatorios

public class Proyecto {
    public static void main(String[] args) {
        Random ale = new Random(); //se crea un objeto llamado ale 

        // Número aleatorio Hilo 1: 0 a 150 (generamos de manera general)
        int numero1 = ale.nextInt(151); 
        System.out.println("Número aleatorio Hilo 1: " + numero1);

        // Número aleatorio Hilo 2: 0 a 150 (generamos de manera general)
        int numero2 = ale.nextInt(151); 
        System.out.println("Número aleatorio Hilo 2: " + numero2);

        //Runnable para Hilo 1
        Runnable tarea1 = new Runnable() { 
            @Override
            public void run() { 
                //solo suma si el numero está entre 0 y 100
                if (numero1 >= 0 && numero1 <= 100) {
                    int suma = 0; //se guarda la suma
                    for (int i = 1; i <= numero1; i++) { //rango de 1 hasta numero1
                        suma += i; //se acumula i en la variable suma
                    }
                    System.out.println(Thread.currentThread().getName() + 
                    " terminó. La suma es: " + suma); //Thread.current devuelve el hilo que se esta ejecutando en esa tarea y con get obtiene el nombre del hilo
                } else {
                    System.out.println(Thread.currentThread().getName() + 
                    " no realiza la suma porque el número está fuera de 0-100");
                }
            }
        }; 

        //Runnable para Hilo 2
        Runnable tarea2 = new Runnable() {
            @Override
            public void run() {
                //solo suma si el numero está entre 101 y 150
                if (numero2 >= 101 && numero2 <= 150) {
                    int suma = 0; //se guarda la suma
                    for (int i = 1; i <= numero2; i++) { //rango de 1 hasta numero2
                        suma += i; //se acumula i en la variable suma
                    }
                    System.out.println(Thread.currentThread().getName() + 
                    " terminó. La suma es: " + suma);
                } else {
                    System.out.println(Thread.currentThread().getName() + 
                    " no realiza la suma porque el número está fuera de 101-150");
                }
            }
        }; 

        //Crear y lanzar los dos hilos
        Thread hilo1 = new Thread(tarea1, "Hilo 1 (0-100)"); 
        Thread hilo2 = new Thread(tarea2, "Hilo 2 (101-150)"); 

        hilo1.start(); //inicia Hilo 1
        hilo2.start(); //inicia Hilo 2
    } //fin main
} //fin clase Proyecto
