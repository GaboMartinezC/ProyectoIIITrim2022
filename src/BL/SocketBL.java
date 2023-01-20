package BL;
import Entidades.Socket;
import DAL.SocketDAL;
import java.util.ArrayList;

public class SocketBL 
{
    public boolean IngresarSocket (Socket socket) throws Exception
    {
        SocketDAL dal = new SocketDAL();
        return dal.IngresarSocket(socket);
    }
    
    public ArrayList<Socket> BuscarSocket (String descripcion) throws Exception
    {
        SocketDAL dal = new SocketDAL();
        return dal.BuscarSocket(descripcion);
    }
    
    public ArrayList<Socket> BuscarTodos() throws Exception
    {
        SocketDAL dal = new SocketDAL();
        return dal.BuscarTodos();
    }
}
