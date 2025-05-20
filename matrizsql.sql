CREATE DATABASE matrizdb;
CREATE TABLE sumas_filas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_hilo VARCHAR(50),
    indice_fila INT,
    valores_fila TEXT,
    suma_fila INT
);
select* from sumas_filas;