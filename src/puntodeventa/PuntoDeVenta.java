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
     
     public static String getRole(int id_sesion){
         String role="";
         sql = "SELECT roles.role_name FROM (usuarios INNER JOIN roles ON roles.ID_Role = usuarios.ID_Usuario) WHERE usuarios.ID_Usuario='"+id_sesion+"'";
        try{
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            while (result.next()){
                role = result.getString(1);
            }
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }              
         
         return role;
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
     
     public static boolean isNumeric(String cadena){
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
         sql = "INSERT INTO `productos` (`ID_Producto`, `Nombre_Producto`, `Precio_producto`) VALUES (NULL,'"
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
       sql = "UPDATE `productos` SET `Nombre_Producto` = '"+Nombre+"', `Precio_producto` = '"+Precio+"' WHERE `productos`.`ID_Producto` ="+ID;
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
        sql = "INSERT INTO `ordenes` (`ID_orden`, `Nombre_cliente`, `Fecha_orden`, `Pagado`) VALUES (NULL, '"+nombre+"', now(), '0')";
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
    
    public static TableModel consultarOrdenesHoy(){
        String[] columna = { "ID","Nombre", "Fecha","Pagado"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
        }          
        };
        try{
            Object[] datos = new Object[4];
            sql = "SELECT * FROM `ordenes` WHERE `Fecha_orden` = (SELECT MAX(`Fecha_orden`) FROM `ordenes`)";
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
    
    public static boolean borrarOrden(String ID) {
        boolean update = false,error=true;
        
        sql = "DELETE FROM `filas_orden` WHERE `filas_orden`.`ID_orden` = '"+ID+"'";
        try{
          PreparedStatement us = conexion.prepareStatement(sql);
          us.executeUpdate();
          update = true;
          error = false;
        }
        catch (SQLException e){
          JOptionPane.showMessageDialog(null, e);
          update = false;
          error = true;
        }
        
        if(!error){
           sql = "DELETE FROM `ordenes` WHERE `ordenes`.`ID_orden` = '"+ID+"'";
            try{
                PreparedStatement us = conexion.prepareStatement(sql);
                us.executeUpdate();
                update = true;
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, e);
                update = false;
            } 
        }
        
        return update;
    }
    
    public static boolean añadirAOrden(String IDProducto,String IDOrden,String Cantidad){
        boolean add = false;
        sql = "INSERT INTO `filas_orden` (`ID_orden`, `ID_Producto`, `Cantidad`) VALUES ('"+IDOrden+"','"+IDProducto+"', '"+Cantidad+"')";
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
    
    public static TableModel consultarFilasOrden(String ID){
        String[] columna = { "ID Fila","Nombre Orden", "Nombre Producto","Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
        }          
        };
        try{
            Object[] datos = new Object[4];
            sql = "SELECT filas_orden.ID_FILA,ordenes.Nombre_cliente,productos.Nombre_Producto,filas_orden.Cantidad FROM ((filas_orden INNER JOIN ordenes ON filas_orden.ID_orden = ordenes.ID_orden) INNER JOIN productos ON filas_orden.ID_Producto = productos.ID_Producto) WHERE filas_orden.ID_orden ="+ID;
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            
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
    
    public static TableModel getOrdenACobrar(String ID){
        String[] columna = { "Nombre Orden", "Nombre Producto","Cantidad","Precio Unit"};
        DefaultTableModel modelo = new DefaultTableModel((Object[][])null, columna);
        try{
            Object[] datos = new Object[4];
            sql = "SELECT ordenes.Nombre_cliente,productos.Nombre_Producto,filas_orden.Cantidad,productos.Precio_producto FROM ((filas_orden INNER JOIN ordenes ON filas_orden.ID_orden = ordenes.ID_orden) INNER JOIN productos ON filas_orden.ID_Producto = productos.ID_Producto) WHERE filas_orden.ID_orden ="+ID;
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            
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
    
    public static int getTotal(String ID_Orden){
        int total=0,cantidad,preciounit,aux;
        try{
            Object[] datos = new Object[4];
            sql = "SELECT filas_orden.Cantidad,productos.Precio_producto FROM ((filas_orden INNER JOIN ordenes ON filas_orden.ID_orden = ordenes.ID_orden) INNER JOIN productos ON filas_orden.ID_Producto = productos.ID_Producto) WHERE filas_orden.ID_orden ="+ID_Orden;
            PreparedStatement us = conexion.prepareStatement(sql);
            ResultSet result = us.executeQuery();
            
            while (result.next()){
                for (int i = 0; i < 2; i++) {
                    datos[i] = result.getObject(i + 1);
                }
                cantidad = Integer.valueOf(String.valueOf(datos[0]));
                preciounit = Integer.valueOf(String.valueOf(datos[1]));
                aux = cantidad * preciounit;
                total+= aux;
            }
            
            result.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return total;
    }
    
    
    public static boolean cobrarOrden(String ID_orden){
        int total = getTotal(ID_orden);
        boolean update = false;
       sql = "UPDATE `ordenes` SET `Pagado` = '"+1+"', `Total` = '+"+total+"' WHERE `ordenes`.`ID_orden` = "+ID_orden;
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
}
