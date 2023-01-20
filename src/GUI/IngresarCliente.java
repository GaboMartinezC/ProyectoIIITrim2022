package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Cliente;
import BL.ClienteBL;

public class IngresarCliente extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtCedula, jtNombreCompleto, jtTelefono, jtCorreo; 
    JButton jbGuardar, jbCancelar;
    
    public IngresarCliente()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Ingreso");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(210, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("Cedula:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtCedula = new JTextField("");
        jtCedula.setBounds(80, 50, 200, 40);
        add(jtCedula);
        jlEtiqueta=new JLabel("Nombre Completo:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtNombreCompleto = new JTextField("");
        jtNombreCompleto.setBounds(160, 100, 200, 40);
        add(jtNombreCompleto);
        jlEtiqueta=new JLabel("Telefono:");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtTelefono = new JTextField("");
        jtTelefono.setBounds(100, 150, 150, 40);
        add(jtTelefono);
        jlEtiqueta=new JLabel("Correo:");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jtCorreo = new JTextField("");
        jtCorreo.setBounds(90, 200, 150, 40);
        add(jtCorreo);
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 230, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 230, 100, 45);
        add(jbCancelar);
        jbCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbGuardar)
            Guardar();
        if (e.getSource()==jbCancelar)
            Limpiar();
    }
    
    private void Guardar()
    {
        try
        {
            ClienteBL bl = new ClienteBL();
            Cliente cliente = new Cliente();
            cliente.SetCedula(jtCedula.getText());
            cliente.SetNombreCompleto(jtNombreCompleto.getText());
            cliente.SetTelefono(jtTelefono.getText());
            cliente.SetCorreo(jtCorreo.getText());
            if (bl.Ingresar(cliente))
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
            else
                JOptionPane.showMessageDialog(null, "La cédula ingresada ya existe");
            Limpiar();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente de nuevo");
            Limpiar();
        }
    }
    
    private void Limpiar()
    {
        jtCedula.setText("");
        jtNombreCompleto.setText("");
        jtTelefono.setText("");
        jtCorreo.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarCliente ingr = new IngresarCliente();
        ingr.setBounds(0, 0, 500, 300);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
    
}
