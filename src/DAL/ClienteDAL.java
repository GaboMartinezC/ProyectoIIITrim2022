package DAL;
import Entidades.Cliente;
import java.util.ArrayList;
import java.io.*;

public class ClienteDAL 
{
    private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    private String ruta ="/var/FichProyecto/Cliente.bin";
    
    public Cliente BuscarCliente (String cedulaCliente) throws Exception
    {
        Cliente cliente = new Cliente();
        cliente.SetCedula("");
        for(Cliente c: listaCliente)
        {
            if (c.GetCedula().equals(cedulaCliente))
            {
                cliente = c;
                break;
            }
        }
        return cliente;
    }
    
    public ArrayList<Cliente> BuscarTodos() throws Exception
    {
        return listaCliente;
    }
    
    public boolean IngresarCliente (Cliente cliente) throws Exception
    {
        boolean retVal;
        //Valida que la cedula no se repita en las arraylist
        if (BuscarCliente(cliente.GetCedula()).GetCedula().equals(""))
        {
            //incrementa el id de cliente basado en el ultimo registro en el arreglo
            cliente.SetIdCliente(listaCliente.size()+1);
            listaCliente.add(cliente);
            Escribir();
            retVal = true;
        }
        else
        {
            retVal = false;
        }
        return retVal;
    }
    public boolean ActualizarCliente (Cliente cliente) throws Exception
    {
        boolean retVal = false;
        for(Cliente c: listaCliente)
        {
            if (c.GetCedula().equals(cliente.GetCedula()))
            {
                c.SetCedula(cliente.GetCedula());
                c.SetNombreCompleto(cliente.GetNombreCompleto());
                c.SetTelefono(cliente.GetTelefono());
                c.SetCorreo(cliente.GetCorreo());
                Escribir();
                retVal = true;
                break;
            }
        }
        return retVal;
    }
    
    /*Metodo privado de acceso a la escritura de los datos, se encuentra encapsulado al solamente ser llamado
    desde metodos públicos, siento este privado. Escribe el ArrayList declarado globalmente, utilizando la variable
    ruta declarada globalmente*/
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaCliente);
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
            escribiendoArchivo.writeObject(listaCliente);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaCliente = (ArrayList<Cliente>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
