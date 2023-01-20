package BL;
import Entidades.CPU;
import Entidades.Socket;
import DAL.CpuDAL;     
import DAL.SocketDAL;
import java.util.ArrayList;

public class CpuBL 
{
    public ArrayList<CPU> BuscarTodos () throws Exception
    {
        CpuDAL dal = new CpuDAL();
        return dal.BuscarTodos();
    }
    
    public ArrayList<CPU> BuscarCPU(String descripcion) throws Exception
    {
        CpuDAL dal = new CpuDAL();
        return dal.BuscarCPU(descripcion);
    }
    
    public boolean IngresarCPU (CPU cpu) throws Exception
    {
        boolean retVal = false;
        CpuDAL dal = new CpuDAL();
        SocketDAL socDal = new SocketDAL();
        ArrayList<Socket> lista = socDal.BuscarTodos();
        /*Valida que el socket que se ingresa asociado al CPU sea válido y exista
        en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (Socket s: lista)
        {
            if (s.GetID()==cpu.GetIdSocket())
                retVal=true;
        }
        //Valida que no se ingrese un consumo de energia menor a 1 Watts
        if (cpu.GetConsumoEnergetico()<1)
            retVal=false;
        if (retVal)
            dal.IngresarCPU(cpu);
        return retVal;
    }
    
    public boolean ActualizarCPU (CPU cpu) throws Exception
    {
        boolean retVal = false;
        CpuDAL dal = new CpuDAL();
        SocketDAL socDal = new SocketDAL();
        ArrayList<Socket> lista = socDal.BuscarTodos();
        /*Valida que el socket que se ingresa asociado al CPU sea válido y exista
        en las arraylist, solamente permite el ingreso al DAL si esto es verdadero*/
        for (Socket s: lista)
        {
            if (s.GetID()==cpu.GetIdSocket())
                retVal=true;
        }
        //Valida que no se ingrese un consumo de energia menor a 1 Watts
        if (cpu.GetConsumoEnergetico()<1)
            retVal=false;
        if (retVal)
            dal.ActualizarCPU(cpu);
        return retVal;
    }
}
