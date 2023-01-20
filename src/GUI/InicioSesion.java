package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import BL.EmpleadoBL;

public class InicioSesion extends JFrame implements ActionListener 
{
    private JLabel jlEtiqueta;
    JButton jbServicioCliente, jbInventario, jbAdministrativo;
    
    public static void ServicioCliente()
    {
        MenuServicioCliente menu = new MenuServicioCliente();
        menu.setBounds(0, 0, 1000, 500);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
    
    public static void Inventario ()
    {
        MenuInventario menu = new MenuInventario();
        menu.setBounds(0, 0, 1000, 500);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
    
    public static void Administrativo ()
    {
        try
        {
            String idCedula = JOptionPane.showInputDialog("Digite la cedula: ");
            EmpleadoBL bl = new EmpleadoBL();
            if (bl.BuscarEmpleado(idCedula).GetPuestoAdministrativo())
            {
                MenuAdministrativo menu = new MenuAdministrativo();
                menu.setBounds(0, 0, 1000, 500);
                menu.setLocationRelativeTo(null);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menu.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Este ID no puede entrar como administrador");
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "OK");
        }
    }
    
    public InicioSesion()
    {
        try
        {
            setLayout(null);
            Font titulos=new Font("Verdana", Font.BOLD,50);
            jlEtiqueta = new JLabel("Inicio");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(320, 100, 200, 40);
            add (jlEtiqueta);

            jbServicioCliente=new JButton("Servicio al Cliente");
            jbServicioCliente.setBounds(50, 300, 200, 40);
            add(jbServicioCliente);
            jbServicioCliente.addActionListener(this);

            jbInventario=new JButton("Inventario");
            jbInventario.setBounds(300, 300, 200, 40);
            add(jbInventario);
            jbInventario.addActionListener(this);

            jbAdministrativo=new JButton("Administracion");
            jbAdministrativo.setBounds(550, 300, 200, 40);
            add(jbAdministrativo);
            jbAdministrativo.addActionListener(this);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbServicioCliente)
        {
            ServicioCliente();
        }
        if (e.getSource()==jbInventario)
        {
            Inventario();
        }
        if (e.getSource()==jbAdministrativo)
        {
            Administrativo();
        }
    }
    
    public static void Cargar ()
    {
        try
        {
            EmpleadoBL bl = new EmpleadoBL();
            if (bl.PrimerIngreso())
            {
                InicioSesion inicio = new InicioSesion();
                inicio.setBounds(0, 0, 800, 600);
                inicio.setLocationRelativeTo(null);
                inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                inicio.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cree una cuenta de administrador y reinicie para poder operar con el sistema");
                IngresarEmpleado.Cargar();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
