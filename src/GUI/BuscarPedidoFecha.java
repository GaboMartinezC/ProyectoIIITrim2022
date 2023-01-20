package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Ensamblaje;
import BL.EnsamblajeBL;
import java.util.ArrayList;

public class BuscarPedidoFecha extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTable tabla;
    JScrollPane jspContenedor = new JScrollPane();
    JTextField jtId;
    JButton jbBuscar, jbCancelar;
    
    public BuscarPedidoFecha(String fecha)
    {
        try
        {
            setLayout(null);
            EnsamblajeBL bl = new EnsamblajeBL();
            ArrayList<Ensamblaje> listaEnsamblaje = new ArrayList<Ensamblaje>();
            listaEnsamblaje = bl.VerTodoEnsamblaje();
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Consultas");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(450, 5, 200, 40);
            add(jlEtiqueta);
            String[] columnas = {"ID","Empleado","Cliente","Fecha","Cancelado","Confirmado"};
            Object datos[][] = LlenarMatriz(listaEnsamblaje);            
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(20, 40, 500, 400);
            add(jspContenedor);
            jlEtiqueta=new JLabel("ID:");
            jlEtiqueta.setBounds(650, 150, 200, 40);
            add(jlEtiqueta);
            jtId = new JTextField("");
            jtId.setBounds(680, 150, 100, 40);
            add(jtId);
            jbBuscar = new JButton ("Buscar");
            jbBuscar.setBounds(650, 200, 100, 40);
            add(jbBuscar);
            jbBuscar.addActionListener(this);
            jbCancelar = new JButton ("Cancelar");
            jbCancelar.setBounds(750, 200, 100, 40);
            add(jbCancelar);
            jbCancelar.addActionListener(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private Object [][] LlenarMatriz (ArrayList<Ensamblaje> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][6];
        for (Ensamblaje e: lista)
        {
            datos [contador] [0] = e.GetID();
            datos [contador] [1] = e.GetCedulaEmpleado();
            datos [contador] [2] = e.GetCedulaCliente();
            datos [contador] [3] = e.GetFecha();
            if (e.GetCancelado())
            {
                datos [contador] [4] = "SI";
                datos [contador] [5] = "NO";
            }
            else
            {
                datos [contador] [4] = "NO";
                datos [contador] [5] = "SI";
            }                
            if (!e.GetConfirmado())
            {
                datos [contador] [5] = "NO";
            }
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbBuscar)
            CargarBusqueda();
        if (e.getSource()==jbCancelar)
            Limpiar();
    }
    
    private void CargarBusqueda()
    {
        try
        {
            int id = Integer.parseInt(jtId.getText());
            BuscarDetalles.Cargar(id);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente de nuevo");
            Limpiar();
        }
    }
    
    private void Limpiar()
    {
        jtId.setText("");
    }
    
    public static void Cargar (String fecha) 
    {
        BuscarPedidoFecha busc = new BuscarPedidoFecha(fecha);
        busc.setBounds(0, 0, 1000, 500);
        busc.setLocationRelativeTo(null);
        busc.setVisible(true);   
    }
}