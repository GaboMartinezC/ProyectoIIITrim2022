package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.Calendar;
import Entidades.Ensamblaje;
import Entidades.Detalles;
import BL.EnsamblajeBL;
import BL.DetallesBL;

public class RealizarPedido extends JFrame implements ActionListener
{
    JLabel jlEtiqueta;
    JTextField jtCedulaCliente, jtCedulaEmpleado, jtPlaca, jtProcesador, jtEnfriamiento, jtRAM,
            jtCantRAM, jtAlmacenamiento, jtCantAlmacenamiento, jtGrafica, jtCase, jtFuente;
    JButton jbGuardar, jbCancelar,jbBuscarPlaca, jbBuscarProcesador, jbBuscarEnfriamiento,
            jbBuscarRAM, jbBuscarAlmacenamiento, jbBuscarGrafica,jbBuscarCase, jbBuscarFuente;
    
    public RealizarPedido()
    {
        setLayout(null);
        Font titulos=new Font(null, Font.BOLD,19);
        jlEtiqueta=new JLabel("Realizar Pedido");
        jlEtiqueta.setFont(titulos);
        jlEtiqueta.setBounds(220, 10, 200, 40);
        add(jlEtiqueta);
        jlEtiqueta=new JLabel("Cliente:");
        jlEtiqueta.setBounds(20, 50, 200, 40);
        add(jlEtiqueta);
        jtCedulaCliente = new JTextField("");
        jtCedulaCliente.setBounds(90, 50, 100, 40);
        add(jtCedulaCliente);
        jlEtiqueta=new JLabel("Empleado:");
        jlEtiqueta.setBounds(200, 50, 200, 40);
        add(jlEtiqueta);
        jtCedulaEmpleado = new JTextField("");
        jtCedulaEmpleado.setBounds(280, 50, 100, 40);
        add(jtCedulaEmpleado);
        
        jlEtiqueta=new JLabel("Digite los ID de los siguientes componentes en el Inventario");
        jlEtiqueta.setBounds(80, 100, 600, 40);
        add(jlEtiqueta);
        
        jlEtiqueta=new JLabel("Placa Madre:");
        jlEtiqueta.setBounds(20, 150, 200, 40);
        add(jlEtiqueta);
        jtPlaca = new JTextField("");
        jtPlaca.setBounds(120, 150, 100, 40);
        add(jtPlaca);
        jbBuscarPlaca = new JButton ("...");
        jbBuscarPlaca.setBounds(230, 150, 50, 45);
        add(jbBuscarPlaca);
        jbBuscarPlaca.addActionListener(this);
        
        jlEtiqueta=new JLabel("Procesador:");
        jlEtiqueta.setBounds(20, 200, 200, 40);
        add(jlEtiqueta);
        jtProcesador = new JTextField("");
        jtProcesador.setBounds(120, 200, 100, 40);
        add(jtProcesador);
        jbBuscarProcesador = new JButton ("...");
        jbBuscarProcesador.setBounds(230, 200, 50, 45);
        add(jbBuscarProcesador);
        jbBuscarProcesador.addActionListener(this);
        
        jlEtiqueta=new JLabel("Sistema de Enfriamiento:");
        jlEtiqueta.setBounds(20, 250, 200, 40);
        add(jlEtiqueta);
        jtEnfriamiento = new JTextField("");
        jtEnfriamiento.setBounds(200, 250, 100, 40);
        add(jtEnfriamiento);
        jbBuscarEnfriamiento = new JButton ("....");
        jbBuscarEnfriamiento.setBounds(320, 250, 50, 45);
        add(jbBuscarEnfriamiento);
        jbBuscarEnfriamiento.addActionListener(this);
        
        jlEtiqueta=new JLabel("RAM:");
        jlEtiqueta.setBounds(20, 300, 200, 40);
        add(jlEtiqueta);
        jtRAM = new JTextField("");
        jtRAM.setBounds(60, 300, 50, 40);
        add(jtRAM);
        jlEtiqueta=new JLabel("Cantidad:");
        jlEtiqueta.setBounds(120, 300, 200, 40);
        add(jlEtiqueta);
        jtCantRAM = new JTextField("");
        jtCantRAM.setBounds(190, 300, 50, 40);
        add(jtCantRAM);
        jbBuscarRAM = new JButton ("...");
        jbBuscarRAM.setBounds(250, 300, 50, 45);
        add(jbBuscarRAM);
        jbBuscarRAM.addActionListener(this);
        
        jlEtiqueta=new JLabel("Unidad de Almacenamiento:");
        jlEtiqueta.setBounds(20, 350, 200, 40);
        add(jlEtiqueta);
        jtAlmacenamiento = new JTextField("");
        jtAlmacenamiento.setBounds(220, 350, 50, 40);
        add(jtAlmacenamiento);
        jlEtiqueta=new JLabel("Cantidad:");
        jlEtiqueta.setBounds(280, 350, 200, 40);
        add(jlEtiqueta);
        jtCantAlmacenamiento = new JTextField("");
        jtCantAlmacenamiento.setBounds(350, 350, 50, 40);
        add(jtCantAlmacenamiento);
        jbBuscarAlmacenamiento = new JButton ("...");
        jbBuscarAlmacenamiento.setBounds(410, 350, 50, 45);
        add(jbBuscarAlmacenamiento);
        jbBuscarAlmacenamiento.addActionListener(this);
        
        jlEtiqueta=new JLabel("Tarjeta Gráfica:");
        jlEtiqueta.setBounds(20, 400, 200, 40);
        add(jlEtiqueta);
        jtGrafica = new JTextField("");
        jtGrafica.setBounds(130, 400, 100, 40);
        add(jtGrafica);
        jbBuscarGrafica = new JButton ("...");
        jbBuscarGrafica.setBounds(250, 400, 50, 45);
        add(jbBuscarGrafica);
        jbBuscarGrafica.addActionListener(this);
        
        jlEtiqueta=new JLabel("Case:");
        jlEtiqueta.setBounds(20, 450, 200, 40);
        add(jlEtiqueta);
        jtCase = new JTextField("");
        jtCase.setBounds(70, 450, 100, 40);
        add(jtCase);
        jbBuscarCase = new JButton ("...");
        jbBuscarCase.setBounds(200, 450, 50, 45);
        add(jbBuscarCase);
        jbBuscarCase.addActionListener(this);
        
        jlEtiqueta=new JLabel("Fuente de Poder:");
        jlEtiqueta.setBounds(20, 500, 200, 40);
        add(jlEtiqueta);
        jtFuente = new JTextField("");
        jtFuente.setBounds(150, 500, 100, 40);
        add(jtFuente);
        jbBuscarFuente = new JButton ("...");
        jbBuscarFuente.setBounds(260, 500, 50, 45);
        add(jbBuscarFuente);
        jbBuscarFuente.addActionListener(this);
        
        jbGuardar = new JButton ("Guardar");
        jbGuardar.setBounds(500, 570, 100, 50);
        add(jbGuardar);
        jbGuardar.addActionListener(this);
        jbCancelar = new JButton ("Cancelar");
        jbCancelar.setBounds(400, 570, 100, 50);
        add(jbCancelar);
        jbCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jbGuardar)
            Guardar();
        if (e.getSource()==jbCancelar)
            Limpiar();
        if (e.getSource()==jbBuscarPlaca)
            BuscarPlaca.Cargar();
        if (e.getSource()==jbBuscarProcesador)
            BuscarCPU.Cargar();
        if (e.getSource()==jbBuscarEnfriamiento)
            BuscarEnfriamiento.Cargar();
        if (e.getSource()==jbBuscarRAM)
            BuscarRAM.Cargar();
        if (e.getSource()==jbBuscarAlmacenamiento)
            BuscarAlmacenamiento.Cargar();
        if (e.getSource()==jbBuscarGrafica)
            BuscarGPU.Cargar();
        if (e.getSource()==jbBuscarCase)
            BuscarCase.Cargar();
        if (e.getSource()==jbBuscarFuente)
            BuscarFuentePoder.Cargar();
    }
    
    private void Guardar ()
    {
        try
        {
            Calendar calendario = Calendar.getInstance();
            Ensamblaje ensamblaje = new Ensamblaje();
            Detalles detalles = new Detalles();
            EnsamblajeBL blEnsam = new EnsamblajeBL();
            DetallesBL blDet = new DetallesBL();
            //asigna la fecha accediendo a los metodos de la clase abstracta 
            String fecha = calendario.get(Calendar.DAY_OF_MONTH)+"/"+calendario.get(Calendar.MONTH)+"/"+calendario.get(Calendar.YEAR);
            ensamblaje.SetCedulaCliente(jtCedulaCliente.getText());
            ensamblaje.SetCedulaEmpleado(jtCedulaEmpleado.getText());
            ensamblaje.SetFecha(fecha);
            if (!blEnsam.RealizarPedido(ensamblaje))
                JOptionPane.showMessageDialog(null, "Alguna de las cédulas son inválidas");
            detalles.SetIdPlacaMadre(Integer.parseInt(jtPlaca.getText()));
            detalles.SetIdProcesador(Integer.parseInt(jtProcesador.getText()));
            if (jtEnfriamiento.getText().equals(""))
                detalles.SetIdEnfriamiento(-1);
            else
                detalles.SetIdEnfriamiento(Integer.parseInt(jtEnfriamiento.getText()));
            detalles.SetIdRam(Integer.parseInt(jtRAM.getText()));
            detalles.SetCantidadRam(Integer.parseInt(jtCantRAM.getText()));
            detalles.SetIdCase(Integer.parseInt(jtCase.getText()));
            if (jtGrafica.getText().equals(""))
                detalles.SetIdGrafica(-1);
            else
                detalles.SetIdGrafica(Integer.parseInt(jtGrafica.getText()));
            detalles.SetUnidadAlmacenamiento(Integer.parseInt(jtAlmacenamiento.getText()));
            detalles.SetCantidadUnidades(Integer.parseInt(jtCantAlmacenamiento.getText()));
            detalles.SetIdFuente(Integer.parseInt(jtFuente.getText()));
            if (!blDet.Ingresar(detalles))
                JOptionPane.showMessageDialog(null, "El ensamblaje tiene un problema, intente de nuevo");
            if ((blEnsam.RealizarPedido(ensamblaje))&&(blDet.Ingresar(detalles)))
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
            Limpiar();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente de nuevo");
            Limpiar();
        }
    }
    
    private void Limpiar ()
    {
        jtCedulaCliente.setText("");
        jtCedulaEmpleado.setText("");
        jtPlaca.setText("");
        jtProcesador.setText("");
        jtEnfriamiento.setText("");
        jtRAM.setText("");
        jtCantRAM.setText("");
        jtAlmacenamiento.setText("");
        jtCantAlmacenamiento.setText("");
        jtGrafica.setText("");
        jtCase.setText("");
        jtFuente.setText("");
    }
    
    public static void Cargar ()
    {
        RealizarPedido pedido = new RealizarPedido();
        pedido.setBounds(0,0,600,650);
        pedido.setLocationRelativeTo(null);
        pedido.setVisible(true);
    }
}
