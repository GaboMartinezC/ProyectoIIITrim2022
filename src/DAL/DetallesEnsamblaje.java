package DAL;
import Entidades.*;
import java.util.ArrayList;
import java.io.*;

public class DetallesEnsamblaje 
{
    private static ArrayList<Detalles> listaDetallesEnsamblaje = new ArrayList<Detalles>();
    private String ruta = "/home/gabriel/FichProyecto/DetallesEnsamblaje.bin";

    private boolean VerificarAlimentacion (Detalles detalles) throws Exception
    {
        boolean retVal = true;
        double consumoTotal, multiplicacionUnidades;
        //instancia los objetos DAL de los componentes que requieren verificar alimentación
        PlacaMadreDAL placa = new PlacaMadreDAL();
        CpuDAL cpu = new CpuDAL();
        RamDAL ram = new RamDAL();
        GpuDAL gpu = new GpuDAL();
        AlmacenamientoDAL almacenamiento = new AlmacenamientoDAL();
        FuentePoderDAL fuente = new FuentePoderDAL();
        /*La suma de los consumos se realiza de la siguiente manera:
        -Busca todo el arraylist-Busca el indice con ID del componente +1
        -Cuando accede al objeto en el arraylist, accede a su consumo energético*/
        consumoTotal = placa.BuscarTodos().get(detalles.GetIdPlacaMadre()-1).GetConsumoEnergia();
        //después lo suma consigo mismo
        consumoTotal = consumoTotal+cpu.BuscarTodos().get(detalles.GetIdProcesador()-1).GetConsumoEnergetico();
        /*En el caso de los dispositivos cuyo consumo sea variable a la cantidad que haya como la RAM, lo multiplica
        por la cantidad que haya en una variable y lo suma al total*/
        multiplicacionUnidades = ram.BuscarTodos().get(detalles.GetIdRam()-1).GetConsumoEnergia()*detalles.GetCantidadRam();
        consumoTotal = consumoTotal+multiplicacionUnidades;
        consumoTotal = consumoTotal+gpu.BuscarTodos().get(detalles.GetIdGrafica()-1).GetConsumoEnergia();
        multiplicacionUnidades = almacenamiento.BuscarTodos().get(detalles.GetUnidadAlmacenamiento()-1).GetConsumoEnergia()*detalles.GetCantidadUnidades();
        consumoTotal = consumoTotal+multiplicacionUnidades;
        //Compara la potencia requerida con la brindada, si la requerida es mayor, retorna falso
        if (fuente.BuscarTodos().get(detalles.GetIdFuente()-1).GetPotencia()<consumoTotal)
            retVal = false;
        return retVal;
    }
    
    private boolean VerificarFactorForma(Detalles detalles) throws Exception
    {
        boolean retVal = true;
        PlacaMadreDAL placa = new PlacaMadreDAL();
        FuentePoderDAL fuente = new FuentePoderDAL();
        CaseDAL gabinete = new CaseDAL();
        EnfriamientoDAL enfriamiento = new EnfriamientoDAL();
        FactorFormaDAL dalFacForma = new FactorFormaDAL();
        int idSocket = placa.BuscarTodos().get(detalles.GetIdPlacaMadre()-1).GetIdSocket();
        int idFactorForma = placa.BuscarTodos().get(detalles.GetIdPlacaMadre()-1).GetID();
        FactorForma factorForma = dalFacForma.BuscarTodos().get(idFactorForma-1);
        //compara el factor forma de la placa madre con el del case
        if (gabinete.BuscarTodos().get(detalles.GetIdCase()-1).GetIdFactorForma()!=factorForma.GetID())
            retVal = false;
        //Verifica que la fuente sea más pequeña que la placa madre para que quepa en el case
        if (factorForma.GetLargo()>fuente.BuscarTodos().get(detalles.GetIdFuente()-1).GetAltura())
            retVal = false;
        //Valida que el ensamblaje tenga un sistema de enfriamiento ajeno al del procesador mediante un valor bandera
        if (detalles.GetIdEnfriamiento()!=-1)
        {
            //Verfica que el sistema de enfriamiento quepa en la placa madre
            if (enfriamiento.BuscarTodos().get(detalles.GetIdEnfriamiento()-1).GetID()!=idSocket)
                retVal = false;
            //Si el sistema de enfriamiento agregado es líquido, valida que el case esté adaptado
        if (enfriamiento.BuscarTodos().get(detalles.GetIdEnfriamiento()-1).GetLiquido())
        {
            if (!gabinete.BuscarTodos().get(detalles.GetIdCase()-1).GetRefrigeracionLiquida())
                retVal = false;
        }
        }
        return retVal;
    }
    
