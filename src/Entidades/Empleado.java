package Entidades;
import java.io.Serializable;

public class Empleado implements Serializable
{
    private int idEmpleado;
    private String cedula;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private boolean puestoAdministrativo;
    
    public int GetIdEmpleado()
    {
        return idEmpleado;
    }
    public void SetIdEmpleado (int idEmpleado)
    {
        this.idEmpleado = idEmpleado;
    }
    public String GetCedula ()
    {
        return cedula;
    }
    public void SetCedula (String cedula)
    {
        this.cedula = cedula;
    }
    public String GetNombreCompleto ()
    {
        return nombreCompleto;
    }
    public void SetNombreCompleto (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;
    }
    public String GetTelefono ()
    {
        return telefono;
    }
    public void SetTelefono (String telefono)
    {
        this.telefono = telefono;
    }
    public String GetCorreo ()
    {
        return correo;
    }
    public void SetCorreo (String correo)
    {
        this.correo = correo;
    }
    public boolean GetPuestoAdministrativo()
    {
        return puestoAdministrativo;
    }
    public void SetPuestoAdministrativo (boolean puestoAdministrativo)
    {
        this.puestoAdministrativo = puestoAdministrativo;
    }
}
