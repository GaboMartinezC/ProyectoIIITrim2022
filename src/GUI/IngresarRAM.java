package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.RAM;
import BL.RamBL;

public class IngresarRAM extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtVersionDDR, jtCapacidad, jtConsumoEnergia;
    JButton jbGuardar, jbCancelar;
    
    public IngresarRAM ()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Ingreso");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(170, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 50, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("DDR:");
        jlEtiqueta.setBounds(20, 100, 100, 40);
        add(jlEtiqueta);
        jtVersionDDR = new JTextField("");
        jtVersionDDR.setBounds(60, 100, 100, 40);
        add(jtVersionDDR);
        jlEtiqueta=new JLabel("Capacidad(Gb):");
        jlEtiqueta.setBounds(180, 100, 200, 40);
        add(jlEtiqueta);
        jtCapacidad = new JTextField("");
        jtCapacidad.setBounds(290, 100, 100, 40);
        add(jtCapacidad);
        jlEtiqueta=new JLabel("Consumo de Energía(W):");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtConsumoEnergia = new JTextField("");
        jtConsumoEnergia.setBounds(200, 150, 100, 40);
        add(jtConsumoEnergia);
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(300, 230, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(200, 230, 100, 45);
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
            RAM ram = new RAM();
            RamBL bl = new RamBL();
            ram.SetDescripcion(jtDescripcion.getText());
            ram.SetVersionDDR(Integer.parseInt(jtVersionDDR.getText()));
            ram.SetCapacidad(Integer.parseInt(jtCapacidad.getText()));
            ram.SetConsumoEnergia(Double.parseDouble(jtConsumoEnergia.getText()));
            if (bl.IngresarRAM(ram))
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
       jtVersionDDR.setText("");
       jtCapacidad.setText("");
       jtConsumoEnergia.setText("");   
    }
    
    public static void Cargar ()
    {
        IngresarRAM ingr = new IngresarRAM();
        ingr.setBounds(0, 0, 400, 300);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
