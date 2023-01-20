package BL;
import DAL.EnsamblajeDAL;
import DAL.EmpleadoDAL;
import DAL.ClienteDAL;
import Entidades.Ensamblaje;
import java.util.ArrayList;

public class EnsamblajeBL 
{
    public boolean RealizarPedido (Ensamblaje ensamblaje) throws Exception
    {
        boolean retVal = true;
        EmpleadoDAL empleado = new EmpleadoDAL();
        ClienteDAL cliente = new ClienteDAL();
        EnsamblajeDAL dal = new EnsamblajeDAL();
        /*Valida que las cedulas que se ingresaron asociadas al pedido de ensamblaje existan en
        los arraylist. Estas condicionales comparan el valor de retorno del metodo de busqueda de
        empleado/cliente y lo compara mediante el metodo .equals("") a una String vacia, pues este es
        el valor que retornan estos metodos cuando no encuentran la cedula*/
        if (empleado.BuscarEmpleado(ensamblaje.GetCedulaEmpleado()).GetCedula().equals(""))
            retVal=false;
        if (cliente.BuscarCliente(ensamblaje.GetCedulaCliente()).GetCedula().equals(""))
            retVal=false;
        if (retVal)
            dal.RealizarPedido(ensamblaje);
        return retVal;
    }
    
    public ArrayList<Ensamblaje> VerTodoEnsamblaje() throws Exception
    {
        EnsamblajeDAL dal = new EnsamblajeDAL();
        return dal.VerTodo();
    }
    
    public boolean ConfirmarPedido (int id) throws Exception
    {
        EnsamblajeDAL dal = new EnsamblajeDAL();
        return dal.ConfirmarPedido(id);
    }
    
    public boolean CancelarPedido (int id) throws Exception
    {
        EnsamblajeDAL dal = new EnsamblajeDAL();
        return dal.CancelarPedido(id);
    }
}
