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
    
     public boolean conectarBase(){
        boolean isError = false;
        try{
            conexion = DriverManager.getConnection(url, "root", "");
            if (conexion.isValid(0)) {
                JOptionPane.showMessageDialog(null, "La conexion con la base fue exitosa");
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la conexion a la base de datos\n" + e);
            isError = true;
        }
        return isError;
    }
     
     public boolean iniciarSesion(String User, String Password){
        String user="",pass=""; boolean login;
        
        sql = "SELECT * FROM `Usuarios` WHERE `usuarios`.`Nombre`=" +User+"";
        try{
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            while (result.next()){
                user = result.getNString(1);
                pass = result.getNString(2);
            }
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        if (){
            Resultado = 0;
            }
        else {
        Resultado = 2;
      }
    }
    else
    {
      Resultado = 1;
    }
    return Resultado;
  }   
     
}
