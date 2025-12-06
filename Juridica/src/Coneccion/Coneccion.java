package Coneccion;

import Controllers.Usuario;

import java.sql.*;
import java.sql.Statement;
import java.util.Objects;

public class Coneccion extends Usuario
{
    static String URL = "jdbc:mysql://localhost:3306/bd_juridica";
    static String USER = "root";
    static String PASSWORD = "";
     Statement stmt;



    public static Connection getConnection(){

        Connection conexion = null;



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            System.out.println("error 2");
        }

            return  conexion;
    }

    public void RegistrarUsuario( String nombre, String apellido , String password , String email , int cedula, String telefono, int edad, String direccion, String tipoUsu, int plan) {



        String sql = "INSERT INTO usuario(cedula,nombre,apellido,email,telefono,direccion,edad,contraseña,tipousuario,plan) " +
                "VALUES ('"+cedula+"','"+nombre+"','"+apellido+"','"+email+"','"+telefono+"','"+direccion+"','"+edad+"','"+password+"','"+tipoUsu+"','"+plan+"')";

        int result;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
                System.out.println("Usuario registrado correctamente");


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public void registrarlogin(int cedula, String email, String contraseña){

        String sql = "INSERT INTO login(cedula,emailUsu,contraseñaUsu) " +
                "VALUES ('"+cedula+"','"+email+"','"+contraseña+"')";

        int result;


        try{

            stmt = getConnection().createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Usuario registrado correctamente");


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean  ConsultarLogin(String emailUsu, String contraseñaUsu){

        boolean respuesta = false;

        String sql = "SELECT * FROM bd_juridica.login where emailUsu ='"+emailUsu +"'";

        ResultSet result;



        try{

            stmt = getConnection().createStatement();
            result = stmt.executeQuery(sql);

            if (result.next()) {
                email = result.getString("emailUsu");
                contraseña = result.getString("contraseñaUsu");
                System.out.println(email +" "+ contraseña );
                if(email.equals(emailUsu))  {

                    if(Objects.equals(contraseñaUsu, contraseña)) {
                        System.out.println("Inicio de sesion correcto");

                        respuesta = true;
                    } else {
                        System.out.println("Contraseña Incorrecta");

                    }
                } else {
                    System.out.println("Email Incorrecto");


                }
            }else {
                System.out.println("Usuario no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

return respuesta;

    }


    @Override
    public String getTipoUsuario() {
        return "";
    }
}
