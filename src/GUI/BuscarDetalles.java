package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Detalles;
import BL.*;
import BL.EnsamblajeBL;

public class BuscarDetalles extends JFrame implements ActionListener
{
    private int id;
    EnsamblajeBL blEnsamb= new EnsamblajeBL();
    JLabel jlEtiqueta;
    JButton jbCancPedido, jbConfPedido;
    
    public BuscarDetalles(int id)
    {
        try
        {
            setLayout(null);
            this.id = id;
            Font titulos=new Font(null, Font.BOLD,19);
            jlEtiqueta=new JLabel("Detalles");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(200, 5, 200, 40);
            add(jlEtiqueta);
            DetallesBL bl = new DetallesBL();
            Detalles detalles = bl.BuscarDetallesPedido(this.id);
            String [] datos =  LlenarArreglo(detalles);
            JList lista = new JList(datos);
            lista.setBounds(50, 50, 400, 200);
            add(lista);
            jbCancPedido = new JButton ("Cancelar");
            jbCancPedido.addActionListener(this);
            jbCancPedido.setBounds(50, 300, 100, 45);
            add(jbCancPedido);
            jbConfPedido = new JButton ("Confirmar");
            jbConfPedido.addActionListener(this);
            jbConfPedido.setBounds(170, 300, 100, 45);
            add(jbConfPedido);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private String[] LlenarArreglo (Detalles detalles)
    {
        String tarjetaGrafica, sisEnfriamiento;
        if (detalles.GetIdEnfriamiento()==-1)
            sisEnfriamiento="N/A";
        else
            sisEnfriamiento=""+detalles.GetIdEnfriamiento();
        if (detalles.GetIdGrafica()==-1)
            tarjetaGrafica="N/A";
        else
            tarjetaGrafica=""+detalles.GetIdGrafica();
        String[] datos = 
        {
            "ID: "+detalles.GetIdDetalle(),
            "Pedido: "+id,
            "Placa Madre: "+detalles.GetIdPlacaMadre(),
            "Sistema de Enfriamiento: "+sisEnfriamiento,
            "RAM: "+detalles.GetIdRam(),
            "Cantidad: "+detalles.GetCantidadRam(),
            "Case: "+detalles.GetIdRam(),
            "Tarjeta Gráfica: "+tarjetaGrafica,
            "Almacenamiento: "+detalles.GetUnidadAlmacenamiento(),
            "Cantidad: "+detalles.GetCantidadUnidades(),
            "Fuente de Alimentación: "+detalles.GetIdFuente()
        };
        return datos;
    }
    
    private void Confirmar()
    {
        try
        {
            blEnsamb.ConfirmarPedido(id);
            JOptionPane.showMessageDialog(null, "Pedido Confirmado");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void Cancelar()
    {
        try
        {
            blEnsamb.CancelarPedido(id);
            JOptionPane.showMessageDialog(null, "Pedido Cancelado");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbCancPedido)
            Cancelar();
        if (e.getSource()==jbConfPedido)
            Confirmar();
    }
    
    public static void Cargar (int id) 
    {
        try
        {
            EnsamblajeBL bl = new EnsamblajeBL();
            if (bl.VerTodoEnsamblaje().size()<id)
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente de nuevo");
            else
            {
                BuscarDetalles busc = new BuscarDetalles(id);
                busc.setBounds(0, 0, 500, 500);
                busc.setLocationRelativeTo(null);
                busc.setVisible(true);   
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}