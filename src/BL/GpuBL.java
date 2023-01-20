package BL;
import Entidades.GPU;
import DAL.GpuDAL;
import java.util.ArrayList;

public class GpuBL 
{
    public ArrayList<GPU> BuscarGPU (String descripcion) throws Exception
    {
        GpuDAL dal = new GpuDAL();
        return dal.BuscarGPU(descripcion);
    }
    
    public ArrayList<GPU> BuscarTodos () throws Exception
    {
        GpuDAL dal = new GpuDAL();
        return dal.BuscarTodos();
    }
    
    public boolean Ingresar(GPU gpu) throws Exception
    {
        boolean retVal = true;
        GpuDAL dal = new GpuDAL();
        //Valida que no hayan datos negativos
        if (gpu.GetConsumoEnergia()<1)
            retVal=false;
        if (gpu.GetCantidadConectores()<1)
            retVal=false;
        if (retVal)
            dal.IngresarGPU(gpu);
        return retVal;
    }
    
    public boolean Actualizar (GPU gpu) throws Exception
    {
        boolean retVal = true;
        GpuDAL dal = new GpuDAL();
        //Valida que no hayan datos negativos
        if (gpu.GetCantidadConectores()>1)
            retVal=false;
        if (gpu.GetConsumoEnergia()<1)
            retVal=false;
        if (retVal)
            dal.IngresarGPU(gpu);
        return retVal;
    }
}
