package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.CPU;
import BL.CpuBL;

public class ActualizarCPU extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtId, jtDescripcion, jtIdSocket, jtConsumoEnergia;
    JButton jbGuardar, jbCancelar, jbBuscar;
    
    public ActualizarCPU ()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Actualizar");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(170, 10, 200, 40);
        add(jlEtiqueta);
        
        jlEtiqueta=new JLabel("ID:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtId = new JTextField("");
        jtId.setBounds(50, 50, 100, 40);
        add(jtId);
        
        jlEtiqueta=new JLabel("Descripcion:");
        jlEtiqueta.setBounds(20, 100, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(120, 100, 200, 40);
        add(jtDescripcion);
        
        jlEtiqueta=new JLabel("ID de Socket: ");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtIdSocket = new JTextField("");
        jtIdSocket.setBounds(120, 150, 50, 40);
        add(jtIdSocket);
        jbBuscar = new JButton ("Buscar...");
        jbBuscar.setBounds(180, 150, 100, 45);
        add(jbBuscar);
        jbBuscar.addActionListener(this);
        
        jlEtiqueta=new JLabel("Consumo de Energía(W):");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jtConsumoEnergia = new JTextField("");
        jtConsumoEnergia.setBounds(180, 200, 100, 40);
        add(jtConsumoEnergia);
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(300, 280, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(200, 280, 100, 45);
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
            CpuBL bl = new CpuBL();
            cpu.SetID(Integer.parseInt(jtId.getText()));
            cpu.SetDescripcion(jtDescripcion.getText());
            cpu.SetIdSocket(Integer.parseInt(jtIdSocket.getText()));
            cpu.SetConsumoEnergetico(Double.parseDouble(jtConsumoEnergia.getText()));
            if (bl.ActualizarCPU(cpu))
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
       jtIdSocket.setText("");
       jtConsumoEnergia.setText("");   
    }
    
    public static void Cargar ()
    {
        ActualizarCPU act = new ActualizarCPU();
        act.setBounds(0, 0, 400, 350);
        act.setLocationRelativeTo(null);
        act.setVisible(true);
    }
}
