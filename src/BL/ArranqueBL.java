package BL;
import DAL.*;
public class ArranqueBL 
{
    /*El metodo de esta clase llama a todos los metodos DAL de acceso a lectura.
    Esto tiene el fin de traer los datos de los archivos en memoria secundaria a
    memoria primaria, considerando que esta es más rápida para trabajar*/
    public void Cargar()
    {
        try
        {
            AlmacenamientoDAL almacenamiento = new AlmacenamientoDAL();
            almacenamiento.AccesoLeer();
            CaseDAL gabinete = new CaseDAL();
            gabinete.AccesoLeer();
            ClienteDAL cliente = new ClienteDAL();
            cliente.AccesoLeer();
            CpuDAL cpu = new CpuDAL();
            cpu.AccesoLeer();
            DetallesEnsamblaje detalles = new DetallesEnsamblaje();
            detalles.AccesoLeer();
            EmpleadoDAL empleados = new EmpleadoDAL();
            empleados.AccesoLeer();
            EnfriamientoDAL enfriamiento = new EnfriamientoDAL();
            enfriamiento.AccesoLeer();
            EnsamblajeDAL ensamblaje = new EnsamblajeDAL();
            ensamblaje.AccesoLeer();
            FactorFormaDAL factorForma = new FactorFormaDAL();
            factorForma.AccesoLeer();
            FuentePoderDAL fuentePoder = new FuentePoderDAL();
            fuentePoder.AccesoLeer();
            GpuDAL gpu = new GpuDAL();
            gpu.AccesoLeer();
            PlacaMadreDAL placaMadre = new PlacaMadreDAL();
            placaMadre.AccesoLeer();
            RamDAL ram = new RamDAL();
            ram.AccesoLeer();
            SocketDAL socket = new SocketDAL();
            socket.AccesoLeer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
