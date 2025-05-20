package com.mycompany.debermatriz; 
import java.util.ArrayList;        // Importa la clase ArrayList para almacenar valores de la fila
import java.util.List;             // Importa la interfaz List
import java.util.stream.Collectors; // Importa Collectors para convertir listas a String
/**
 *
 * @author Diana Bermeo C
 */
public class SumarFila extends Thread { // Define la clase SumarFila que extiende Thread para usar hilos
    private int[] fila;           // Arreglo que representa una fila de la matriz
    private int indiceFila;       // Índice de la fila dentro de la matriz
    private int columnas;         // Número total de columnas de la matriz
    public static int sumaTotalGeneral = 0; // Variable estática para acumular la suma total
    public SumarFila(int[] fila, int indiceFila, int columnas) { // Constructor con parámetros
        this.fila = fila;         // Asigna la fila recibida
        this.indiceFila = indiceFila; // Asigna el índice de fila recibido
        this.columnas = columnas;     // Asigna el número de columnas recibido
    }
    @Override
    public void run() {           // Método que se ejecuta cuando inicia el hilo
        int suma = 0;             // Variable para almacenar la suma de la fila
        List<Integer> valoresFila = new ArrayList<>(); // Lista para almacenar los valores sumados
        for (int j = 0; j < columnas - 1; j++) { // Itera sobre las columnas excepto la última
            suma += fila[j];     // Acumula la suma de los elementos
            valoresFila.add(fila[j]); // Agrega el valor actual a la lista
        }
        fila[columnas - 1] = suma; // Guarda la suma al final de la fila (última columna)
        sumaTotalGeneral = sumaTotalGeneral +suma; //Guarda la suma total
        String valores = valoresFila.stream()   // Convierte la lista de enteros a una cadena
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        // Inserta en la base de datos el nombre del hilo, índice de fila, valores y suma
        DBManager.insertarRegistro(
                Thread.currentThread().getName(), // Obtiene el nombre del hilo actual
                indiceFila,                       // Índice de la fila
                valores,                          // Valores sumados como cadena
                suma                              // Resultado de la suma
        );
    }}
