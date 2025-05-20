package com.mycompany.debermatriz; 
import java.util.Random; // Importa la clase Random para generar números aleatorios
/**
 *
 * @author Diana Bermeo C
 */
public class Utilidades { // Clase auxiliar con métodos estáticos para manejo de matrices
    // Método para llenar una matriz con números aleatorios entre 1 y 100
    public static void llenarMatriz(int[][] matriz, int filas, int columnas) {
        Random rand = new Random(); // Crea un generador de números aleatorios
        for (int i = 0; i < filas; i++) { // Recorre cada fila
            for (int j = 0; j < columnas - 1; j++) { // Recorre cada columna excepto la última
                matriz[i][j] = rand.nextInt(100) + 1; // Asigna un valor aleatorio entre 1 y 100
            }
        }
    }
    // Método para imprimir la matriz en consola
    public static void imprimirMatriz(int[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) { // Recorre cada fila
            for (int j = 0; j < columnas; j++) { // Recorre todas las columnas
                System.out.print(matriz[i][j] + "\t"); // Imprime el valor separado por tabulaciones
            }
            System.out.println(); // Salto de línea al terminar cada fila
        }
    }
}

