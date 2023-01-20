package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.CPU;
import BL.CpuBL;
import java.util.ArrayList;

public class VerTodoCPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoCPU ()
    {
        try
        {
            setLayout(null);
            CpuBL bl = new CpuBL();
            ArrayList<CPU> listaCPU = new ArrayList<CPU>();
            listaCPU = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","ID Socket","Consumo"};
            Object datos[][] = LlenarMatriz(listaCPU);            
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
    
    private Object [][] LlenarMatriz (ArrayList<CPU> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][4];
        for (CPU c: lista)
        {
            datos [contador] [0] = c.GetID();
            datos [contador] [1] = c.GetDescripcion();
            datos [contador] [2] = c.GetIdSocket();
            datos [contador] [3] = c.GetConsumoEnergetico();
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        VerTodoCPU verT = new VerTodoCPU();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
        
    }
}
