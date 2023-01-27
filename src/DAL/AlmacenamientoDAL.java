package DAL;
import Entidades.Almacenamiento;
import java.util.ArrayList;
import java.io.*;

public class AlmacenamientoDAL 
{
    private static ArrayList<Almacenamiento> listaAlmacenamiento = new ArrayList<Almacenamiento>();
    private final static String rutaDir = "/var/FichProyecto";
    private String ruta ="/var/FichProyecto/Almacenamiento.bin";
    
    public ArrayList<Almacenamiento> BuscarAlmacenamiento (String descripcion) throws Exception
    {
        ArrayList<Almacenamiento> consultaAlmacenamiento = new ArrayList<Almacenamiento>();
        for(Almacenamiento a: listaAlmacenamiento)
        {
            if (a.GetDescripcion().equals(descripcion))
            {
                consultaAlmacenamiento.add(a);
                break;
            }
        }
        return consultaAlmacenamiento;
    }
    
    public ArrayList<Almacenamiento> BuscarTodos() throws Exception
    {
        return listaAlmacenamiento;
    }
    
    public boolean IngresarAlmacenamiento (Almacenamiento almacenamiento) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        almacenamiento.SetID(listaAlmacenamiento.size()+1);
        listaAlmacenamiento.add(almacenamiento);
        Escribir();
        return retVal;
    }
    public boolean ActualizarAlmacenamiento (Almacenamiento almacenamiento) throws Exception
    {
        boolean retVal = false;
        for(Almacenamiento a: listaAlmacenamiento)
        {
            if (a.GetID()==almacenamiento.GetID())
            {
                a.SetDescripcion(almacenamiento.GetDescripcion());
                a.SetCapacidad(almacenamiento.GetCapacidad());
                a.SetConsumoEnergia(almacenamiento.GetConsumoEnergia());
                a.SetM2(almacenamiento.GetM2());
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
        escribiendoArchivo.writeObject(listaAlmacenamiento);
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
        File fich = new File(rutaDir);
        File archivo = new File(ruta);
        if (fich.mkdirs())
        {
            if (!archivo.exists())
            {
                ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
                archivo.createNewFile();
                escribiendoArchivo.writeObject(listaAlmacenamiento);
                escribiendoArchivo.close();
            }    
        }
        
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaAlmacenamiento = (ArrayList<Almacenamiento>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
