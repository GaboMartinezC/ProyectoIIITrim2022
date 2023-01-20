package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.Case;
import BL.CaseBL;

public class ActualizarCase extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtId, jtDescripcion, jtIdFactorForma; 
    JCheckBox jcLiquido;
    JButton jbGuardar, jbCancelar, jbBuscar;
    
    public ActualizarCase()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Actualizar");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(210, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("ID:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtId = new JTextField("");
        jtId.setBounds(50, 50, 50, 40);
        add(jtId);
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 100, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("ID de Factor de Forma:");
        jlEtiqueta.setBounds(20, 150, 250, 40);
        add(jlEtiqueta);
        jtIdFactorForma = new JTextField("");
        jtIdFactorForma.setBounds(190, 150, 100, 40);
        add(jtIdFactorForma);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(300, 150, 100, 45);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        
        jlEtiqueta=new JLabel("Adaptado para refrigeración Liquida:");
        jlEtiqueta.setBounds(20, 200, 400, 40);
        add(jlEtiqueta);
        jcLiquido = new JCheckBox("",true);
        jcLiquido.setMnemonic(KeyEvent.VK_C);
        jcLiquido.addActionListener(this);
        jcLiquido.setActionCommand("");
        jcLiquido.setBounds(290, 200, 20, 40);
        add(jcLiquido);
        
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
        if (e.getSource()==jbBuscar)
            BuscarFactorForma.Cargar();
    }
    
    private void Guardar()
    {
        try
        {
           Case gabinete = new Case();
           CaseBL bl = new CaseBL();
           gabinete.SetID(Integer.parseInt(jtId.getText()));
           gabinete.SetDescripcion(jtDescripcion.getText());
           gabinete.SetIdFactorForma(Integer.parseInt(jtIdFactorForma.getText()));
           if (jcLiquido.isSelected())
               gabinete.SetRefrigeracionLiquida(true);
           else
               gabinete.SetRefrigeracionLiquida(false);
           if (bl.Actualizar(gabinete))
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
        jtId.setText("");
        jtDescripcion.setText("");
        jtIdFactorForma.setText("");
    }
    
    public static void Cargar ()
    {
        ActualizarCase act = new ActualizarCase();
        act.setBounds(0, 0, 500, 350);
        act.setLocationRelativeTo(null);
        act.setVisible(true);
    }
}
