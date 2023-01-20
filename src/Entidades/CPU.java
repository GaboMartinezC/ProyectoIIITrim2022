package Entidades;
import java.io.Serializable;

public class CPU implements Serializable
{
    private int id;
    private String descripcion;
    private int idSocket;
    private double consumoEnergetico;
    
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
    public double GetConsumoEnergetico ()
    {
        return consumoEnergetico;
    }
    public void SetConsumoEnergetico (double consumoEnergetico)
    {
        this.consumoEnergetico = consumoEnergetico;
    }
}
