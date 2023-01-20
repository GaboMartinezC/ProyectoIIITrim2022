package Entidades;
import java.io.Serializable;

public class RAM implements Serializable
{
    private int id;
    private String descripcion;
    private int versionDDR;
    private int capacidad;
    private double consumoEnergia;
    
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
    public int GetVersionDDR ()
    {
        return versionDDR;
    }
    public void SetVersionDDR (int versionDDR)
    {
        this.versionDDR = versionDDR;
    }
    public int GetCapacidad ()
    {
        return capacidad;
    }
    public void SetCapacidad (int capacidad)
    {
        this.capacidad = capacidad;
    }
    public double GetConsumoEnergia ()
    {
        return consumoEnergia;
    }
    public void SetConsumoEnergia (double consumoEnergia)
    {
        this.consumoEnergia = consumoEnergia;
    }
}
