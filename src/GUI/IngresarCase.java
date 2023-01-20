package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Case;
import BL.CaseBL;

public class IngresarCase extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtIdFactorForma; 
    JCheckBox jcLiquido;
    JButton jbGuardar, jbCancelar, jbBuscar;
    
    public IngresarCase()
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
        jlEtiqueta=new JLabel("ID de Factor de Forma:");
        jlEtiqueta.setBounds(20, 100, 250, 40);
        add(jlEtiqueta);
        jtIdFactorForma = new JTextField("");
        jtIdFactorForma.setBounds(190, 100, 100, 40);
        add(jtIdFactorForma);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(300, 100, 100, 45);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        
        jlEtiqueta=new JLabel("Adaptado para refrigeración Liquida:");
        jlEtiqueta.setBounds(20, 150, 400, 40);
        add(jlEtiqueta);
        jcLiquido = new JCheckBox("",true);
        jcLiquido.setMnemonic(KeyEvent.VK_C);
        jcLiquido.addActionListener(this);
        jcLiquido.setActionCommand("");
        jcLiquido.setBounds(290, 150, 20, 40);
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
            BuscarFactorForma.Cargar();
    }
    
    private void Guardar()
    {
        try
        {
           Case gabinete = new Case();
           CaseBL bl = new CaseBL();
           gabinete.SetDescripcion(jtDescripcion.getText());
           gabinete.SetIdFactorForma(Integer.parseInt(jtIdFactorForma.getText()));
           if (jcLiquido.isSelected())
               gabinete.SetRefrigeracionLiquida(true);
           else
               gabinete.SetRefrigeracionLiquida(false);
           if (bl.Ingresar(gabinete))
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
        jtIdFactorForma.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarCase ingr = new IngresarCase();
        ingr.setBounds(0, 0, 500, 300);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
