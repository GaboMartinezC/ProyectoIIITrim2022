package Entidades;
import java.io.Serializable;

public class Cliente implements Serializable
{
    private int idCliente;
    private String cedula;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    
    public int GetIdCliente()
    {
        return idCliente;
    }
    public void SetIdCliente (int idCliente)
    {
        this.idCliente = idCliente;
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
}
