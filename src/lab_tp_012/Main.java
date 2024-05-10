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
        int reg;
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
            //Agregar un empleado
            sql = "INSERT INTO empleado(dni, apellido, nombre_empleado, acceso, estado) "
                    + "VALUES (12345678,'Gomez','Nicolas',1,true),"
                    + "(98765432,'Aguero','Fernando',2,true),"
                    + "(55666774,'Marcone','Cintia',1,true);";
            ps = cn.prepareStatement(sql);
            reg = ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos" + ex.getMessage());
        }

    }

}
