package DAL;
import java.util.ArrayList;
import Entidades.RAM;
import java.io.*;

public class RamDAL 
{
    private static ArrayList<RAM> listaRam = new ArrayList<RAM>();
    private String ruta ="/var/FichProyecto/RAM.bin";
    
    public ArrayList<RAM> BuscarRAM (String descripcion) throws Exception
    {
        ArrayList<RAM> consultaRAM = new ArrayList<RAM>();
        for(RAM r: listaRam)
        {
            if (r.GetDescripcion().equals(descripcion))
            {
                consultaRAM.add(r);
                break;
            }
        }
        return consultaRAM;
    }
    
    public ArrayList<RAM> BuscarTodos() throws Exception
    {
        return listaRam;
    }
    
    public boolean IngresarRAM (RAM ram) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        ram.SetID(listaRam.size()+1);
        listaRam.add(ram);
        Escribir();
        return retVal;
    }
    public boolean ActualizarRAM (RAM ram) throws Exception
    {
        boolean retVal = false;
        for(RAM r: listaRam)
        {
            if (r.GetID()==ram.GetID())
            {
                r.SetDescripcion(ram.GetDescripcion());
                r.SetVersionDDR(ram.GetVersionDDR());
                r.SetCapacidad(ram.GetCapacidad());
                r.SetConsumoEnergia(ram.GetConsumoEnergia());
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
        escribiendoArchivo.writeObject(listaRam);
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
            escribiendoArchivo.writeObject(listaRam);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaRam = (ArrayList<RAM>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
