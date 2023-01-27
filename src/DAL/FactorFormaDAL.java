package DAL;
import java.util.ArrayList;
import Entidades.FactorForma;
import java.io.*;

public class FactorFormaDAL 
{
    private static ArrayList<FactorForma> listaFactorForma = new ArrayList<FactorForma>();
    private String ruta ="/var/FichProyecto/FactorForma.bin";
    
    public ArrayList<FactorForma> BuscarFactorForma (String descripcion) throws Exception
    {
        ArrayList<FactorForma> consultaFactorForma = new ArrayList<FactorForma>();
        for(FactorForma f: listaFactorForma)
        {
            if (f.GetDescripcion().equals(descripcion))
            {
                consultaFactorForma.add(f);
                break;
            }
        }
        return consultaFactorForma;
    }
    public ArrayList<FactorForma> BuscarTodos() throws Exception
    {
        return listaFactorForma;
    }
    public boolean IngresarFactorForma (FactorForma factorForma) throws Exception
    {
        //incrementa el id de factor de forma basado en el ultimo registro en el arreglo
        factorForma.SetID(listaFactorForma.size()+1);
        listaFactorForma.add(factorForma);
        Escribir();
        return true;
    }
    public boolean ActualizarFactorForma (FactorForma factorForma) throws Exception
    {
        boolean retVal = false;
        for(FactorForma f: listaFactorForma)
        {
            if (f.GetID()==factorForma.GetID())
            {
                f.SetDescripcion(factorForma.GetDescripcion());
                f.SetLargo(factorForma.GetAncho());
                f.SetAncho(factorForma.GetLargo());
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
        escribiendoArchivo.writeObject(listaFactorForma);
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
            escribiendoArchivo.writeObject(listaFactorForma);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaFactorForma = (ArrayList<FactorForma>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}