package Conexion;
/**
 * Importación de las librerias necesarias para la conexion.
 */
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.*;
import javax.swing.*;

/**
 * @author Enzocv
 * @author Andrei
 */
public class Conexion_BD {
    private static Connection conexion_Mysql = null;
    private static int puerto = 3306;
    private static String nombreBaseDeDatos = "db_reportes";
    private static String usuario = "root";
    private static String contraseña = "";
    
    public Connection getConnection(){
        try {
           
           MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
           
           //Servidor al que nos conectaremos
           ds.setServerName("localhost");
           //Puerto que usa la Base de Datos
           ds.setPort(puerto);
           //Nombre de la Base de Datos
           ds.setDatabaseName(nombreBaseDeDatos);
           //Usuario y contraseña
           conexion_Mysql = ds.getConnection(usuario,contraseña);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión a la BD: "
                                                + e.getMessage());
        }
        return conexion_Mysql;
    }
}