    private boolean VerificarCompatibilidad (Detalles detalles) throws Exception
    {
        boolean retVal = true;
        double ramTotal;
        PlacaMadreDAL placa = new PlacaMadreDAL();
        //Instancia los DAL exceptuando al Case, que fue validado en otro metodo
        CpuDAL cpu = new CpuDAL();
        RamDAL ram = new RamDAL();
        GpuDAL gpu = new GpuDAL();
        AlmacenamientoDAL almacenamiento = new AlmacenamientoDAL();
        FuentePoderDAL fuente = new FuentePoderDAL();
        //Instancia la placa madre y la fuente
        PlacaMadre placaMadre = placa.BuscarTodos().get(detalles.GetIdPlacaMadre()-1);
        FuentePoder fuentePoder = fuente.BuscarTodos().get(detalles.GetIdFuente()-1);
        ramTotal = ram.BuscarTodos().get(detalles.GetIdRam()-1).GetConsumoEnergia()*detalles.GetCantidadRam();
        //Verifica que el socket sea compatible
        if (placaMadre.GetIdSocket()!=cpu.BuscarTodos().get(detalles.GetIdProcesador()-1).GetIdSocket())
            retVal = false;
        //Verifica que la version de DDR de la placa y la RAM sean iguales
        if (placaMadre.GetVersionDDR()!=ram.BuscarTodos().get(detalles.GetIdRam()-1).GetVersionDDR())
            retVal = false;
        //Verifica que no se ingrese más RAM de la soportada por la placa
        if (placaMadre.GetLimiteRAM()<ramTotal)
            retVal = false;
        //Verifica que no se ingresen más modulos de los que la placa puede soportar
        if (placaMadre.GetCantidadSlotsRAM()<detalles.GetCantidadRam())
            retVal = false;
        //Si los dispositivos de almacenamiento son m.2
        if (almacenamiento.BuscarTodos().get(detalles.GetUnidadAlmacenamiento()-1).GetM2())
        {
            //Se verifica los puertos Pcie para m.2
            if (placaMadre.GetCantidadM2()<detalles.GetCantidadUnidades())
                retVal = false;
        }
        else
        //Si los dispositivos son de puerto SATA
        {
            //Se verific la alimentación desde la fuente de poder y las entradas SATA de la placa
            if (placaMadre.GetCantidadSATA()<detalles.GetCantidadUnidades())
                retVal = false;
            if (fuentePoder.GetCantidadConectoresSATA()<detalles.GetCantidadUnidades())
                retVal = false;
        }
        //Si el ensamblaje posee una tarjeta gráfica, valida sus datos, se compara mediante un valor bandera
        if (detalles.GetIdGrafica()!=-1)
        {
            //Dependiendo del tipo de entrada de la tarjeta gráfica, verifica la alimentación y los puertos de la placa
            if (gpu.BuscarTodos().get(detalles.GetIdGrafica()-1).GetPcie16())
            {
                if (placaMadre.GetCantidadPCIe16()<1)
                    retVal=false;
            }
            else
            {
                if (placaMadre.GetCantidadPCIe8()<1)
                    retVal=false;
            }
            if (fuentePoder.GetCantidadConectoresPCIe()<1)
                retVal = false;
        }
        return retVal;
    }
   
    //Busca los detalles mediante el ID del pedido asociado a ellos
    public Detalles BuscarDetalles (int idPedido)    
    {
        Detalles detalles = new Detalles();
        for (Detalles d: listaDetallesEnsamblaje)
        {
            if (d.GetIdPedido()==idPedido)
                detalles = d;
        }
        return detalles;
    }
    
    public boolean Ingresar (Detalles detalles) throws Exception
    {
        boolean retVal = true;
        /*Llama los metodos de verificacion, si alguno devuelve un falso, retVal se establece como falso
        Se llama a los metodos con una compuerta NOT, cada llamada tiene entremedio una compuerta OR*/
        if ((!VerificarAlimentacion(detalles))||(!VerificarFactorForma(detalles))||(!VerificarCompatibilidad(detalles)))
            retVal = false;
        if (retVal)
        {
            detalles.SetIdDetalle(listaDetallesEnsamblaje.size()+1);
            detalles.SetIdPedido(listaDetallesEnsamblaje.size()+1);
            listaDetallesEnsamblaje.add(detalles);
            Escribir();
        }
        return retVal;
    }
    
    /*Metodo privado de acceso a la escritura de los datos, se encuentra encapsulado al solamente ser llamado
    desde metodos públicos, siento este privado. Escribe el ArrayList declarado globalmente, utilizando la variable
    ruta declarada globalmente*/
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaDetallesEnsamblaje);
        escribiendoArchivo.close();
    }
    /*Metodos de lectura de los datos, el metodo de lectura como tal se encuentra encapsulado en un metodo
    público. El metodo Leer crea un objeto File para determinar si este existe, si no, lo crea
    Posterior a esta condicional, carga los archivos desde los archivos en memoria secundaria a memoria primaria*/
    public void AccesoLeer () throws Exception
    {
        Leer();
    }
    private void Leer() throws Exception
    {
        File archivo = new File(ruta);
        if (!archivo.exists())
        {
            ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
            archivo.createNewFile();
            escribiendoArchivo.writeObject(listaDetallesEnsamblaje);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaDetallesEnsamblaje = (ArrayList<Detalles>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
