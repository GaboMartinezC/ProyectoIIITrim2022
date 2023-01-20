package BL;
import Entidades.FuentePoder;
import DAL.FuentePoderDAL;
import java.util.ArrayList;

public class FuentePoderBL 
{
    public ArrayList<FuentePoder> BuscarTodos() throws Exception
    {
        FuentePoderDAL dal = new FuentePoderDAL();
        return dal.BuscarTodos();
    }
    
    public ArrayList<FuentePoder> BuscarFuentePoder(String descripcion) throws Exception
    {
        FuentePoderDAL dal = new FuentePoderDAL();
        return dal.BuscarFuentePoder(descripcion);
    }
    
    public boolean IngresarFuentePoder (FuentePoder fuentePoder) throws Exception
    {
        boolean retVal= true;
        FuentePoderDAL dal = new FuentePoderDAL();
        //Valida que no hayan datos negativos
        if ((fuentePoder.GetAltura()<1)||(fuentePoder.GetAncho()<1)||(fuentePoder.GetCantidadConectoresPCIe()<1))
            retVal = false;
        if ((fuentePoder.GetCantidadConectoresPCIe()<1)||(fuentePoder.GetPotencia()<1))
            retVal = false;
        else
            dal.IngresarFuentePoder(fuentePoder);
        return retVal;
    }
    
    public boolean ActualizarFuentePoder (FuentePoder fuentePoder) throws Exception
    {
        boolean retVal = true;
        FuentePoderDAL dal = new FuentePoderDAL();
        //Valida que no hayan datos negativos
        if ((fuentePoder.GetAltura()<1)||(fuentePoder.GetAncho()<1)||(fuentePoder.GetCantidadConectoresPCIe()<1))
            retVal = false;
        if ((fuentePoder.GetCantidadConectoresPCIe()<1)||(fuentePoder.GetPotencia()<1))
            retVal = false;
        else
            dal.ActualizarFuentePoder(fuentePoder);
        return retVal;
    }
            
}
