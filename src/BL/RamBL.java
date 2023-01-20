package BL;
import Entidades.RAM;
import DAL.RamDAL;
import java.util.ArrayList;

public class RamBL 
{
    public ArrayList<RAM> BuscarTodos() throws Exception
    {
        RamDAL dal = new RamDAL();
        return dal.BuscarTodos();
    }
    
    public ArrayList<RAM> BuscarRAM(String descripcion) throws Exception
    {
        RamDAL dal = new RamDAL();
        return dal.BuscarRAM(descripcion);
    }
    
    public boolean IngresarRAM (RAM ram) throws Exception
    {
        RamDAL dal = new RamDAL();
        boolean retVal=false;
        /*Introduce en un arreglo las potencias del 2 que actualmente son posibles
        para ser el dato de la capacidad de una memoria RAM, la memoria más grande
        que se puede encontrar es de 128 Gb*/
        int[] capacidades = {2,4,8,16,32,64,128};
        for (int i=0;i<7;i++)
        {
            if (ram.GetCapacidad()==capacidades[i])
                retVal=true;
        }
        //Valida la version de DDR, al momento, existe la DDR5
        if ((ram.GetVersionDDR()<1)&&(ram.GetVersionDDR()>5))
            retVal=false;
        if (retVal)
            dal.IngresarRAM(ram);
        return retVal;
    }
    
    public boolean ActualizarRAM (RAM ram) throws Exception
    {
        RamDAL dal = new RamDAL();
        boolean retVal = false;
        /*Introduce en un arreglo las potencias del 2 que actualmente son posibles
        para ser el dato de la capacidad de una memoria RAM, la memoria más grande
        que se puede encontrar es de 128 Gb*/
        int[] capacidades = {2,4,8,16,32,64,128};
        for (int i=0;i<7;i++)
        {
            if (ram.GetCapacidad()==capacidades[i])
                retVal=true;
        }
        //Valida la version de DDR, al momento, existe la DDR5
        if ((ram.GetVersionDDR()<1)&&(ram.GetVersionDDR()>5))
            retVal=false;
        if (retVal)
            dal.ActualizarRAM(ram);
        return retVal;
    }
}
