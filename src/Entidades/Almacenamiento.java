package Entidades;
import java.io.Serializable;

public class Almacenamiento implements Serializable
{
    private int id;
    private String descripcion;
    private int capacidad;
    private double consumoEnergia;
    private boolean m2;
    
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
    public boolean GetM2 ()
    {
        return m2;
    }
    public void SetM2 (boolean m2)
    {
        this.m2 = m2;
    }
}
