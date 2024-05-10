
package lab_tp_012;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Martin
 */
public class Main {

  
    public static void main(String[] args) {
        Connection cn;
        PreparedStatement ps;

        String driver, url, usr, pass, sql;
        //
        driver = "org.mariadb.jdbc.Driver";
        url = "jdbc:mariadb://localhost:3306/lab1_tp10_bd";
        usr = "root";
        pass = "";

        try {
            //cargamos los drivers
            Class.forName(driver);
            //conexión a la BD
            cn = DriverManager.getConnection(url, usr, pass);
            /*
               INICIO SENTENCIAS DML
             */
            //Agregar empleados 
            /*FERRANDO CARLOS*/
            /*sql = "INSERT INTO empleado(dni, apellido, nombre_empleado, acceso, estado) "
                    + "VALUES (12345678,'Gomez','Nicolas',1,true),"
                    + "(98765432,'Aguero','Fernando',2,true),"
                    + "(55666774,'Marcone','Cintia',1,true);";*/
            //Agregar Heramientas
            /*sql = "INSERT INTO herramienta (nombre_h,descripcion,stock,estado)"
                    + "VALUES ('Pico','Usado en terrenos duros, para desbastar y remover piedras',50,true),"
                    + "('Martillo Neumático','Usado para realizar agujeros de grandes dimensioneso demoler',5,true),"
                    + "('Lima Triangular', 'Usada para ajustar ángulos entrantes e inferiores a 90 grados',15,true)";*/
            /*ps = cn.prepareStatement(sql);
            int reg = ps.executeUpdate();
            if (reg > 0) {
                JOptionPane.showMessageDialog(null, "Consulta exitosa!! Cantidad de filas afectadas: " + reg);
            }*/
            //Consultas
            sql = "SELECT * FROM herramienta WHERE stock > 10";
            ps = cn.prepareStatement(sql);
            ResultSet res1 = ps.executeQuery();

            while (res1.next()) {
                System.out.printf("ID ------------------------------ %d%n", res1.getInt("id_Herramienta"));
                System.out.printf("Nombre Herramienta -------------- %s%n", res1.getString("nombre_h"));
                System.out.printf("Descripcion --------------------- %s%n",res1.getString("descripcion"));
                System.out.printf("Stock --------------------------- %d%n",res1.getInt("stock"));
                System.out.printf("Estado -------------------------- %s%n",res1.getBoolean("estado"));
                System.out.println("************************************************************");
            }
            //Borrar logicamente
            //Se obtiene con la Query el primer id 
            int id = 0;
            String sql1 = "SELECT id_empleado FROM empleado LIMIT 1";
            ps = cn.prepareStatement(sql1);
            ResultSet res = ps.executeQuery();
            
            if (res.next()){
                id = res.getInt("id_empleado");//se le asigna al id el primer id_empleado
                System.out.println("id " + id);
            }
            
            //se consulta para actualizar el estado sin conocer el id del empleado
            sql = "UPDATE empleado SET estado = false WHERE id_Empleado = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);//se selecciona el comodin y se le asigna el id
            int reg = ps.executeUpdate();
            if (reg > 0) {
                JOptionPane.showMessageDialog(null, "Consulta exitosa!! Cantidad de filas afectadas: " + reg);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver" + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos" + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
