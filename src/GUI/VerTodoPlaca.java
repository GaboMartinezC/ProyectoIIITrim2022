package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.PlacaMadre;
import BL.PlacaMadreBL;
import java.util.ArrayList;

public class VerTodoPlaca extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoPlaca()
    {
        try
        {
            setLayout(null);
            PlacaMadreBL bl = new PlacaMadreBL();
            ArrayList<PlacaMadre> listaPlaca = new ArrayList<PlacaMadre>();
            listaPlaca = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(450, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","ID Socket","ID FactorForma", "SATA", "PCIe16", "PCIe8", 
                                "DDR", "RAM", "Limite de RAM", "m.2", "Consumo"};
            Object datos[][] = LlenarMatriz(listaPlaca);            
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(20, 40, 950, 400);
            add(jspContenedor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private Object [][] LlenarMatriz (ArrayList<PlacaMadre> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][12];
        for (PlacaMadre p: lista)
        {
            datos [contador] [0] = p.GetID();
            datos [contador] [1] = p.GetDescripcion();
            datos [contador] [2] = p.GetIdFactorForma();
            datos [contador] [3] = p.GetIdSocket();
            datos [contador] [4] = p.GetCantidadSATA();
            datos [contador] [5] = p.GetCantidadPCIe16();
            datos [contador] [6] = p.GetCantidadPCIe8();
            datos [contador] [7] = p.GetVersionDDR();
            datos [contador] [8] = p.GetVersionDDR();
            datos [contador] [9] = p.GetLimiteRAM();
            datos [contador] [10] = p.GetCantidadM2();
            datos [contador] [11] = p.GetConsumoEnergia();
            contador++;
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {}
    
    public static void Cargar () 
    {
        VerTodoPlaca verT = new VerTodoPlaca();
        verT.setBounds(0, 0, 1000, 500);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);   
    }
}
