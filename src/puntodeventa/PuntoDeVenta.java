/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ricardo Marin
 */
public class PuntoDeVenta {
    public static Connection conexion = null;
    public static String url = "jdbc:mysql://localhost/basepuntodeventa";
    public static String sql;
    
     public boolean conectarBase()
  {
    boolean isError = false;
    try
    {
      conexion = DriverManager.getConnection(url, "root", "");
      if (conexion.isValid(0)) {
        JOptionPane.showMessageDialog(null, "La conexion con la base fue exitosa");
      }
    }
    catch (SQLException e)
    {
      JOptionPane.showMessageDialog(null, "Error en la conexion a la base de datos\n" + e);
      isError = true;
    }
    return isError;
  }
    
}
