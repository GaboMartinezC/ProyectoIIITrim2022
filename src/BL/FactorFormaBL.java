package BL;
import Entidades.FactorForma;
import DAL.FactorFormaDAL;
import java.util.ArrayList;

public class FactorFormaBL 
{
    public ArrayList <FactorForma> BuscarTodos () throws Exception
    {
        FactorFormaDAL dal = new FactorFormaDAL();
        return dal.BuscarTodos();
    }
    
    public ArrayList <FactorForma> Buscar (String descripcion) throws Exception
    {
        FactorFormaDAL dal = new FactorFormaDAL();
        return dal.BuscarFactorForma(descripcion);
    }
    
    public boolean ActualizarFactorForma(FactorForma factorForma) throws Exception
    {
        boolean retVal;
        FactorFormaDAL dal = new FactorFormaDAL();
        //Valida que no se introduzcan datos negativos
        if ((factorForma.GetAncho()<1)||(factorForma.GetLargo()<1))
            retVal = false;
        else
            retVal = dal.ActualizarFactorForma(factorForma);
        return retVal;
    }
    
    public boolean IngresarFactorForma(FactorForma factorForma) throws Exception
    {
        boolean retVal;
        FactorFormaDAL dal = new FactorFormaDAL();
        //Valida que no se introduzcan datos negativos
        if ((factorForma.GetAncho()<1)||(factorForma.GetLargo()<1))
            retVal = false;
        else
            retVal = dal.IngresarFactorForma(factorForma);
        return retVal;
    }
    
}
