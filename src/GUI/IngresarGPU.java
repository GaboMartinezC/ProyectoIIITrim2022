package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.GPU;
import BL.GpuBL;

public class IngresarGPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtConectores, jtConsumo; 
    JRadioButton jrPcie16, jrPcie8;
    JButton jbGuardar, jbCancelar;
    
    public IngresarGPU()
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
        jlEtiqueta=new JLabel("Cantidad de Conectores de Alimentacion:");
        jlEtiqueta.setBounds(30, 100, 400, 40);
        add(jlEtiqueta);
        jtConectores = new JTextField("");
        jtConectores.setBounds(330, 100, 50, 40);
        add(jtConectores);
        jlEtiqueta=new JLabel("Consumo(w):");
        jlEtiqueta.setBounds(20, 150, 400, 40);
        add(jlEtiqueta);
        jtConsumo = new JTextField("");
        jtConsumo.setBounds(100, 150, 100, 40);
        add(jtConsumo);
        
        jlEtiqueta=new JLabel("Pcie16:");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jrPcie16 = new JRadioButton("",false);
        jrPcie16.setMnemonic(KeyEvent.VK_C);
        jrPcie16.addActionListener(this);
        jrPcie16.setActionCommand("");
        jrPcie16.setBounds(70, 200, 20, 40);
        add(jrPcie16);
        
        jlEtiqueta=new JLabel("Pcie8:");
        jlEtiqueta.setBounds(120, 200, 200, 40);
        add(jlEtiqueta);
        jrPcie8 = new JRadioButton("",true);
        jrPcie8.setMnemonic(KeyEvent.VK_C);
        jrPcie8.addActionListener(this);
        jrPcie8.setActionCommand("");
        jrPcie8.setBounds(165, 200, 20, 40);
        add(jrPcie8);
        
        
        //Une los botones al bottongroup
        ButtonGroup boton = new ButtonGroup();
        boton.add(jrPcie16);
        boton.add(jrPcie8);
        
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
           GpuBL bl = new GpuBL();
           GPU gpu = new GPU();
           gpu.SetDescripcion(jtDescripcion.getText());
           gpu.SetConsumoEnergia(Double.parseDouble(jtConsumo.getText()));
           gpu.SetCantidadConectores(Integer.parseInt(jtConectores.getText()));
           if (jrPcie16.isSelected())
               gpu.SetPcie16(true);
           if (bl.Ingresar(gpu))
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
        jtConsumo.setText("");
        jtConectores.setText("");
    }
    
    public static void Cargar ()
    {
        IngresarGPU ingr = new IngresarGPU();
        ingr.setBounds(0, 0, 500, 350);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
