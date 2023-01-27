package DAL;
import Entidades.Socket;
import java.util.ArrayList;
import java.io.*;

public class SocketDAL 
{
    private static ArrayList<Socket> listaSocket = new ArrayList<Socket>();
    private String ruta ="/var/FichProyecto/Socket.bin";
    
    public ArrayList<Socket> BuscarSocket (String descripcion) throws Exception
    {
        ArrayList<Socket> consultaSocket = new ArrayList<Socket>();
        for(Socket s: listaSocket)
        {
            if (s.GetDescripcion().equals(descripcion))
            {
                consultaSocket.add(s);
                break;
            }
        }
        return consultaSocket;
    }
    
    public ArrayList<Socket> BuscarTodos() throws Exception
    {
        return listaSocket;
    }
    
    public boolean IngresarSocket (Socket socket) throws Exception
    {
        boolean retVal = true;
        //incrementa el id de cliente basado en el ultimo registro en el arreglo
        socket.SetID(listaSocket.size()+1);
        listaSocket.add(socket);
        Escribir();
        return retVal;
    }
    public boolean ActualizarSocket (Socket socket) throws Exception
    {
        boolean retVal = false;
        for(Socket s: listaSocket)
        {
            if (s.GetID()==socket.GetID())
            {
                s.SetDescripcion(socket.GetDescripcion());
                s.SetLGA(socket.GetLGA());
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
        escribiendoArchivo.writeObject(listaSocket);
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
            escribiendoArchivo.writeObject(listaSocket);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaSocket = (ArrayList<Socket>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
