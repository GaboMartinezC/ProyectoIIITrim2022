package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.RAM;
import BL.RamBL;
import java.util.ArrayList;

public class BuscarRAM extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarRAM (String descripcion)
    {
        try
        {
            setLayout(null);
            RamBL bl = new RamBL();
            ArrayList<RAM> listaRAM = new ArrayList<RAM>();
            listaRAM = bl.BuscarRAM(descripcion);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(300, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","DDR","Capacidad", "Consumo"};
            Object datos[][] = LlenarMatriz(listaRAM);           
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
    
    public void actionPerformed(ActionEvent e)
    {}
    
    private Object [][] LlenarMatriz (ArrayList<RAM> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][5];
        for (RAM r: lista)
        {
            datos [contador] [0] = r.GetID();
            datos [contador] [1] = r.GetDescripcion();
            datos [contador] [2] = r.GetVersionDDR();
            datos [contador] [3] = r.GetCapacidad();
            datos [contador] [4] = r.GetConsumoEnergia();
            contador++;
        }
        return datos;
    }
    
    public static void Cargar ()
    {
        String descripcion = JOptionPane.showInputDialog("Digite la descripción de la RAM:");
        BuscarRAM busc = new BuscarRAM(descripcion);
        busc.setBounds(0, 0, 700, 250);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);
    }
}
