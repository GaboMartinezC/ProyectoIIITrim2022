package BL;
import Entidades.Almacenamiento;
import DAL.AlmacenamientoDAL;       
import java.util.ArrayList;

public class AlmacenamientoBL 
{
    public ArrayList<Almacenamiento> BuscarAlmacenamiento (String descripcion) throws Exception
    {
        AlmacenamientoDAL dal = new AlmacenamientoDAL();
        return dal.BuscarAlmacenamiento(descripcion);
    }
    
    public ArrayList<Almacenamiento> BuscarTodos () throws Exception
    {
        AlmacenamientoDAL dal = new AlmacenamientoDAL();
        return dal.BuscarTodos();
    }
    
    public boolean Ingresar(Almacenamiento almacenamiento) throws Exception
    {
        boolean retVal = true;
        AlmacenamientoDAL dal = new AlmacenamientoDAL();
        //Valida que los datos de capacidad y consumo de energia no sean negativos
        if ((almacenamiento.GetCapacidad()<1)||(almacenamiento.GetConsumoEnergia()<1))
            retVal=false;
        if (retVal)
            dal.IngresarAlmacenamiento(almacenamiento);
        return retVal;
    }
    
    public boolean Actualizar (Almacenamiento almacenamiento) throws Exception
    {
        boolean retVal = true;
        AlmacenamientoDAL dal = new AlmacenamientoDAL();
        //Valida que los datos de capacidad y consumo de energia no sean negativos
        if ((almacenamiento.GetCapacidad()<1)||(almacenamiento.GetConsumoEnergia()<1))
            retVal=false;
        if (retVal)
            dal.ActualizarAlmacenamiento(almacenamiento);
        return retVal;
    }
}
