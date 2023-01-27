package DAL;
import java.util.ArrayList;
import Entidades.FuentePoder;
import java.io.*;

public class FuentePoderDAL 
{
    private static ArrayList<FuentePoder> listaFuentePoder = new ArrayList<FuentePoder>();
    private String ruta ="/var/FichProyecto/FuentePoder.bin";
    
    public ArrayList<FuentePoder> BuscarFuentePoder (String descripcion) throws Exception
    {
        ArrayList<FuentePoder> consultaFuentePoder = new ArrayList<FuentePoder>();
        for(FuentePoder f: listaFuentePoder)
        {
            if (f.GetDescripcion().equals(descripcion))
            {
                consultaFuentePoder.add(f);
                break;
            }
        }
        return consultaFuentePoder;
    }
    
    public ArrayList<FuentePoder> BuscarTodos() throws Exception
    {
        return listaFuentePoder;
    }
    
    public boolean IngresarFuentePoder (FuentePoder fuentePoder) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        fuentePoder.SetID(listaFuentePoder.size()+1);
        listaFuentePoder.add(fuentePoder);
        Escribir();
        return retVal;
    }
    public boolean ActualizarFuentePoder (FuentePoder fuentePoder) throws Exception
    {
        boolean retVal = false;
        for(FuentePoder f: listaFuentePoder)
        {
            if (f.GetID()==fuentePoder.GetID())
            {
                f.SetDescripcion(fuentePoder.GetDescripcion());
                f.SetCantidadConectoresSATA(fuentePoder.GetCantidadConectoresSATA());
                f.SetCantidadConectoresPCIe(fuentePoder.GetCantidadConectoresPCIe());
                f.SetPotencia(fuentePoder.GetPotencia());
                f.SetAltura(fuentePoder.GetAltura());
                f.SetAncho(fuentePoder.GetAncho());
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
        escribiendoArchivo.writeObject(listaFuentePoder);
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
            escribiendoArchivo.writeObject(listaFuentePoder);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaFuentePoder = (ArrayList<FuentePoder>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}