package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FuentePoder;
import BL.FuentePoderBL;

public class IngresarFuentePoder extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtCantidadSATA, jtCantidadPCIe, jtAlto, jtAncho, jtPotencia; 
    JButton jbGuardar, jbCancelar;
    
    public IngresarFuentePoder ()
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
        jlEtiqueta=new JLabel("Cantidad de conectores SATA:");
        jlEtiqueta.setBounds(20, 100, 250, 40);
        add(jlEtiqueta);
        jtCantidadSATA = new JTextField("");
        jtCantidadSATA.setBounds(240, 100, 100, 40);
        add(jtCantidadSATA);
        jlEtiqueta=new JLabel("Cantidad de conectores PCIe:");
        jlEtiqueta.setBounds(20, 150, 250, 40);
        add(jlEtiqueta);
        jtCantidadPCIe = new JTextField("");
        jtCantidadPCIe.setBounds(240, 150, 100, 40);
        add(jtCantidadPCIe);
        jlEtiqueta=new JLabel("Altura(cm):");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jtAlto = new JTextField("");
        jtAlto.setBounds(100, 200, 100, 40);
        add(jtAlto);
        jlEtiqueta=new JLabel("Ancho(cm):");
        jlEtiqueta.setBounds(220, 200, 200, 40);
        add(jlEtiqueta);
        jtAncho = new JTextField("");
        jtAncho.setBounds(300, 200, 100, 40);
        add(jtAncho);
        jlEtiqueta=new JLabel("Potencia(W):");
        jlEtiqueta.setBounds(20, 250, 200, 40);
        add(jlEtiqueta);
        jtPotencia = new JTextField("");
        jtPotencia.setBounds(120, 250, 100, 40);
        add(jtPotencia);
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(400, 330, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(300, 330, 100, 45);
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
            FuentePoderBL bl = new FuentePoderBL();
            FuentePoder fuenteP = new FuentePoder();
            fuenteP.SetDescripcion(jtDescripcion.getText());
            fuenteP.SetCantidadConectoresSATA(Integer.parseInt(jtCantidadSATA.getText()));
            fuenteP.SetCantidadConectoresPCIe(Integer.parseInt(jtCantidadPCIe.getText()));
            fuenteP.SetPotencia(Double.parseDouble(jtCantidadPCIe.getText()));
            fuenteP.SetAltura(Double.parseDouble(jtAlto.getText()));
            fuenteP.SetAncho(Double.parseDouble(jtAncho.getText()));
            if (bl.IngresarFuentePoder(fuenteP))
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
        jtCantidadSATA.setText("");
        jtCantidadPCIe.setText("");
        jtAlto.setText("");
        jtAncho.setText("");
        jtPotencia.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarFuentePoder ingr = new IngresarFuentePoder();
        ingr.setBounds(0, 0, 500, 400);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
