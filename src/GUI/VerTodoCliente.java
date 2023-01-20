package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Cliente;
import BL.ClienteBL;
import java.util.ArrayList;

public class VerTodoCliente extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoCliente ()
    {
        try
        {
            setLayout(null);
            ClienteBL bl = new ClienteBL();
            ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
            listaCliente = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"Cédula","Nombre Completo","Telefono","Correo"};
            String datos[][] = LlenarMatriz(listaCliente);            
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
    
    private String [][] LlenarMatriz (ArrayList<Cliente> lista)
    {
        int contador = 0;
        String [][] datos = new String [lista.size()][4];
        for (Cliente c: lista)
        {
            datos [contador] [0] = c.GetCedula();
            datos [contador] [1] = c.GetNombreCompleto();
            datos [contador] [2] = c.GetTelefono();
            datos [contador] [3] = c.GetCorreo();
            contador++;
        }
        return datos;
    }
    public static void Cargar () 
    {
        VerTodoCliente verT = new VerTodoCliente();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);   
    }
}
