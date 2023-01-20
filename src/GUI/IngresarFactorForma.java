package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FactorForma;
import BL.FactorFormaBL;

public class IngresarFactorForma extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtAncho, jtLargo; 
    JButton jbGuardar, jbCancelar;
    
    public IngresarFactorForma()
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
        jlEtiqueta=new JLabel("Ancho(Cm):");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtAncho = new JTextField("");
        jtAncho.setBounds(120, 100, 100, 40);
        add(jtAncho);
        jlEtiqueta=new JLabel("Largo(Cm):");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtLargo = new JTextField("");
        jtLargo.setBounds(120, 150, 100, 40);
        add(jtLargo);
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
            FactorFormaBL bl = new FactorFormaBL();
            FactorForma factorF = new FactorForma();
            factorF.SetDescripcion(jtDescripcion.getText());
            factorF.SetAncho(Double.parseDouble(jtAncho.getText()));
            factorF.SetLargo(Double.parseDouble(jtLargo.getText()));
            if (bl.IngresarFactorForma(factorF))
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
        jtAncho.setText("");
        jtLargo.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarFactorForma ingr = new IngresarFactorForma();
        ingr.setBounds(0, 0, 500, 250);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
