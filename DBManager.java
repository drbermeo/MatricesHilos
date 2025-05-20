package com.mycompany.debermatriz; // Define el paquete donde se encuentra la clase

import java.sql.*; 
/**
 *
 * @author Diana Bermeo C
 */

public class DBManager { // Declaración de la clase DBManager

    private static Connection conexion; // Variable estática para mantener la conexión a la base de datos

    static {
        try {
            // Establece la conexión a la base de datos MySQL con los parámetros especificados (URL, usuario, clave)
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matrizdb", "root", "drbermeo");
        } catch (SQLException e) {
            // Muestra el error si la conexión falla
            e.printStackTrace();
        }
    }
    // Método sincronizado para insertar un registro en la tabla 'sumas_filas'
    public static synchronized void insertarRegistro(String nombreHilo, int indiceFila, String valoresFila, int sumaFila) {
        // Consulta SQL para insertar los valores en la tabla
        String sql = "INSERT INTO sumas_filas "
                + "(nombre_hilo, indice_fila, valores_fila, suma_fila) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) { // Prepara la consulta SQL
            ps.setString(1, nombreHilo);      // Establece el nombre del hilo
            ps.setInt(2, indiceFila);         // Establece el índice de la fila
            ps.setString(3, valoresFila);     // Establece los valores de la fila como texto
            ps.setInt(4, sumaFila);           // Establece la suma de la fila
            ps.executeUpdate();               // Ejecuta la consulta para insertar los datos
        } catch (SQLException e) {
            // Muestra el error si la inserción falla
            e.printStackTrace();
        }
    }

    // Método para cerrar la conexión con la base de datos
    public static void cerrar() {
        try {
            // Verifica si la conexión está activa y la cierra
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            // Muestra el error si ocurre al cerrar la conexión
            e.printStackTrace();
        }
    }
}
