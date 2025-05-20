
package com.mycompany.debermatriz;
import static com.mycompany.debermatriz.SumarFila.sumaTotalGeneral;
import java.util.Scanner; // Importa la clase Scanner para leer entradas desde el teclado

/**
 *
 * @author Diana Bermeo C
 */
public class MainMatriz { // Clase principal del programa
    public static void main(String[] args) throws InterruptedException { // Método principal. Puede lanzar excepción si algún hilo es interrumpido
        //ENTRADA
        Scanner sc = new Scanner(System.in); // Crea objeto Scanner para leer datos desde consola
        System.out.print("Ingrese numero de filas: "); // Solicita número de filas al usuario
        int filas = sc.nextInt(); // Lee el número de filas
        int columnas = 0;
        do {System.out.print("Ingrese numero de columnas (maximo 10): "); // Solicita número de columnas
            columnas = sc.nextInt(); // Lee el número de columnas
            if (columnas > 10) {
                System.out.println("Numero maximo de columnas es 10. Intente nuevamente."); // Valida el límite de columnas
            }} while (columnas > 10); // Repite si el número es mayor a 10
        columnas += 1; // Se agrega una columna extra para almacenar la suma de cada fila
        int[][] matriz = new int[filas][columnas]; // Crea la matriz con las dimensiones ingresadas
        //PROCESO
        Utilidades.llenarMatriz(matriz, filas, columnas); // Llena la matriz con números aleatorios
        System.out.println("\nMatriz original:"); // Muestra mensaje previo a la impresión de la matriz
        Utilidades.imprimirMatriz(matriz, filas, columnas); // Imprime la matriz original
        SumarFila[] hilos = new SumarFila[filas]; // Crea un arreglo de hilos, uno por cada fila
        for (int i = 0; i < filas; i++) {
            hilos[i] = new SumarFila(matriz[i], i, columnas); // Crea el hilo con la fila actual
            hilos[i].start(); // Inicia el hilo
        }
        for (int i = 0; i < filas; i++) {hilos[i].join(); // Espera a que cada hilo termine su ejecución
        }
        //SALIDA
        System.out.println("\nMatriz con sumas en ultima columna:"); // Muestra mensaje previo a la matriz procesada
        Utilidades.imprimirMatriz(matriz, filas, columnas); // Imprime la matriz con las sumas en la última columna
        System.out.println("\nSuma total de todas las filas: " + sumaTotalGeneral); // Muestra la suma total de la matriz
        DBManager.cerrar(); // Cierra la conexión a la base de datos
    }
}
