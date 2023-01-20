package Entidades;
import java.io.Serializable;
import java.io.Serializable;

public class FuentePoder implements Serializable
{
    private int id;
    private String descripcion;
    private int cantidadConectoresSATA;
    private int cantidadConectoresPCIe;
    private double potencia;
    private double altura;
    private double ancho;
    
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
    public int GetCantidadConectoresSATA ()
    {
        return cantidadConectoresSATA;
    }
    public void SetCantidadConectoresSATA (int cantidadConectoresSATA)
    {
        this.cantidadConectoresSATA = cantidadConectoresSATA;
    }
    public int GetCantidadConectoresPCIe ()
    {
        return cantidadConectoresPCIe;
    }
    public void SetCantidadConectoresPCIe (int cantidadConectoresPCIe)
    {
        this.cantidadConectoresPCIe = cantidadConectoresPCIe;
    }
    public double GetPotencia ()
    {
        return potencia;
    }
    public void SetPotencia (double potencia)
    {
        this.potencia = potencia;
    }
    public double GetAltura ()
    {
        return altura;
    }
    public void SetAltura (double altura)
    {
        this.altura = altura;
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
