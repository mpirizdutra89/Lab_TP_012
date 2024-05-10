/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_tp_012;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
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
            /*sql = "SELECT * FROM herramienta WHERE stock > 10";
            ps = cn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                System.out.printf("ID ------------------------------ %s%n", res.getInt("id_Herramienta"));
                System.out.printf("Nombre Herramienta -------------- %s%n", res.getString("nombre_h"));
                System.out.printf("Descripcion --------------------- %s%n",res.getString("descripcion"));
                System.out.printf("Stock --------------------------- %s%n",res.getInt("stock"));
                System.out.printf("ID ------------------------------ %s%n",res.getBoolean("estado"));
                System.out.println("************************************************************");
            }*/
            //Borrar logicamente
            int id = 0;
            String sql1 = "SELECT id_empleado FROM empleado LIMIT 1";
            ps = cn.prepareStatement(sql1);
            ResultSet res = ps.executeQuery();
            //id = res.getInt("id_empleado");
            if (res.next()){
                id = res.getInt("id_empleado");
                System.out.println("id " + id);
            }
            System.out.println(id);
            
            sql = "UPDATE empleado SET estado = true WHERE id_Empleado = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
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
