package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FuentePoder;
import BL.FuentePoderBL;
import java.util.ArrayList;

public class BuscarFuentePoder extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarFuentePoder (String descripcion)
    {
       try
       {
            setLayout(null);
            FuentePoderBL bl = new FuentePoderBL();
            ArrayList<FuentePoder> listaFuentePoder = new ArrayList<FuentePoder>();
            listaFuentePoder = bl.BuscarFuentePoder(descripcion);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(300, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","SATA","PCIe", "Potencia","Altura","Ancho"};
            Object datos[][] = LlenarMatriz(listaFuentePoder);           
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(50, 40, 600, 200);
            add(jspContenedor);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
    
    private Object [][] LlenarMatriz (ArrayList<FuentePoder> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][7];
        for (FuentePoder f: lista)
        {
            datos [contador] [0] = f.GetID();
            datos [contador] [1] = f.GetDescripcion();
            datos [contador] [2] = f.GetCantidadConectoresSATA();
            datos [contador] [3] = f.GetCantidadConectoresPCIe();
            datos [contador] [4] = f.GetPotencia();
            datos [contador] [5] = f.GetAltura();
            datos [contador] [6] = f.GetAncho();
            contador++;
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {}
    
    public static void Cargar ()
    {
        String descripcion = JOptionPane.showInputDialog("Digite la descripción de la fuente de poder:");
        BuscarFuentePoder verT = new BuscarFuentePoder(descripcion);
        verT.setBounds(0, 0, 700, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
    }
}
