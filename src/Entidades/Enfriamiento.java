package Entidades;
import java.io.Serializable;

public class Enfriamiento implements Serializable
{
    private int id;
    private String descripcion;
    private int idSocket;
    private boolean liquido;
    
    public int GetID ()
    {
        return id;
    }
    public void SetID (int id)
    {
        this.id = id;
    }
    public String GetDescripcion ()
    {
        return descripcion;
    }
    public void SetDescripcion (String descripcion)
    {
        this.descripcion = descripcion;
    }
    public int GetIdSocket ()
    {
        return idSocket;
    }
    public void SetIdSocket (int idSocket)
    {
        this.idSocket = idSocket;
    }
    public boolean GetLiquido ()
    {
        return liquido;
    }
    public void SetLiquido (boolean liquido)
    {
        this.liquido = liquido;
    }
}
