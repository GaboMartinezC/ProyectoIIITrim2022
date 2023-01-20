package BL;
import Entidades.Cliente;
import DAL.ClienteDAL;        
import java.util.ArrayList;

public class ClienteBL 
{
    public Cliente BuscarCliente (String cedula) throws Exception
    {
        ClienteDAL dal = new ClienteDAL();
        return dal.BuscarCliente(cedula);
    }
    
    public ArrayList<Cliente> BuscarTodos () throws Exception
    {
        ClienteDAL dal = new ClienteDAL();
        return dal.BuscarTodos();
    }
    
    public boolean Ingresar(Cliente cliente) throws Exception
    {
        ClienteDAL dal = new ClienteDAL();
        return dal.IngresarCliente(cliente);
    }
    
    public boolean Actualizar (Cliente cliente) throws Exception
    {
        ClienteDAL dal = new ClienteDAL();
        return dal.ActualizarCliente(cliente);
    }
}
