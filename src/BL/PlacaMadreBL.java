package BL;
import DAL.PlacaMadreDAL;
import DAL.FactorFormaDAL;
import DAL.SocketDAL;
import Entidades.PlacaMadre;
import Entidades.FactorForma;
import Entidades.Socket; 
import java.util.ArrayList;

public class PlacaMadreBL 
{
    public ArrayList<PlacaMadre> BuscarTodos() throws Exception
    {
        PlacaMadreDAL dal = new PlacaMadreDAL();
        return dal.BuscarTodos();
    }
    
    public ArrayList<PlacaMadre> BuscarPlacaMadre(String descripcion) throws Exception
    {
        PlacaMadreDAL dal = new PlacaMadreDAL();
        return dal.BuscarPlacaMadre(descripcion);
    }
    
    public boolean IngresarPlacaMadre (PlacaMadre placa) throws Exception
    {
        boolean retVal = false;
        PlacaMadreDAL dal = new PlacaMadreDAL();
        SocketDAL socketDal= new SocketDAL();
        FactorFormaDAL facFormaDal = new FactorFormaDAL();
        ArrayList<Socket>  listaSoc = socketDal.BuscarTodos();
        ArrayList<FactorForma> listaFac = facFormaDal.BuscarTodos();
        /*Valida que el socket y el factor de forma que se ingresa asociado a la placa madre sea 
        válido y exista en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (Socket s: listaSoc)
        {
            if (s.GetID()==placa.GetIdSocket())
                retVal = true;
        }
        for (FactorForma f: listaFac)
        {
            if (f.GetID()==placa.GetIdFactorForma())
                retVal = true;
        }
        /*Valida que no hayan datos negativos mediante compuertas logicas OR, se deben de separar 4 condicionales
        por fines de legibilidad*/
        if ((placa.GetCantidadSATA()<1)||(placa.GetCantidadPCIe16()<1)||(placa.GetCantidadPCIe8()<1))
            retVal = false;
        if ((placa.GetCantidadSlotsRAM()<1)||(placa.GetLimiteRAM()<4)||(placa.GetConsumoEnergia()<1))
            retVal = false;
        if (!((placa.GetVersionDDR()>0)&&(placa.GetVersionDDR()<=5)))
            retVal = false; 
        if (retVal)
            dal.IngresarPlacaMadre(placa);
        return retVal;
    }
    
    public boolean ActualizarPlacaMadre (PlacaMadre placa) throws Exception
    {
        boolean retVal = false;
        PlacaMadreDAL dal = new PlacaMadreDAL();
        SocketDAL socketDal= new SocketDAL();
        FactorFormaDAL facFormaDal = new FactorFormaDAL();
        ArrayList<Socket>  listaSoc = socketDal.BuscarTodos();
        ArrayList<FactorForma> listaFac = facFormaDal.BuscarTodos();
        /*Valida que el socket y el factor de forma que se ingresa asociado a la placa madre sea 
        válido y exista en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (Socket s: listaSoc)
        {
            if (s.GetID()==placa.GetIdSocket())
                retVal = true;
        }
        for (FactorForma f: listaFac)
        {
            if (f.GetID()==placa.GetIdFactorForma())
                retVal = true;
        }
        /*Valida que no hayan datos negativos mediante compuertas logicas OR, se deben de separar 4 condicionales
        por fines de legibilidad*/
        if ((placa.GetCantidadSATA()<1)||(placa.GetCantidadPCIe16()<1)||(placa.GetCantidadPCIe8()<1))
            retVal = false;
        if ((placa.GetCantidadSlotsRAM()<1)||(placa.GetLimiteRAM()<4)||(placa.GetConsumoEnergia()<1))
            retVal = false;
        if (!((placa.GetVersionDDR()>0)&&(placa.GetVersionDDR()<=5)))
            retVal = false; 
        if (retVal)
            dal.ActualizarPlacaMadre(placa);
        return retVal;
    }
}
