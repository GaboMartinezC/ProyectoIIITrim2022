package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.GPU;
import BL.GpuBL;

public class ActualizarGPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtId, jtDescripcion, jtConectores, jtConsumo; 
    JRadioButton jrPcie16, jrPcie8;
    JButton jbGuardar, jbCancelar;
    
    public ActualizarGPU()
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
        jtId.setBounds(40, 50, 50, 40);
        add(jtId);
        
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 100, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("Cantidad de Conectores de Alimentacion:");
        jlEtiqueta.setBounds(30, 150, 400, 40);
        add(jlEtiqueta);
        jtConectores = new JTextField("");
        jtConectores.setBounds(330, 150, 50, 40);
        add(jtConectores);
        jlEtiqueta=new JLabel("Consumo(W):");
        jlEtiqueta.setBounds(20, 200, 400, 40);
        add(jlEtiqueta);
        jtConsumo = new JTextField("");
        jtConsumo.setBounds(100, 200, 100, 40);
        add(jtConsumo);
        
        jlEtiqueta=new JLabel("Pcie16:");
        jlEtiqueta.setBounds(20, 250, 200, 40);
        add(jlEtiqueta);
        jrPcie16 = new JRadioButton("",false);
        jrPcie16.setMnemonic(KeyEvent.VK_C);
        jrPcie16.addActionListener(this);
        jrPcie16.setActionCommand("");
        jrPcie16.setBounds(70, 250, 20, 40);
        add(jrPcie16);
        
        jlEtiqueta=new JLabel("Pcie8:");
        jlEtiqueta.setBounds(120, 250, 200, 40);
        add(jlEtiqueta);
        jrPcie8 = new JRadioButton("",true);
        jrPcie8.setMnemonic(KeyEvent.VK_C);
        jrPcie8.addActionListener(this);
        jrPcie8.setActionCommand("");
        jrPcie8.setBounds(165, 250, 20, 40);
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
           gpu.SetID(Integer.parseInt(jtId.getText()));
           gpu.SetDescripcion(jtDescripcion.getText());
           gpu.SetConsumoEnergia(Double.parseDouble(jtConsumo.getText()));
           gpu.SetCantidadConectores(Integer.parseInt(jtConectores.getText()));
           if (jrPcie16.isSelected())
               gpu.SetPcie16(true);
           if (bl.Actualizar(gpu))
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
           else
            JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados no es v??lido");
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
        jtConsumo.setText("");
        jtConectores.setText("");
    }
    
    public static void Cargar ()
    {
        ActualizarGPU act = new ActualizarGPU();
        act.setBounds(0, 0, 500, 350);
        act.setLocationRelativeTo(null);
        act.setVisible(true);
    }
}

