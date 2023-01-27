package DAL;
import java.util.ArrayList;
import Entidades.PlacaMadre;
import java.io.*;

public class PlacaMadreDAL 
{
    private static ArrayList<PlacaMadre> listaPlacaMadre = new ArrayList<PlacaMadre>();
    private String ruta ="/var/FichProyecto/PlacaMadre.bin";
    
    public ArrayList<PlacaMadre> BuscarPlacaMadre (String descripcion) throws Exception
    {
        ArrayList<PlacaMadre> consultaPlacaMadre = new ArrayList<PlacaMadre>();
        for(PlacaMadre p: listaPlacaMadre)
        {
            if (p.GetDescripcion().equals(descripcion))
            {
                consultaPlacaMadre.add(p);
                break;
            }
        }
        return consultaPlacaMadre;
    }
    
    public ArrayList<PlacaMadre> BuscarTodos() throws Exception
    {
        return listaPlacaMadre;
    }
    
    public boolean IngresarPlacaMadre (PlacaMadre placaMadre) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        placaMadre.SetID(listaPlacaMadre.size()+1);
        listaPlacaMadre.add(placaMadre);
        Escribir();
        return retVal;
    }
    public boolean ActualizarPlacaMadre (PlacaMadre placaMadre) throws Exception
    {
        boolean retVal = false;
        for(PlacaMadre p: listaPlacaMadre)
        {
            if (p.GetID()==placaMadre.GetID())
            {
                p.SetDescripcion(placaMadre.GetDescripcion());
                p.SetIdFactorForma(placaMadre.GetIdFactorForma());
                p.SetIdSocket(placaMadre.GetIdSocket());
                p.SetCantidadSATA(placaMadre.GetCantidadSATA());
                p.SetCantidadPCIe16(placaMadre.GetCantidadPCIe16());
                p.SetCantidadPCIe8(placaMadre.GetCantidadPCIe8());
                p.SetVersionDDR(placaMadre.GetVersionDDR());
                p.SetCantidadSlotsRAM(placaMadre.GetCantidadSlotsRAM());
                p.SetLimiteRAM(placaMadre.GetLimiteRAM());
                p.SetCantidadM2(placaMadre.GetCantidadM2());
                p.SetConsumoEnergia(placaMadre.GetConsumoEnergia());
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
        escribiendoArchivo.writeObject(listaPlacaMadre);
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
            escribiendoArchivo.writeObject(listaPlacaMadre);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaPlacaMadre = (ArrayList<PlacaMadre>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
