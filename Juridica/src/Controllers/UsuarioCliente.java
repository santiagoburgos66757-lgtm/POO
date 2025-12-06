package Controllers;
import Coneccion.Coneccion;

import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class UsuarioCliente extends Usuario {
    private int plan = 1;
    private String tipoUsu = "CLIENTE";

    public int getPlan() {
        return plan;
    }



    public void Resgistro(String nombre, String apellido , String password , String email , int cedula
            , String telefono, int edad , String direccion) {

        Coneccion coneccion = new Coneccion();
        coneccion.RegistrarUsuario(nombre, apellido, password, email, cedula, telefono, edad, direccion,tipoUsu,plan);
        coneccion.registrarlogin(cedula,email,password);

    }

    public String getTipoUsuario() {
       return tipoUsu;
    }
}
