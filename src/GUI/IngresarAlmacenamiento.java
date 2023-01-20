package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Almacenamiento;
import BL.AlmacenamientoBL;

public class IngresarAlmacenamiento extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtCapacidad, jtConsumo; 
    JRadioButton jrM2, jrSATA;
    JButton jbGuardar, jbCancelar;
    
    public IngresarAlmacenamiento()
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
        jlEtiqueta=new JLabel("Capacidad(Gb):");
        jlEtiqueta.setBounds(20, 100, 400, 40);
        add(jlEtiqueta);
        jtCapacidad = new JTextField("");
        jtCapacidad.setBounds(120, 100, 50, 40);
        add(jtCapacidad);
        jlEtiqueta=new JLabel("Consumo(W):");
        jlEtiqueta.setBounds(20, 150, 400, 40);
        add(jlEtiqueta);
        jtConsumo = new JTextField("");
        jtConsumo.setBounds(100, 150, 100, 40);
        add(jtConsumo);
        
        jlEtiqueta=new JLabel("SATA:");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jrSATA = new JRadioButton("",false);
        jrSATA.setMnemonic(KeyEvent.VK_C);
        jrSATA.addActionListener(this);
        jrSATA.setActionCommand("");
        jrSATA.setBounds(70, 200, 20, 40);
        add(jrSATA);
        
        jlEtiqueta=new JLabel("M.2:");
        jlEtiqueta.setBounds(120, 200, 200, 40);
        add(jlEtiqueta);
        jrM2 = new JRadioButton("",true);
        jrM2.setMnemonic(KeyEvent.VK_C);
        jrM2.addActionListener(this);
        jrM2.setActionCommand("");
        jrM2.setBounds(165, 200, 20, 40);
        add(jrM2);
        
        
        //Une los botones al bottongroup
        ButtonGroup boton = new ButtonGroup();
        boton.add(jrM2);
        boton.add(jrSATA);
        
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 280, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 280, 100, 45);
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
           AlmacenamientoBL bl = new AlmacenamientoBL();
           Almacenamiento almacenamiento = new Almacenamiento();
           almacenamiento.SetDescripcion(jtDescripcion.getText());
           almacenamiento.SetConsumoEnergia(Double.parseDouble(jtConsumo.getText()));
           almacenamiento.SetCapacidad(Integer.parseInt(jtCapacidad.getText()));
           if (jrM2.isSelected())
               almacenamiento.SetM2(true);
           else
               almacenamiento.SetM2(false);
           if (bl.Ingresar(almacenamiento))
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
        jtCapacidad.setText("");
        jtConsumo.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarAlmacenamiento ingr = new IngresarAlmacenamiento();
        ingr.setBounds(0, 0, 500, 350);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
