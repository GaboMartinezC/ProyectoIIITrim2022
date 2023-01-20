package BL;
import Entidades.Empleado;
import DAL.EmpleadoDAL;        
import java.util.ArrayList;

public class EmpleadoBL 
{
    public Empleado BuscarEmpleado(String cedulaEmpleado) throws Exception
    {
        EmpleadoDAL dal = new EmpleadoDAL();
        return dal.BuscarEmpleado(cedulaEmpleado);
    }
    public ArrayList<Empleado> BuscarTodos() throws Exception
    {
        EmpleadoDAL dal = new EmpleadoDAL();
        return dal.BuscarTodos();
    }
    public boolean IngresarEmpleado (Empleado empleado) throws Exception
    {
        EmpleadoDAL dal = new EmpleadoDAL();
        return dal.IngresarEmpleado(empleado);
    }
    public boolean ActualizarEmpleado (Empleado empleado) throws Exception
    {
        EmpleadoDAL dal = new EmpleadoDAL();
        return dal.ActualizarEmpleado(empleado);
    }
    public boolean PrimerIngreso () throws Exception
    {
        EmpleadoDAL dal = new EmpleadoDAL();
        return dal.PrimerIngreso();
    }
}
