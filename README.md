# Lab_TP_012

Hay un archivo libs.rar dejar el .jar en la raiz del libs y borrar libs .rar y su carpta
solo quede una carpeta libs


configuracions 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

 public static Connection conec = null;
 private static final String host = "jdbc:mysql://localhost/";
 private static final String user = "root";
 private static final String pass = "nicolas89";
 private static  String bd= "prueba";
 private static final String driver="com.mysql.cj.jdbc.Driver";
 public static ArrayList<String> msjError=new ArrayList<String>();



public static boolean getConeccion() {
        boolean res = false;
        if (servicioMysql()) {
            if (servicioMysql()) {

                try {
                    Class.forName(driver);
                    conec = DriverManager.getConnection(host + bd, user, pass);
                    res = true;
                } catch (NullPointerException | SQLException | ClassNotFoundException ex) {
                    res = false;
                    msjError.add("fallo de coneccion:" + ex.getMessage());
                }
            }
        }
        else{
            msjError.add("");
        }
        return res;

    }

public static boolean getDesconexion(){
        boolean result;
        try {
            conec.close();
           // System.out.println("desconectado");
            conec=null;
            result=true;
        } catch (NullPointerException | SQLException ex) {
             
              msjError.add("fallo la desconexion: "+ex.getMessage());
             result=false;
        }
        return result;
    }


    public static ResultSet consulta(String sql) {
        ResultSet res = null;
        if (getConeccion()) {

            Statement stmt;

            try {
                stmt = conec.createStatement();
                res = stmt.executeQuery(sql);
               
              
            } catch (SQLException ex) {
                
                 msjError.add("fallo la consulta: "+ex.getMessage());
            }
            
        }
        return res;
    }

        public static int actualizar(String sql) {
        int res = -1;
        if (getConeccion()) {

            Statement stmt;

            try {
                stmt = conec.createStatement();
                res = stmt.executeUpdate(sql);

            } catch (SQLException ex) {
              
                  msjError.add("fallo la actualizacion: "+ex.getMessage());
            }
            getDesconexion();
        }
        return res;
    }
      
 
