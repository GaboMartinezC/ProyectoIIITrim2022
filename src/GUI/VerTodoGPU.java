package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.GPU;
import BL.GpuBL;
import java.util.ArrayList;

public class VerTodoGPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoGPU ()
    {
        try
        {
            setLayout(null);
            GpuBL bl = new GpuBL();
            ArrayList<GPU> listaGPU = new ArrayList<GPU>();
            listaGPU = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","Cant.Alimentacion","Pcie16","Pcie8","Consumo"};
            Object datos[][] = LlenarMatriz(listaGPU);            
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
    
    private Object [][] LlenarMatriz (ArrayList<GPU> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][6];
        for (GPU g: lista)
        {
            datos [contador] [0] = g.GetID();
            datos [contador] [1] = g.GetDescripcion();
            datos [contador] [2] = g.GetCantidadConectores();
            if (g.GetPcie16())
            {
               datos [contador] [3] = "SI";
               datos [contador] [4] = "NO";
            }
            else
            {
               datos [contador] [3] = "NO";
               datos [contador] [4] = "SI";
            }
            datos [contador] [5] = g.GetConsumoEnergia();
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        VerTodoGPU verT = new VerTodoGPU();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
        
    }
}
