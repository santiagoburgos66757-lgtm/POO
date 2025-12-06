package Vista;

import Controllers.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroVista extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtCedula;
    private JTextField txtEdad;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreoElectronico;
    private JTextField txtContraseña;
    private JButton btnRegistrar;
    public JPanel panel2;
    private Inicio inicio;

    public RegistroVista() {
        this.inicio = inicio;
        setTitle("Registro");
        setContentPane(panel2);
        setTitle("Formulario 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);// Tamaño opcional

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellidos.getText();
                int cedula = Integer.parseInt(txtCedula.getText());
                String direccion = txtDireccion.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String correoElectronico = txtCorreoElectronico.getText();
                String telefono = txtTelefono.getText();
                String contraseña = txtContraseña.getText();

                UsuarioCliente usuCliente = new UsuarioCliente();
                usuCliente.Resgistro(nombre,apellido,contraseña,correoElectronico,cedula,telefono,edad,direccion);
                setVisible(false);




            }
        });

    }
}
