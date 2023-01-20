package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.CPU;
import BL.CpuBL;

public class IngresarCPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtIdSocket, jtConsumoEnergia;
    JButton jbGuardar, jbCancelar, jbBuscar;
    
    public IngresarCPU ()
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
        
        jlEtiqueta=new JLabel("ID de Socket: ");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtIdSocket = new JTextField("");
        jtIdSocket.setBounds(120, 100, 50, 40);
        add(jtIdSocket);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(180, 100, 100, 45);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        
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
        if (e.getSource()==jbBuscar)
            BuscarSocket.Cargar();
    }
    
    private void Guardar()
    {
        try
        {
            CPU cpu = new CPU();
            cpu.SetDescripcion(jtDescripcion.getText());
            cpu.SetIdSocket(Integer.parseInt(jtIdSocket.getText()));
            cpu.SetConsumoEnergetico(Double.parseDouble(jtConsumoEnergia.getText()));
            CpuBL bl = new CpuBL();
            if (bl.IngresarCPU(cpu))
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
       jtIdSocket.setText("");
       jtConsumoEnergia.setText("");   
    }
    
    public static void Cargar ()
    {
        IngresarCPU ingr = new IngresarCPU();
        ingr.setBounds(0, 0, 400, 300);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}
