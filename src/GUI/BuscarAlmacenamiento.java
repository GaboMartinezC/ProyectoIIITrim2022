package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Almacenamiento;
import BL.AlmacenamientoBL;
import java.util.ArrayList;

public class BuscarAlmacenamiento extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarAlmacenamiento (String descripcion)
    {
        try
        {
            setLayout(null);
            AlmacenamientoBL bl = new AlmacenamientoBL();
            ArrayList<Almacenamiento> listaAlmacenamiento = new ArrayList<Almacenamiento>();
            listaAlmacenamiento = bl.BuscarAlmacenamiento(descripcion);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","Capcidad","Consumo","M.2","SATA"};
            Object datos[][] = LlenarMatriz(listaAlmacenamiento);            
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
    
    private Object [][] LlenarMatriz (ArrayList<Almacenamiento> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][6];
        for (Almacenamiento a: lista)
        {
            datos [contador] [0] = a.GetID();
            datos [contador] [1] = a.GetDescripcion();
            datos [contador] [2] = a.GetCapacidad();
            datos [contador] [3] = a.GetConsumoEnergia();
            if (a.GetM2())
            {
                datos [contador] [4] = "SI";
                datos [contador] [5] = "NO";
            }
            else
            {
                datos [contador] [4] = "NO";
                datos [contador] [5] = "SI";
            }
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        String descripcion = JOptionPane.showInputDialog("Digite la descripcion del dispositivo de almacenamiento:");
        BuscarAlmacenamiento busc = new BuscarAlmacenamiento(descripcion);
        busc.setBounds(0, 0, 500, 250);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);
        
    }
}

