package Entidades;
import java.io.Serializable;

public class Socket implements Serializable
{
    private int id;
    private String descripcion;
    private boolean lga;
    
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
    public boolean GetLGA ()
    {
        return lga;
    }
    public void SetLGA (boolean lga)
    {
        this.lga = lga;
    }
}
