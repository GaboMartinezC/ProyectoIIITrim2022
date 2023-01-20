package GUI;
import javax.swing.*;
import java.awt.event.*;

public class MenuAdministrativo extends JFrame implements ActionListener 
{
    private JLabel etiqueta;
    
    JMenuBar barraMenu=new JMenuBar();
    
    JMenu jmEmpleado = new JMenu("Empleado");
    
    JMenuItem perNuevo = new JMenuItem("Nuevo");
    JMenuItem perBuscar = new JMenuItem("Buscar");
    JMenuItem perBuscarT = new JMenuItem("Buscar Todos");
    JMenuItem perActualizar = new JMenuItem("Actualizar");
    
    public MenuAdministrativo()
    {
        //obli
        setLayout(null);
        setJMenuBar (barraMenu);
        barraMenu.add(jmEmpleado);
        jmEmpleado.add(perNuevo);
        perNuevo.addActionListener(this);
        jmEmpleado.add(perBuscar);
        perBuscar.addActionListener(this);
        jmEmpleado.add(perBuscarT);
        perBuscarT.addActionListener(this);
        jmEmpleado.add(perActualizar);
        perActualizar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==perNuevo)
            IngresarEmpleado.Cargar();
        if (e.getSource()==perActualizar)
            ActualizarEmpleado.Cargar();
        if (e.getSource()==perBuscarT)
            VerTodoEmpleado.Cargar();
        if (e.getSource()==perBuscar)
            BuscarEmpleado.Cargar();
    }

}
