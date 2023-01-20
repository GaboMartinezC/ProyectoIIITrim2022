package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Enfriamiento;
import BL.EnfriamientoBL;
import java.util.ArrayList;

public class VerTodoEnfriamiento extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    
    public VerTodoEnfriamiento ()
    {
        try
        {
            setLayout(null);
            EnfriamientoBL bl = new EnfriamientoBL();
            ArrayList<Enfriamiento> listaEnfriamiento = new ArrayList<Enfriamiento>();
            listaEnfriamiento = bl.BuscarTodos();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Ver Todos");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Descripcion","ID de Socket","Refrigeracion Liquida"};
            Object datos[][] = LlenarMatriz(listaEnfriamiento);            
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
    
    private Object [][] LlenarMatriz (ArrayList<Enfriamiento> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][4];
        for (Enfriamiento e: lista)
        {
            datos [contador] [0] = e.GetID();
            datos [contador] [1] = e.GetDescripcion();
            datos [contador] [2] = e.GetIdSocket();
            if (e.GetLiquido())
                datos [contador] [3] = "SI";
            else
                datos [contador] [3] = "NO";
            contador++;
        }
        return datos;
    }
    
    public static void Cargar () 
    {
        VerTodoEnfriamiento verT = new VerTodoEnfriamiento();
        verT.setBounds(0, 0, 500, 250);
        verT.setLocationRelativeTo(null);
        verT.setVisible(true);
        
    }
}
