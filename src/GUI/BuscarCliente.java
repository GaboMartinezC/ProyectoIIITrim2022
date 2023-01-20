package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Cliente;
import BL.ClienteBL;

public class BuscarCliente extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarCliente (String cedula)
    {
        try
        {
            setLayout(null);
            ClienteBL bl = new ClienteBL();
            Cliente cliente = new Cliente();
            cliente = bl.BuscarCliente(cedula);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"Cédula","Nombre Completo","Telefono","Correo"};
            String [][] datos = {{cliente.GetCedula(),cliente.GetNombreCompleto(),
                                cliente.GetTelefono(),cliente.GetCorreo()}};
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(50, 40, 400, 200);
            add(jspContenedor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {}
    
    public static void Cargar () 
    {
        String cedula = JOptionPane.showInputDialog("Digite la cedula:");
        BuscarCliente busc = new BuscarCliente(cedula);
        busc.setBounds(0, 0, 500, 250);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);   
    }
}
