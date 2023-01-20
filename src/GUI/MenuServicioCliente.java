package GUI;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MenuServicioCliente extends JFrame implements ActionListener 
{
    private JLabel jlEtiqueta;
    
    JMenuBar barraMenu=new JMenuBar();
    
    JMenu jmCliente = new JMenu("Cliente");
    JMenu jmPedido = new JMenu("Pedidos de Ensamblaje");
    
    JMenuItem perNuevo = new JMenuItem("Nuevo");
    JMenuItem perBuscar = new JMenuItem("Buscar");
    JMenuItem perBuscarT = new JMenuItem("Buscar Todos");
    JMenuItem perActualizar = new JMenuItem("Actualizar");
    JMenuItem pedRealizar = new JMenuItem("Realizar Pedido");
    JMenuItem pedBuscar = new JMenuItem("Buscar Pedido");
    
    public MenuServicioCliente()
    {
        setLayout(null);
        setJMenuBar (barraMenu);
        barraMenu.add(jmCliente);
        barraMenu.add(jmPedido);
        
        jmCliente.add(perNuevo);
        perNuevo.addActionListener(this);
        jmCliente.add(perBuscar);
        perBuscar.addActionListener(this);
        jmCliente.add(perBuscarT);
        perBuscarT.addActionListener(this);
        jmCliente.add(perActualizar);
        perActualizar.addActionListener(this);
        jmPedido.add(pedRealizar);
        pedRealizar.addActionListener(this);
        jmPedido.add(pedBuscar);
        pedBuscar.addActionListener(this);
        
        Font titulos=new Font(null, Font.BOLD,30);
        jlEtiqueta=new JLabel("Servicio al Cliente");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(350, 150, 400, 40);
        add(jlEtiqueta);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //CRUD Cliente
        if (e.getSource()==perNuevo)
            IngresarCliente.Cargar();
        if (e.getSource()==perBuscarT)
            VerTodoCliente.Cargar();
        if (e.getSource()==perBuscar)    
            BuscarCliente.Cargar();
        if (e.getSource()==perActualizar)
            ActualizarCliente.Cargar();
//        //Gestion de Pedidos
        if (e.getSource()==pedRealizar)
            RealizarPedido.Cargar();
        if (e.getSource()==pedBuscar)
            BuscarPedidos.Cargar();
    }
}
