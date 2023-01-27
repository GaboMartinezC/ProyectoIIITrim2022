package DAL;
import java.util.ArrayList;
import Entidades.GPU;
import java.io.*;

public class GpuDAL 
{
    private static ArrayList<GPU> listaGpu = new ArrayList<GPU>();
    private String ruta ="/var/FichProyecto/GPU.bin";    
    
    public ArrayList<GPU> BuscarGPU (String descripcion) throws Exception
    {
        ArrayList<GPU> consultaGpu = new ArrayList<GPU>();
        for(GPU g: listaGpu)
        {
            if (g.GetDescripcion().equals(descripcion))
            {
                consultaGpu.add(g);
                break;
            }
        }
        return consultaGpu;
    }
    
    public ArrayList<GPU> BuscarTodos() throws Exception
    {
        return listaGpu;
    }
    
    public boolean IngresarGPU (GPU gpu) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        gpu.SetID(listaGpu.size()+1);
        listaGpu.add(gpu);
        Escribir();
        return retVal;
    }
    public boolean ActualizarGPU (GPU gpu) throws Exception
    {
        boolean retVal = false;
        for(GPU g: listaGpu)
        {
            if (g.GetID()==gpu.GetID())
            {
                g.SetDescripcion(gpu.GetDescripcion());
                g.SetPcie16(gpu.GetPcie16());
                g.SetConsumoEnergia(gpu.GetConsumoEnergia());
                retVal = true;
                break;
            }
        }
        Escribir();
        return retVal;
    }
    
    /*Metodo privado de acceso a la escritura de los datos, se encuentra encapsulado al solamente ser llamado
    desde metodos públicos, siento este privado. Escribe el ArrayList declarado globalmente, utilizando la variable
    ruta declarada globalmente*/
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaGpu);
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
            escribiendoArchivo.writeObject(listaGpu);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaGpu = (ArrayList<GPU>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
    
}
