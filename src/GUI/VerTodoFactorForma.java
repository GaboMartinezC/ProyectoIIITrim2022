package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FactorForma;
import BL.FactorFormaBL;
import java.util.ArrayList;

public class VerTodoFactorForma extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoFactorForma ()
    {
        try
        {
            setLayout(null);
            FactorFormaBL bl = new FactorFormaBL();
            ArrayList<FactorForma> listaFactorForma = new ArrayList<FactorForma>();
            listaFactorForma = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","Largo","Ancho"};
            Object datos[][] = LlenarMatriz(listaFactorForma);            
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
    
    public static void Cargar () 
    {
        VerTodoFactorForma verT = new VerTodoFactorForma();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
        
    }
}
