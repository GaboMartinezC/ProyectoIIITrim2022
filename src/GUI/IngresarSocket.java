package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Socket;
import BL.SocketBL;

public class IngresarSocket extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion; 
    JRadioButton jrPGA, jrLGA;
    JButton jbGuardar, jbCancelar;
    
    public IngresarSocket()
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
        jlEtiqueta=new JLabel("PGA:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("LGA:");
        jlEtiqueta.setBounds(120, 100, 200, 40);
        add(jlEtiqueta);
        
        
        //Declara los radiobuttons
        jrLGA = new JRadioButton("",true);
        jrLGA.setMnemonic(KeyEvent.VK_C);
        jrLGA.addActionListener(this);
        jrLGA.setActionCommand("");
        jrLGA.setBounds(160, 100, 20, 40);
        add(jrLGA);
        
        jrPGA = new JRadioButton("",false);
        jrPGA.setMnemonic(KeyEvent.VK_C);
        jrPGA.addActionListener(this);
        jrPGA.setActionCommand("");
        jrPGA.setBounds(60, 100, 20, 40);
        add(jrPGA);
        
        //Los une al bottongroup
        ButtonGroup boton = new ButtonGroup();
        boton.add(jrPGA);
        boton.add(jrLGA);
        
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 180, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 180, 100, 45);
        add(jbCancelar);
        jbCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbGuardar)
            Guardar();
        if (e.getSource()==jbCancelar)
            Limpiar();
    }
    
    private void Guardar()
    {
        try
        {
           SocketBL bl = new SocketBL();
           Socket socket = new Socket();
           socket.SetDescripcion(jtDescripcion.getText());
           //si lga está seleccionado, pone el atributo lga como verdadero
           if (jrLGA.isSelected())
            socket.SetLGA(true);
           else
            socket.SetLGA(false);
           if (bl.IngresarSocket(socket))
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
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
    }
    
    public static void Cargar ()
    {
        IngresarSocket ingr = new IngresarSocket();
        ingr.setBounds(0, 0, 500, 250);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
