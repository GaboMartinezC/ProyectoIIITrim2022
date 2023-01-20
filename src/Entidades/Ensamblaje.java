package Entidades;
import java.io.Serializable;

public class Ensamblaje implements Serializable
{
    private int id;
    private String cedulaEmpleado;
    private String cedulaCliente;
    private String fecha;
    private boolean cancelado = false;
    private boolean confirmado = false;
    
    public int GetID ()
    {
        return id;
    }
    public void SetID (int id)
    {
        this.id = id;
    }
    public String GetCedulaEmpleado ()
    {
        return cedulaEmpleado;
    }
    public void SetCedulaEmpleado (String cedulaEmpleado)
    {
        this.cedulaEmpleado = cedulaEmpleado;
    }
    public String GetCedulaCliente ()
    {
        return cedulaCliente;
    }
    public void SetCedulaCliente (String cedulaCliente)
    {
        this.cedulaCliente = cedulaCliente;
    }
    public String GetFecha ()
    {
        return fecha;
    }
    public void SetFecha (String fecha)
    {
        this.fecha = fecha;
    }
    public boolean GetCancelado ()
    {
        return cancelado;
    }
    public void SetCancelado (boolean cancelado)
    {
        this.cancelado = cancelado;
    }
    public boolean GetConfirmado ()
    {
        return confirmado;
    }
    public void SetConfirmado (boolean confirmado)
    {
        this.confirmado = confirmado;
    }
}
