package Entidades;
import java.io.Serializable;

public class FactorForma implements Serializable
{
    private int id;
    private String descripcion;
    private double ancho;
    private double largo;
    
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
    public double GetLargo ()
    {
        return largo;
    }
    public void SetLargo (double largo)
    {
        this.largo = largo;
    }
    public double GetAncho ()
    {
        return ancho;
    }
    public void SetAncho (double ancho)
    {
        this.ancho = ancho;
    }
}
