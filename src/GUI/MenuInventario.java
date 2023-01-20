package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MenuInventario extends JFrame implements ActionListener
{
    private JLabel jlEtiqueta;
    //define la barra de menu
    JMenuBar barraMenu=new JMenuBar();
    
    //define los componentes de la barra
    JMenu jmPlacaMadre = new JMenu("Placa Madre");
    JMenu jmCpu = new JMenu("CPU");
    JMenu jmSocket = new JMenu("Socket");
    JMenu jmRam = new JMenu ("RAM");
    JMenu jmCase = new JMenu ("Case");
    JMenu jmFactorForma = new JMenu ("Factor Forma");
    JMenu jmEnfriamiento = new JMenu ("Sistema de Enfriamiento");
    JMenu jmFuentePoder = new JMenu ("Fuente de Poder");
    JMenu jmGpu = new JMenu ("GPU");
    JMenu jmAlmacenamiento = new JMenu ("Almacenamiento");
    
    //define todas las opciones de CRUD de los componentes
    JMenuItem placIngresar = new JMenuItem ("Ingresar");
    JMenuItem placActualizar = new JMenuItem ("Actualizar");
    JMenuItem placBuscar = new JMenuItem ("Buscar");
    JMenuItem placBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem cpuIngresar = new JMenuItem ("Ingresar");
    JMenuItem cpuActualizar = new JMenuItem ("Actualizar");
    JMenuItem cpuBuscar = new JMenuItem ("Buscar");
    JMenuItem cpuBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem socketIngresar = new JMenuItem ("Ingresar");
    JMenuItem socketActualizar = new JMenuItem ("Actualizar");
    JMenuItem socketBuscar = new JMenuItem ("Buscar");
    JMenuItem socketBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem ramIngresar = new JMenuItem ("Ingresar");
    JMenuItem ramActualizar = new JMenuItem ("Actualizar");
    JMenuItem ramBuscar = new JMenuItem ("Buscar");
    JMenuItem ramBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem caseIngresar = new JMenuItem ("Ingresar");
    JMenuItem caseActualizar = new JMenuItem ("Actualizar");
    JMenuItem caseBuscar = new JMenuItem ("Buscar");
    JMenuItem caseBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem facFormaIngresar = new JMenuItem ("Ingresar");
    JMenuItem facFormaActualizar = new JMenuItem ("Actualizar");
    JMenuItem facFormaBuscar = new JMenuItem ("Buscar");
    JMenuItem facFormaBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem enfriamIngresar = new JMenuItem ("Ingresar");
    JMenuItem enfriamActualizar = new JMenuItem ("Actualizar");
    JMenuItem enfriamBuscar = new JMenuItem ("Buscar");
    JMenuItem enfriamBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem fuenteIngresar = new JMenuItem ("Ingresar");
    JMenuItem fuenteActualizar = new JMenuItem ("Actualizar");
    JMenuItem fuenteBuscar = new JMenuItem ("Buscar");
    JMenuItem fuenteBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem gpuIngresar = new JMenuItem ("Ingresar");
    JMenuItem gpuActualizar = new JMenuItem ("Actualizar");
    JMenuItem gpuBuscar = new JMenuItem ("Buscar");
    JMenuItem gpuBuscarTodos = new JMenuItem ("Ver Todos");
    
    JMenuItem almacIngresar = new JMenuItem ("Ingresar");
    JMenuItem almacActualizar = new JMenuItem ("Actualizar");
    JMenuItem almacBuscar = new JMenuItem ("Buscar");
    JMenuItem almacBuscarTodos = new JMenuItem ("Ver Todos");
    
    public MenuInventario ()
    {
        try
        {
            setLayout(null);
            setJMenuBar (barraMenu);
            //agrega a la barra de menu todos los componentes
            barraMenu.add(jmPlacaMadre);
            barraMenu.add(jmCpu);
            barraMenu.add(jmSocket);
            barraMenu.add(jmRam);
            barraMenu.add(jmCase);
            barraMenu.add(jmFactorForma);
            barraMenu.add(jmEnfriamiento);
            barraMenu.add(jmFuentePoder);
            barraMenu.add(jmGpu);
            barraMenu.add(jmAlmacenamiento);

            //agrega a los componenentes de menu las opciones CRUD
            jmPlacaMadre.add(placIngresar);
            placIngresar.addActionListener(this);
            jmPlacaMadre.add(placActualizar);
            placActualizar.addActionListener(this);
            jmPlacaMadre.add(placBuscar);
            placBuscar.addActionListener(this);
            jmPlacaMadre.add(placBuscarTodos);
            placBuscarTodos.addActionListener(this);
            jmCpu.add(cpuIngresar);
            cpuIngresar.addActionListener(this);
            jmCpu.add(cpuActualizar);
            cpuActualizar.addActionListener(this);
            jmCpu.add(cpuBuscar);
            cpuBuscar.addActionListener(this);
            jmCpu.add(cpuBuscarTodos);
            cpuBuscarTodos.addActionListener(this);
            jmSocket.add(socketIngresar);
            socketIngresar.addActionListener(this);
            jmSocket.add(socketActualizar);
            socketActualizar.addActionListener(this);
            jmSocket.add(socketBuscar);
            socketBuscar.addActionListener(this);
            jmSocket.add(socketBuscarTodos);
            socketBuscarTodos.addActionListener(this);
            jmRam.add(ramIngresar);
            ramIngresar.addActionListener(this);
            jmRam.add(ramActualizar);
            ramActualizar.addActionListener(this);
            jmRam.add(ramBuscar);
            ramBuscar.addActionListener(this);
            jmRam.add(ramBuscarTodos);
            ramBuscarTodos.addActionListener(this);
            jmCase.add(caseIngresar);
            caseIngresar.addActionListener(this);
            jmCase.add(caseActualizar);
            caseActualizar.addActionListener(this);
            jmCase.add(caseBuscar);
            caseBuscar.addActionListener(this);
            jmCase.add(caseBuscarTodos);
            caseBuscarTodos.addActionListener(this);
            jmFactorForma.add(facFormaIngresar);
            facFormaIngresar.addActionListener(this);
            jmFactorForma.add(facFormaActualizar);
            facFormaActualizar.addActionListener(this);
            jmFactorForma.add(facFormaBuscar);
            facFormaBuscar.addActionListener(this);
            jmFactorForma.add(facFormaBuscarTodos);
            facFormaBuscarTodos.addActionListener(this);
            jmEnfriamiento.add(enfriamIngresar);
            enfriamIngresar.addActionListener(this);
            jmEnfriamiento.add(enfriamActualizar);
            enfriamActualizar.addActionListener(this);
            jmEnfriamiento.add(enfriamBuscar);
            enfriamBuscar.addActionListener(this);
            jmEnfriamiento.add(enfriamBuscarTodos);
            enfriamBuscarTodos.addActionListener(this);
            jmFuentePoder.add(fuenteIngresar);
            fuenteIngresar.addActionListener(this);
            jmFuentePoder.add(fuenteActualizar);
            fuenteActualizar.addActionListener(this);
            jmFuentePoder.add(fuenteBuscar);
            fuenteBuscar.addActionListener(this);
            jmFuentePoder.add(fuenteBuscarTodos);
            fuenteBuscarTodos.addActionListener(this);
            jmGpu.add(gpuIngresar);
            gpuIngresar.addActionListener(this);
            jmGpu.add(gpuActualizar);
            gpuActualizar.addActionListener(this);
            jmGpu.add(gpuBuscar);
            gpuBuscar.addActionListener(this);
            jmGpu.add(gpuBuscarTodos);
            jmAlmacenamiento.add(almacIngresar);
            gpuBuscarTodos.addActionListener(this);
            jmAlmacenamiento.add(almacIngresar);
            almacIngresar.addActionListener(this);
            jmAlmacenamiento.add(almacActualizar);
            almacActualizar.addActionListener(this);
            jmAlmacenamiento.add(almacBuscar);
            almacBuscar.addActionListener(this);
            jmAlmacenamiento.add(almacBuscarTodos);
            almacBuscarTodos.addActionListener(this);

            //Muestra la etiqueta de inventario
            Font titulos=new Font(null, Font.BOLD,30);
            jlEtiqueta=new JLabel("Inventario");
            jlEtiqueta.setFont(titulos);
            jlEtiqueta.setBounds(400, 150, 200, 40);
            add(jlEtiqueta);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //CRUD Placas
        if (e.getSource()==placIngresar)
            IngresarPlaca.Cargar();
        if (e.getSource()==placActualizar)
            ActualizarPlaca.Cargar();
        if (e.getSource()==placBuscar)
            BuscarPlaca.Cargar();
        if (e.getSource()==placBuscarTodos)
            VerTodoPlaca.Cargar();
        //CRUD CPU
        if (e.getSource()==cpuIngresar)
            IngresarCPU.Cargar();
        if (e.getSource()==cpuBuscarTodos)
            VerTodoCPU.Cargar();
        if (e.getSource()==cpuBuscar)
            BuscarCPU.Cargar();
        if (e.getSource()==cpuActualizar)
            ActualizarCPU.Cargar();
        //CRUD Socket
        if (e.getSource()==socketIngresar)
            IngresarSocket.Cargar();
        if (e.getSource()==socketBuscarTodos)
            VerTodoSocket.Cargar();
        if (e.getSource()==socketBuscar)
            BuscarSocket.Cargar();
        if (e.getSource()==socketActualizar)
            ActualizarSocket.Cargar();
        //CRUD RAM
        if (e.getSource()==ramIngresar)
            IngresarRAM.Cargar();
        if (e.getSource()==ramActualizar)
            ActualizarRAM.Cargar();
        if (e.getSource()==ramBuscarTodos)
            VerTodoRAM.Cargar();
        if (e.getSource()==ramBuscar)
            BuscarRAM.Cargar();
        //CRUD Case
        if (e.getSource()==caseIngresar)
            IngresarCase.Cargar();
        if (e.getSource()==caseBuscarTodos)
            VerTodoCase.Cargar();
        if (e.getSource()==caseBuscar)
            BuscarCase.Cargar();
        if (e.getSource()==caseActualizar)
            ActualizarCase.Cargar();
        //CRUD Factores de Forma
        if (e.getSource()==facFormaIngresar)
            IngresarFactorForma.Cargar();
        if (e.getSource()==facFormaActualizar)
            ActualizarFactorForma.Cargar();
        if (e.getSource()==facFormaBuscarTodos)
            VerTodoFactorForma.Cargar();
        if(e.getSource()==facFormaBuscar)
            BuscarFactorForma.Cargar();
        //CRUD Sistemas de Enfriamiento
        if (e.getSource()==enfriamIngresar)
            IngresarEnfriamiento.Cargar();
        if (e.getSource()==enfriamBuscarTodos)
            VerTodoEnfriamiento.Cargar();
        if (e.getSource()==enfriamBuscar)
            BuscarEnfriamiento.Cargar();
        if (e.getSource()==enfriamActualizar)
            ActualizarEnfriamiento.Cargar();
        //CRUD Fuente Poder
        if(e.getSource()==fuenteIngresar)
            IngresarFuentePoder.Cargar();
        if (e.getSource()==fuenteActualizar)
            ActualizarFuentePoder.Cargar();
        if (e.getSource()==fuenteBuscarTodos)
            VerTodoFuentePoder.Cargar();
        if (e.getSource()==fuenteBuscar)
           BuscarFuentePoder.Cargar();
        //CRUD GPU
        if (e.getSource()==gpuIngresar)
            IngresarGPU.Cargar();
        if (e.getSource()==gpuBuscarTodos)
            VerTodoGPU.Cargar();
        if (e.getSource()==gpuBuscar)
            BuscarGPU.Cargar();
        if (e.getSource()==gpuActualizar)
            ActualizarGPU.Cargar();
        //CRUD Almacenamiento
        if (e.getSource()==almacIngresar)
            IngresarAlmacenamiento.Cargar();
        if (e.getSource()==almacBuscarTodos)
            VerTodoAlmacenamiento.Cargar();
        if (e.getSource()==almacBuscar)
            BuscarAlmacenamiento.Cargar();
        if (e.getSource()==almacActualizar)
            ActualizarAlmacenamiento.Cargar();
    }

}
