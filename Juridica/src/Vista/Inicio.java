package Vista;
import Controllers.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Inicio  extends JFrame {
    private JTextField txtCorreo;
    private JPasswordField txtContraseña;
    public JPanel panel1;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;



    public Inicio() {
        setTitle("Inicio");
        setContentPane(panel1); // ¡IMPORTANTE! Conecta el diseño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar en pantalla
        setSize(400, 300); // Tamaño opcional

        registrarseButton.addActionListener(new ActionListener() {




            @Override

            public void actionPerformed(ActionEvent e) {

                RegistroVista registroVista = new RegistroVista();
                registroVista.setVisible(true);

            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String correo = txtCorreo.getText();
                char[] contraseñaChars = txtContraseña.getPassword();
                String contraseña = new String(contraseñaChars);
                Login login = new Login();

                if(login.iniciarSesion(correo,contraseña) == true){
                    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
                    paginaPrincipal.setVisible(true);
                }


            }
        });
    }


}
