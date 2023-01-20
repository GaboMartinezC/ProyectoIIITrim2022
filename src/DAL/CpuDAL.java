package DAL;
import Entidades.CPU;
import java.util.ArrayList;
import java.io.*;

public class CpuDAL 
{
    private static ArrayList<CPU> listaCpu = new ArrayList<CPU>();
    String ruta = "/home/gabriel/FichProyecto/CPU.bin";
    
    public ArrayList<CPU> BuscarCPU (String descripcion) throws Exception
    {
        ArrayList<CPU> consultaCpu = new ArrayList<CPU>();
        for(CPU c: listaCpu)
        {
            if (c.GetDescripcion().equals(descripcion))
            {
                consultaCpu.add(c);
                break;
            }
        }
        return consultaCpu;
    }
    
    public ArrayList<CPU> BuscarTodos() throws Exception
    {
        return listaCpu;
    }
    
    public boolean IngresarCPU (CPU cpu) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        cpu.SetID(listaCpu.size()+1);
        listaCpu.add(cpu);
        Escribir();
        return retVal;
    }
    public boolean ActualizarCPU (CPU cpu) throws Exception
    {
        boolean retVal = false;
        for(CPU c: listaCpu)
        {
            if (c.GetID()==cpu.GetID())
            {
                c.SetDescripcion(cpu.GetDescripcion());
                c.SetIdSocket(cpu.GetIdSocket());
                c.SetConsumoEnergetico(cpu.GetConsumoEnergetico());
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
        escribiendoArchivo.writeObject(listaCpu);
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
            escribiendoArchivo.writeObject(listaCpu);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaCpu = (ArrayList<CPU>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
