package DAL;
import java.util.ArrayList;
import Entidades.Case;
import java.io.*;

public class CaseDAL 
{
    private static ArrayList<Case> listaCase = new ArrayList<Case>();
    private String ruta = "/home/gabriel/FichProyecto/Case.bin";
    
    public ArrayList<Case> BuscarCase (String descripcion) throws Exception
    {
        ArrayList<Case> consultaCase = new ArrayList<Case>();
        for(Case c: listaCase)
        {
            if (c.GetDescripcion().equals(descripcion))
            {
                consultaCase.add(c);
                break;
            }
        }
        return consultaCase;
    }
    public ArrayList<Case> BuscarTodos() throws Exception
    {
        return listaCase;
    }
    
    public boolean IngresarCase (Case gabinete) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        gabinete.SetID(listaCase.size()+1);
        listaCase.add(gabinete);
        Escribir();
        return retVal;
    }
    public boolean ActualizarCase (Case gabinete) throws Exception
    {
        boolean retVal = false;
        for(Case c: listaCase)
        {
            if (c.GetID()==gabinete.GetID())
            {
                c.SetDescripcion(gabinete.GetDescripcion());
                c.SetIdFactorForma(gabinete.GetIdFactorForma());
                c.SetRefrigeracionLiquida(gabinete.GetRefrigeracionLiquida());
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
        escribiendoArchivo.writeObject(listaCase);
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
            escribiendoArchivo.writeObject(listaCase);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaCase = (ArrayList<Case>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
