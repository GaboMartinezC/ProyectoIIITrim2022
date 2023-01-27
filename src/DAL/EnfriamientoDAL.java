package DAL;
import java.util.ArrayList;
import Entidades.Enfriamiento;
import java.io.*;

public class EnfriamientoDAL 
{
    private static ArrayList<Enfriamiento> listaSisEnfriamiento = new ArrayList<Enfriamiento>();
    private String ruta ="/var/FichProyecto/Enfriamiento.bin";
    
    public ArrayList<Enfriamiento> BuscarEnfriamiento (String descripcion) throws Exception
    {
        ArrayList<Enfriamiento> consultaEnfriamiento = new ArrayList<Enfriamiento>();
        for(Enfriamiento l: listaSisEnfriamiento)
        {
            if (l.GetDescripcion().equals(descripcion))
            {
                consultaEnfriamiento.add(l);
                break;
            }
        }
        return consultaEnfriamiento;
    }
    
    public ArrayList<Enfriamiento> BuscarTodos() throws Exception
    {
        return listaSisEnfriamiento;
    }
    
    public boolean IngresarEnfriamiento (Enfriamiento enfriamiento) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        enfriamiento.SetID(listaSisEnfriamiento.size()+1);
        listaSisEnfriamiento.add(enfriamiento);
        Escribir();
        return retVal;
    }
    public boolean ActualizarEnfriamiento (Enfriamiento enfriamiento) throws Exception
    {
        boolean retVal = false;
        for(Enfriamiento e: listaSisEnfriamiento)
        {
            if (e.GetID()==enfriamiento.GetID())
            {
                e.SetDescripcion(enfriamiento.GetDescripcion());
                e.SetIdSocket(enfriamiento.GetIdSocket());
                e.SetLiquido(enfriamiento.GetLiquido());
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
        escribiendoArchivo.writeObject(listaSisEnfriamiento);
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
            escribiendoArchivo.writeObject(listaSisEnfriamiento);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaSisEnfriamiento = (ArrayList<Enfriamiento>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
