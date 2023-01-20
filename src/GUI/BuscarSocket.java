package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Socket;
import BL.SocketBL;
import java.util.ArrayList;

public class BuscarSocket extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarSocket (String descripcion)
    {
        try
        {
            setLayout(null);
            //busca la lista de sockets
            SocketBL bl = new SocketBL();
            ArrayList<Socket> lista = new ArrayList<Socket>();
            lista = bl.BuscarSocket(descripcion);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","LGA","PGA"};
            Object datos[][] = LlenarMatriz(lista);        
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
    
    private Object [][] LlenarMatriz (ArrayList<Socket> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][4];
        for (Socket s: lista)
        {
            datos [contador] [0] = s.GetID();
            datos [contador] [1] = s.GetDescripcion();
            if (s.GetLGA())
            {
                datos [contador] [2] = "SI";
                datos [contador] [3] = "NO";
            }
            else
            {
                datos [contador] [2] = "NO";
                datos [contador] [3] = "SI";
            }
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        String descripcion = JOptionPane.showInputDialog("Digite la descripcion del Socket:  ");
        BuscarSocket busc = new BuscarSocket(descripcion);
        busc.setBounds(0, 0, 500, 250);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);
    }
}
