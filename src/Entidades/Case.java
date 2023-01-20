package Entidades;
import java.io.Serializable;

public class Case implements Serializable
{
    private int id;
    private String descripcion;
    private int idFactorForma;
    private boolean refrigeracionLiquida;
    
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
    public int GetIdFactorForma ()
    {
        return idFactorForma;
    }
    public void SetIdFactorForma (int idFactorForma)
    {
        this.idFactorForma = idFactorForma;
    }
    public boolean GetRefrigeracionLiquida ()
    {
        return refrigeracionLiquida;
    }
    public void SetRefrigeracionLiquida (boolean refrigeracionLiquida)
    {
        this.refrigeracionLiquida = refrigeracionLiquida;
    }
}
