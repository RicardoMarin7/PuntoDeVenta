package puntodeventa;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
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
        String user="",pass=""; boolean login = false;
        
        sql = "SELECT * FROM `usuarios` WHERE `usuarios`.`Nombre` = '"+User+"'";
        try{
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            while (result.next()){
                user = result.getString(2);
                pass = result.getString(4);
            }
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        if (user.equals(User) && pass.equals(Password)){
                login=true;
                sesionIniciada(user,pass);
            }
        else {
            login = false;
        }
        
        return login;
    }
     
     public int sesionIniciada(String User,String Password){
         int id_sesion=0;
         sql = "SELECT * FROM `usuarios` WHERE `usuarios`.`Nombre` = '"+User+"'";
         try{
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            while (result.next()){
                id_sesion = result.getInt(1);
            }
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return id_sesion;

     }
     
     public boolean isNumeric(String cadena){
         boolean numeric = false;
         try{
             Integer.parseInt(cadena);
             numeric = true;
         }catch(NumberFormatException e){
             numeric = false;
         }
         
         return numeric;
     }
     
     public boolean añadirProducto(String Nombre,String Precio){
         boolean add=false;
         sql = "INSERT INTO `productos` (`ID_Producto`, `Nombre_Producto`, `Precio`, `Descripcion`) VALUES (NULL,'"
                 +Nombre+"','"+Precio+"')";
         try{
            PreparedStatement us = conexion.prepareStatement(sql);
            us.executeUpdate();
            add=true;
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e);
             add=false;
         }
         return add;
     }
     
     public static TableModel consultarProductos(){
        String[] columna = { "ID","Nombre del Producto", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
        }          
        };
        try{
            Object[] datos = new Object[3];
            sql = "SELECT * FROM `productos`";
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            
            while (result.next()){
                for (int i = 0; i < 3; i++) {
                    datos[i] = result.getObject(i + 1);
                }
                modelo.addRow(datos);
            }
            
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return modelo;
    }

    public boolean modificarProducto(String ID,String Nombre, String Precio) {
        boolean update = false;
       sql = "UPDATE `productos` SET `Nombre_Producto` = '"+Nombre+"', `Precio` = '"+Precio+"' WHERE `productos`.`ID_Producto` ="+ID;
        try{
          PreparedStatement us = conexion.prepareStatement(sql);
          us.executeUpdate();
          update = true;
        }
        catch (SQLException e){
          JOptionPane.showMessageDialog(null, e);
          update = false;
        }
        return update;
    }
    
    public static TableModel buscarProductos(String cadena){
        String[] columna = { "ID","Nombre del Producto", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
        }          
        };
        try{
            Object[] datos = new Object[3];
            sql = "SELECT * FROM `productos` WHERE `Nombre_Producto` LIKE '"+cadena+"%'";
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            
            while (result.next()){
                for (int i = 0; i < 3; i++) {
                    datos[i] = result.getObject(i + 1);
                }
                modelo.addRow(datos);
            }
            
            result.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        
        return modelo;
    }
    
    public static boolean borrarProducto(String ID) {
        boolean update = false;
        sql = "DELETE FROM `productos` WHERE `productos`.`ID_Producto` = '"+ID+"'";
        try{
          PreparedStatement us = conexion.prepareStatement(sql);
          us.executeUpdate();
          update = true;
        }
        catch (SQLException e){
          JOptionPane.showMessageDialog(null, e);
          update = false;
        }
        return update;
    }
    
    public static boolean crearOrden(String nombre){
        boolean create=false;
        sql = "INSERT INTO `ordenes` (`ID_orden`, `Nombre_cliente`, `Fecha_orden`, `Pagado`) VALUES (NULL, '"+nombre+"', CURRENT_TIMESTAMP, '0')";
        try{
            PreparedStatement us = conexion.prepareStatement(sql);
            us.executeUpdate();
            create=true;
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e);
             create=false;
         }
        
        return create;
    }
    
    public static TableModel consultarOrdenes(){
        String[] columna = { "ID","Nombre", "Fecha","Pagado"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
        }          
        };
        try{
            Object[] datos = new Object[4];
            sql = "SELECT * FROM `ordenes`";
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            Date fecha = new Date(0);
            Timestamp ts = new Timestamp(fecha.getTime());
            
            while (result.next()){
                for (int i = 0; i < 4; i++) {
                    datos[i] = result.getObject(i + 1);
                }
                modelo.addRow(datos);
            }
            
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return modelo;
    }
    
    
}
