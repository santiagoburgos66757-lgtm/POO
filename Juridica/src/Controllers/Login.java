package Controllers;


import Coneccion.Coneccion;

public class Login extends Usuario {


    public boolean iniciarSesion(String email, String password) {

        Coneccion con = new Coneccion();
        if (con.ConsultarLogin(email,password) == true) {
            return true;
        }else {
            return false;
        }


    }

    @Override
    public String getTipoUsuario() {
        return "";
    }
}
