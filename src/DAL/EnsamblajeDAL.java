package DAL;
import Entidades.Ensamblaje;
import java.util.ArrayList;
import java.io.*;

public class EnsamblajeDAL 
{
    private static ArrayList<Ensamblaje> listaEnsamblaje = new ArrayList<Ensamblaje>();
    private String ruta ="/var/FichProyecto/Ensamblaje.bin";
    
    public void RealizarPedido(Ensamblaje ensamblaje) throws Exception
    {
        ensamblaje.SetID(listaEnsamblaje.size()+1);
        listaEnsamblaje.add(ensamblaje);
        Escribir();
    }
    
    public ArrayList<Ensamblaje> BuscarEnsamblajeFecha(String fecha) throws Exception
    {
        ArrayList<Ensamblaje> lista = new ArrayList<Ensamblaje>();
        for (Ensamblaje e: listaEnsamblaje)
        {
            if (e.GetFecha().equals(fecha))
                lista.add(e);
        }
        return lista;
    }
    
    public boolean ConfirmarPedido(int id) throws Exception
    {
        boolean retVal = true;
        for (Ensamblaje e: listaEnsamblaje)
        {
            if (e.GetID()==id)
            {
                if (e.GetConfirmado())
                    retVal=false;
                else
                {
                    e.SetConfirmado(true);
                    e.SetCancelado(false);
                    retVal=true;
                    Escribir();
                }
            }
        }
        return retVal;
    }
    
    public boolean CancelarPedido(int id) throws Exception
    {
        boolean retVal = true;
        for (Ensamblaje e: listaEnsamblaje)
        {
            if (e.GetID()==id)
            {
                if (e.GetCancelado())
                    retVal=false;
                else
                {
                    e.SetCancelado(true);
                    e.SetConfirmado(false);
                    retVal=true;
                    Escribir();
                }
            }
        }
        return retVal;
    }
    
    public ArrayList<Ensamblaje> VerTodo() throws Exception
    {
        return listaEnsamblaje;
    }
    
    /*Metodo privado de acceso a la escritura de los datos, se encuentra encapsulado al solamente ser llamado
    desde metodos públicos, siento este privado. Escribe el ArrayList declarado globalmente, utilizando la variable
    ruta declarada globalmente*/
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaEnsamblaje);
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
            escribiendoArchivo.writeObject(listaEnsamblaje);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaEnsamblaje = (ArrayList<Ensamblaje>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
