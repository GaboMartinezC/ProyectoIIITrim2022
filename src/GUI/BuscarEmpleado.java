package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Empleado;
import BL.EmpleadoBL;
import java.util.ArrayList;

public class BuscarEmpleado extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarEmpleado (String cedula)
    {
        try
        {
            setLayout(null);
            EmpleadoBL bl = new EmpleadoBL();
            ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
            Empleado empleado = bl.BuscarEmpleado(cedula);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"Cédula","Nombre Completo","Telefono","Correo","Administrador"}; 
            String [][] datos = LlenarMatriz(empleado);
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
    
    private String [][] LlenarMatriz (Empleado empleado)
    {
        String [][] datos = new String [1][5];
        datos [0][0] = empleado.GetCedula();
        datos [0][1] = empleado.GetNombreCompleto();
        datos [0][2] = empleado.GetTelefono();
        datos [0][3] = empleado.GetCorreo();
        if (empleado.GetPuestoAdministrativo())
            datos [0][4] = "SI";
        else
            datos [0][4] = "NO";
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {}
    
    public static void Cargar () 
    {
        String cedula = JOptionPane.showInputDialog("Digite la cedula:");
        BuscarEmpleado busc = new BuscarEmpleado(cedula);
        busc.setBounds(0, 0, 500, 250);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);   
    }
}
