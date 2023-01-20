package BL;
import Entidades.Case;
import DAL.CaseDAL;        
import Entidades.FactorForma;
import DAL.FactorFormaDAL;
import java.util.ArrayList;

public class CaseBL 
{
    public ArrayList<Case> BuscarCase (String descripcion) throws Exception
    {
        CaseDAL dal = new CaseDAL();
        return dal.BuscarCase(descripcion);
    }
    
    public ArrayList<Case> BuscarTodos () throws Exception
    {
        CaseDAL dal = new CaseDAL();
        return dal.BuscarTodos();
    }
    
    public boolean Ingresar(Case gabinete) throws Exception
    {
        boolean retVal = false;
        FactorFormaDAL facForma = new FactorFormaDAL();
        CaseDAL dal = new CaseDAL();
        ArrayList<FactorForma> lista = facForma.BuscarTodos();
        /*Valida que el factor de forma que se ingresa asociado al Case sea válido y exista
        en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (FactorForma f: lista)
        {
            if (f.GetID()==gabinete.GetIdFactorForma())
                retVal=true;
        }
        if (retVal)
            dal.IngresarCase(gabinete);
        return retVal;
    }
    
    public boolean Actualizar (Case gabinete) throws Exception
    {
        boolean retVal = false;
        FactorFormaDAL facForma = new FactorFormaDAL();
        CaseDAL dal = new CaseDAL();
        ArrayList<FactorForma> lista = facForma.BuscarTodos();
        /*Valida que el factor de forma que se ingresa asociado al Case sea válido y exista
        en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (FactorForma f: lista)
        {
            if (f.GetID()==gabinete.GetIdFactorForma())
                retVal=true;
        }
        if (retVal)
            dal.ActualizarCase(gabinete);
        return retVal;
    }
}
