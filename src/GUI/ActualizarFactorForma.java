package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.FactorForma;
import BL.FactorFormaBL;

public class ActualizarFactorForma extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtID, jtDescripcion, jtAncho, jtLargo; 
    JButton jbGuardar, jbCancelar, jbBuscar;
    public ActualizarFactorForma()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Actualizar");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(200, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("ID:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtID = new JTextField("");
        jtID.setBounds(120, 50, 100, 40);
        add(jtID);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(250, 50, 100, 40);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 100, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("Ancho(Cm):");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtAncho = new JTextField("");
        jtAncho.setBounds(120, 150, 100, 40);
        add(jtAncho);
        jlEtiqueta=new JLabel("Largo(Cm):");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jtLargo = new JTextField("");
        jtLargo.setBounds(120, 200, 100, 40);
        add(jtLargo);
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
        if (e.getSource()==jbBuscar)
            Buscar();
    }
    
    private void Buscar ()
    {
        BuscarFactorForma.Cargar();
    }
    
    private void Guardar ()
    {
        try
        {
            FactorFormaBL bl = new FactorFormaBL();
            FactorForma factorF = new FactorForma();
            factorF.SetID(Integer.parseInt(jtID.getText()));
            factorF.SetDescripcion(jtDescripcion.getText());
            factorF.SetAncho(Double.parseDouble(jtAncho.getText()));
            factorF.SetLargo(Double.parseDouble(jtLargo.getText()));
            if (bl.ActualizarFactorForma(factorF))
                JOptionPane.showMessageDialog(null, "Actualizado exitoso");
            else
                JOptionPane.showMessageDialog(null, "Alguno de los datos introducidos es inválido");
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
        ActualizarFactorForma actualizar = new ActualizarFactorForma();
        actualizar.setBounds(0, 0, 500, 400);
        actualizar.setLocationRelativeTo(null);
        actualizar.setVisible(true);
    }
}
