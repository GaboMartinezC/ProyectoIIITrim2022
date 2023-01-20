package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Empleado;
import BL.EmpleadoBL;
import java.util.ArrayList;

public class VerTodoEmpleado extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoEmpleado ()
    {
        try
        {
            setLayout(null);
            EmpleadoBL bl = new EmpleadoBL();
            ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
            listaEmpleado = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"Cédula","Nombre Completo","Telefono","Correo","Administrador"};
            String datos[][] = LlenarMatriz(listaEmpleado);            
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
    
    private String [][] LlenarMatriz (ArrayList<Empleado> lista)
    {
        int contador = 0;
        String [][] datos = new String [lista.size()][5];
        for (Empleado e: lista)
        {
            datos [contador] [0] = e.GetCedula();
            datos [contador] [1] = e.GetNombreCompleto();
            datos [contador] [2] = e.GetTelefono();
            datos [contador] [3] = e.GetCorreo();
            if (e.GetPuestoAdministrativo())
                datos [contador] [4] = "SI";
            else
                datos [contador] [4] = "NO";
            contador++;
        }
        return datos;
    }
    public static void Cargar () 
    {
        VerTodoEmpleado verT = new VerTodoEmpleado();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);   
    }
}
