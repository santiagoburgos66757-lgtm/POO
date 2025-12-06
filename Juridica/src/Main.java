

import javax.swing.*;
import java.awt.event.ActionListener;
import Coneccion.Coneccion;
import Controllers.Usuario;
import Vista.Inicio;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        // Ejecutar en el EDT de Swing

        Coneccion coneccion = new Coneccion();
        Coneccion.getConnection();


     Inicio inicio = new Inicio();
     inicio.setVisible(true);
    }


}