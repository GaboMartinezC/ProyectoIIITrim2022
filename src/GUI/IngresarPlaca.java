package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import Entidades.PlacaMadre;
import BL.PlacaMadreBL;

public class IngresarPlaca extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtDescripcion, jtIdSocket, jtIdFactorForma, jtLimiteRAM, jtConsumo,
            jtVersionDDR, jtCantidadPCIe16, jtCantidadPCIe8, jtCantidadRAM, jtCantidadM2, jtCantidadSATA;
    JButton jbGuardar, jbCancelar, jbBuscarFactorForma, jbBuscarSocket;
    
    public IngresarPlaca ()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Ingreso");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(450, 20, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("Descripcion: ");
        jlEtiqueta.setBounds(50, 50, 200, 40);
        add(jlEtiqueta);
        jtDescripcion = new JTextField("");
        jtDescripcion.setBounds(150, 50, 200, 40);
        add(jtDescripcion);
        jlEtiqueta=new JLabel("Factor de Forma (ID): ");
        jlEtiqueta.setBounds(50, 100, 200, 40);
        add(jlEtiqueta);
        jtIdFactorForma = new JTextField("");
        jtIdFactorForma.setBounds(210, 100, 50, 40);
        add(jtIdFactorForma);
        jbBuscarFactorForma = new JButton("Buscar...");
        jbBuscarFactorForma.setBounds(270, 100, 100, 40);
        add(jbBuscarFactorForma);
        jbBuscarFactorForma.addActionListener(this);
        jlEtiqueta=new JLabel("Socket (ID): ");
        jlEtiqueta.setBounds(400, 100, 200, 40);
        add(jlEtiqueta);
        jtIdSocket = new JTextField("");
        jtIdSocket.setBounds(490, 100, 50, 40);
        add(jtIdSocket);
        jbBuscarSocket = new JButton("Buscar...");
        jbBuscarSocket.setBounds(550, 100, 100, 40);
        add(jbBuscarSocket);
        jbBuscarSocket.addActionListener(this);
        jlEtiqueta=new JLabel("Consumo de Energía(W): ");
        jlEtiqueta.setBounds(50, 150, 250, 40);
        add(jlEtiqueta);
        jtConsumo = new JTextField("");
        jtConsumo.setBounds(220, 150, 150, 40);
        add(jtConsumo);
        jlEtiqueta=new JLabel("Limite de RAM: ");
        jlEtiqueta.setBounds(450, 150, 150, 40);
        add(jlEtiqueta);
        jtLimiteRAM = new JTextField("");
        jtLimiteRAM.setBounds(560, 150, 200, 40);
        add(jtLimiteRAM);
        jlEtiqueta=new JLabel("Version de DDR: ");
        jlEtiqueta.setBounds(20, 200, 150, 40);
        add(jlEtiqueta);
        jtVersionDDR = new JTextField("");
        jtVersionDDR.setBounds(135, 200, 50, 40);
        add(jtVersionDDR);
        jlEtiqueta=new JLabel("Cantidad de PCIe16: ");
        jlEtiqueta.setBounds(200, 200, 150, 40);
        add(jlEtiqueta);
        jtCantidadPCIe16 = new JTextField("");
        jtCantidadPCIe16.setBounds(350, 200, 50, 40);
        add(jtCantidadPCIe16);
        jlEtiqueta=new JLabel("Cantidad de PCIe8: ");
        jlEtiqueta.setBounds(410, 200, 150, 40);
        add(jlEtiqueta);
        jtCantidadPCIe8 = new JTextField("");
        jtCantidadPCIe8.setBounds(550, 200, 50, 40);
        add(jtCantidadPCIe8);
        jlEtiqueta=new JLabel("Cantidad de RAM: ");
        jlEtiqueta.setBounds(20, 250, 150, 40);
        add(jlEtiqueta);
        jtCantidadRAM = new JTextField("");
        jtCantidadRAM.setBounds(150, 250, 50, 40);
        add(jtCantidadRAM);
        jlEtiqueta=new JLabel("Cantidad de Entradas M.2: ");
        jlEtiqueta.setBounds(210, 250, 200, 40);
        add(jlEtiqueta);
        jtCantidadM2 = new JTextField("");
        jtCantidadM2.setBounds(400, 250, 50, 40);
        add(jtCantidadM2);
        jlEtiqueta=new JLabel("Cantidad de puertos SATA: ");
        jlEtiqueta.setBounds(460, 250, 200, 40);
        add(jlEtiqueta);
        jtCantidadSATA = new JTextField("");
        jtCantidadSATA.setBounds(660, 250, 50, 40);
        add(jtCantidadSATA);
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(900, 430, 100, 45);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(800, 430, 100, 45);
        add(jbCancelar);
        jbCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbBuscarFactorForma)
            BuscarFactorForma.Cargar();
        if (e.getSource()==jbBuscarSocket)
            BuscarSocket.Cargar();
        if (e.getSource()==jbGuardar)
            Guardar();
        if (e.getSource()==jbCancelar)
            Limpiar();
    }
    
    private void Guardar()
    {
        try
        {
            PlacaMadre placa = new PlacaMadre();
            PlacaMadreBL bl = new PlacaMadreBL();
            placa.SetDescripcion(jtDescripcion.getText());
            placa.SetIdSocket(Integer.parseInt(jtIdSocket.getText()));
            placa.SetIdFactorForma(Integer.parseInt(jtIdFactorForma.getText()));
            placa.SetCantidadSATA(Integer.parseInt(jtCantidadSATA.getText()));
            placa.SetCantidadPCIe16(Integer.parseInt(jtCantidadPCIe16.getText()));
            placa.SetCantidadPCIe8(Integer.parseInt(jtCantidadPCIe8.getText()));
            placa.SetVersionDDR(Integer.parseInt(jtVersionDDR.getText()));
            placa.SetCantidadSlotsRAM(Integer.parseInt(jtCantidadRAM.getText()));
            placa.SetLimiteRAM(Integer.parseInt(jtLimiteRAM.getText()));
            placa.SetCantidadM2(Integer.parseInt(jtCantidadM2.getText()));
            placa.SetConsumoEnergia(Double.parseDouble(jtConsumo.getText()));
            if (bl.IngresarPlacaMadre(placa))
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
       jtIdFactorForma.setText("");
       jtCantidadSATA.setText("");
       jtCantidadPCIe16.setText("");
       jtCantidadPCIe8.setText("");
       jtVersionDDR.setText("");
       jtCantidadRAM.setText("");
       jtLimiteRAM.setText("");
       jtCantidadM2.setText("");
       jtConsumo.setText("");
    }
    
    public static void Cargar()
    {
        IngresarPlaca ingr = new IngresarPlaca();
        ingr.setBounds(0, 0, 1000, 500);
        ingr.setLocationRelativeTo(null);
        ingr.setVisible(true);
    }
}