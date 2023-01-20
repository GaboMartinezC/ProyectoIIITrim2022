package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Case;
import BL.CaseBL;
import java.util.ArrayList;

public class VerTodoCase extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoCase ()
    {
        try
        {
            setLayout(null);
            CaseBL bl = new CaseBL();
            ArrayList<Case> listaCase = new ArrayList<Case>();
            listaCase = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","ID Factor de Forma","Adaptado para liquido"};
            Object datos[][] = LlenarMatriz(listaCase);            
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
    
    private Object [][] LlenarMatriz (ArrayList<Case> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][4];
        for (Case c: lista)
        {
            datos [contador] [0] = c.GetID();
            datos [contador] [1] = c.GetDescripcion();
            datos [contador] [2] = c.GetIdFactorForma();
            if (c.GetRefrigeracionLiquida())
                datos [contador] [3] = "SI";
            else
                datos [contador] [3] = "NO";
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        VerTodoCase verT = new VerTodoCase();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
        
    }
}
