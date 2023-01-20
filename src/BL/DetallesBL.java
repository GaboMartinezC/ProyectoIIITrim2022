package BL;
import Entidades.Detalles;
import DAL.*;

public class DetallesBL 
{
    public boolean Ingresar (Detalles detalles) throws Exception
    {
        boolean retVal = true;
        //Instancia los DAL 
        PlacaMadreDAL placa = new PlacaMadreDAL();
        CpuDAL cpu = new CpuDAL();
        EnfriamientoDAL enfriamiento = new EnfriamientoDAL();
        RamDAL ram = new RamDAL();
        CaseDAL gabinete = new CaseDAL();
        GpuDAL gpu = new GpuDAL();
        AlmacenamientoDAL almacenamiento = new AlmacenamientoDAL();
        FuentePoderDAL fuente = new FuentePoderDAL();
        DetallesEnsamblaje dal = new DetallesEnsamblaje();
        /*Verifica que los ID del objeto detalles existan, en caso de que existan
        verificando el tamaño de los arraylist, en caso de todos existir, guarda los datos en el DAL*/
        if (detalles.GetIdPlacaMadre()>placa.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetIdProcesador()>cpu.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetIdEnfriamiento()>enfriamiento.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetIdRam()>ram.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetIdCase()>gabinete.BuscarTodos().size()+1)
            retVal=false;
        if(detalles.GetIdGrafica()>gpu.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetUnidadAlmacenamiento()>almacenamiento.BuscarTodos().size()+1)
            retVal=false;
        if (detalles.GetIdFuente()>fuente.BuscarTodos().size()+1)
            retVal=false;
        if (retVal)
            dal.Ingresar(detalles);
        return retVal;
    }
    
    public Detalles BuscarDetallesPedido(int id)
    {
        DetallesEnsamblaje dal = new DetallesEnsamblaje();
        return dal.BuscarDetalles(id);
    }
}
