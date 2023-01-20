package Entidades;
import java.io.Serializable;

public class GPU implements Serializable
{
   private int id;
   private String descripcion;
   private int cantidadConectores;
   private boolean pcie16;
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
    public int GetCantidadConectores ()
    {
        return cantidadConectores;
    }
    public void SetCantidadConectores (int cantidadConectores)
    {
        this.cantidadConectores = cantidadConectores;
    }
    public boolean GetPcie16 ()
    {
        return pcie16;
    }
    public void SetPcie16 (boolean pcie16)
    {
        this.pcie16 = pcie16;
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
