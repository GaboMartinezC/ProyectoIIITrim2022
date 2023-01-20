package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Empleado;
import BL.EmpleadoBL;

public class IngresarEmpleado extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtCedula, jtNombreCompleto, jtTelefono, jtCorreo; 
    JButton jbGuardar, jbCancelar;
    JCheckBox jcbAdministrativo;
    
    public IngresarEmpleado()
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
        jlEtiqueta=new JLabel("Permisos de Administrador:");
        jlEtiqueta.setBounds(20, 250, 400, 40);
        add(jlEtiqueta);
        jcbAdministrativo = new JCheckBox("",false);
        jcbAdministrativo.setMnemonic(KeyEvent.VK_C);
        jcbAdministrativo.addActionListener(this);
        jcbAdministrativo.setActionCommand("");
        jcbAdministrativo.setBounds(220, 250, 20, 40);
        add(jcbAdministrativo);
        
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 330, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 330, 100, 45);
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
            EmpleadoBL bl = new EmpleadoBL();
            Empleado empleado = new Empleado();
            empleado.SetCedula(jtCedula.getText());
            empleado.SetNombreCompleto(jtNombreCompleto.getText());
            empleado.SetTelefono(jtTelefono.getText());
            empleado.SetCorreo(jtCorreo.getText());
            if (jcbAdministrativo.isSelected())
                empleado.SetPuestoAdministrativo(true);
            else
                empleado.SetPuestoAdministrativo(false);
            if (bl.IngresarEmpleado(empleado))
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
        IngresarEmpleado ingr = new IngresarEmpleado();
        ingr.setBounds(0, 0, 500, 400);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
    
}
