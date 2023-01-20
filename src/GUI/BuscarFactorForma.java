package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FactorForma;
import BL.FactorFormaBL;
import java.util.ArrayList;

public class BuscarFactorForma extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public BuscarFactorForma(ArrayList<FactorForma> consultaFactorForma)
    {
        try 
        {
            setLayout(null);
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Buscar");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","Largo","Ancho"};
            Object datos[][] = LlenarMatriz(consultaFactorForma);            
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(50, 40, 400, 200);
            add(jspContenedor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private Object [][] LlenarMatriz (ArrayList<FactorForma> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][4];
        for (FactorForma f: lista)
        {
            datos [contador] [0] = f.GetID();
            datos [contador] [1] = f.GetDescripcion();
            datos [contador] [2] = f.GetLargo();
            datos [contador] [3] = f.GetAncho();
            contador++;
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {    
    }
    
    public static void Cargar()
    {
        try
        {
            FactorFormaBL bl = new FactorFormaBL();
            ArrayList<FactorForma> lista = new ArrayList<FactorForma>();
            String descripcion = JOptionPane.showInputDialog("Digite la descripción del factor de forma:");
            lista = bl.Buscar(descripcion);
            BuscarFactorForma buscar = new BuscarFactorForma(lista);
            buscar.setBounds(0, 0, 500, 250);
            buscar.setLocationRelativeTo(null);
            buscar.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
