package BL;
import Entidades.Socket;
import DAL.SocketDAL;        
import Entidades.Enfriamiento;
import DAL.EnfriamientoDAL;
import java.util.ArrayList;

public class EnfriamientoBL 
{
    public ArrayList<Enfriamiento> BuscarEnfriamiento (String descripcion) throws Exception
    {
        EnfriamientoDAL dal = new EnfriamientoDAL();
        return dal.BuscarEnfriamiento(descripcion);
    }
    
    public ArrayList<Enfriamiento> BuscarTodos () throws Exception
    {
        EnfriamientoDAL dal = new EnfriamientoDAL();
        return dal.BuscarTodos();
    }
    
    public boolean Ingresar(Enfriamiento enfriamiento) throws Exception
    {
        boolean retVal = false;
        SocketDAL socket = new SocketDAL();
        EnfriamientoDAL dal = new EnfriamientoDAL();
        ArrayList<Socket> lista = socket.BuscarTodos();
        //Valida que el socket relacionado exista
        for (Socket s: lista)
        {
            if (s.GetID()==enfriamiento.GetIdSocket())
                retVal=true;
        }
        if (retVal)
            dal.IngresarEnfriamiento(enfriamiento);
        return retVal;
    }
    
    public boolean Actualizar (Enfriamiento enfriamiento) throws Exception
    {
        boolean retVal = false;
        SocketDAL socket = new SocketDAL();
        EnfriamientoDAL dal = new EnfriamientoDAL();
        ArrayList<Socket> lista = socket.BuscarTodos();
        //Valida que el socket relacionado exista
        for (Socket s: lista)
        {
            if (s.GetID()==enfriamiento.GetIdSocket())
                retVal=true;
        }
        if (retVal)
            dal.ActualizarEnfriamiento(enfriamiento);
        return retVal;
    }
}
