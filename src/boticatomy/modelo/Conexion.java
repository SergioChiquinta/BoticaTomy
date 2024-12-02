
package boticatomy.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    // Método estático para obtener la conexión a la base de datos
    public static Connection getConexion() {
        try {
            // Cadena de conexión para SQL Server, incluyendo parámetros de conexión
            String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "database=BD_boticatomy;" // Nombre de la base de datos
                    + "user=sa;" // Usuario de la base de datos
                    + "password=elreydelospiratas76;" // Contraseña del usuario de la base de datos
                    + "loginTimeout=30;" // Tiempo de espera para la conexión
                    + "encrypt=true;" // Encriptar la conexión
                    + "TrustServerCertificate=True;"; // Confiar en el certificado del servidor
            
            // Obtener la conexión a la base de datos usando DriverManager
            Connection con = DriverManager.getConnection(conexionUrl);
            return con; // Devolver la conexión establecida
            
        } catch (SQLException ex) {
            // Imprimir cualquier excepción SQL que ocurra
            System.out.println(ex.toString());
            return null; // Devolver null si ocurre una excepción
        }
    }
}
