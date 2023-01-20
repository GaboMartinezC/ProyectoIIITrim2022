package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Enfriamiento;
import BL.EnfriamientoBL;

public class IngresarEnfriamiento extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtIdSocket; 
    JCheckBox jcLiquido;
    JButton jbGuardar, jbCancelar, jbBuscar;
    
    public IngresarEnfriamiento()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Ingreso");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(210, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 50, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("ID del Socket:");
        jlEtiqueta.setBounds(20, 100, 250, 40);
        add(jlEtiqueta);
        jtIdSocket = new JTextField("");
        jtIdSocket.setBounds(130, 100, 100, 40);
        add(jtIdSocket);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(250, 100, 100, 45);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        
        jlEtiqueta=new JLabel("Refrigeración Liquida:");
        jlEtiqueta.setBounds(20, 150, 400, 40);
        add(jlEtiqueta);
        jcLiquido = new JCheckBox("",true);
        jcLiquido.setMnemonic(KeyEvent.VK_C);
        jcLiquido.addActionListener(this);
        jcLiquido.setActionCommand("");
        jcLiquido.setBounds(190, 150, 20, 40);
        add(jcLiquido);
        
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 230, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 230, 100, 45);
        add(jbCancelar);
        jbCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbGuardar)
            Guardar();
        if (e.getSource()==jbCancelar)
            Limpiar();
        if (e.getSource()==jbBuscar)
            BuscarSocket.Cargar();
    }
    
    private void Guardar()
    {
        try
        {
           Enfriamiento enfriamiento = new Enfriamiento();
           EnfriamientoBL bl = new EnfriamientoBL();
           enfriamiento.SetDescripcion(jtDescripcion.getText());
           enfriamiento.SetIdSocket(Integer.parseInt(jtIdSocket.getText()));
           if (jcLiquido.isSelected())
               enfriamiento.SetLiquido(true);
           else
               enfriamiento.SetLiquido(false);
           if (bl.Ingresar(enfriamiento))
               JOptionPane.showMessageDialog(null, "Guardado exitoso");
           else
               JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados no es válido");
           Limpiar();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente de nuevo");
            Limpiar();
        }
    }
    
    private void Limpiar()
    {
        jtDescripcion.setText("");
        jtIdSocket.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarEnfriamiento ingr = new IngresarEnfriamiento();
        ingr.setBounds(0, 0, 500, 300);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
