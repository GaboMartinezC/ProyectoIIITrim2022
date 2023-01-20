package Entidades;
import java.io.Serializable;

public class PlacaMadre implements Serializable
{
    private int id;
    private String descripcion;
    private int idFactorForma;
    private int idSocket;
    private int cantidadSATA;
    private int cantidadPCIe16;
    private int cantidadPCIe8;
    private int versionDDR;
    private int cantidadSlotsRAM;
    private int limiteRAM;
    private int cantidadM2;
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
    public int GetIdFactorForma ()
    {
        return idFactorForma;
    }
    public void SetIdFactorForma (int idFactorForma)
    {
        this.idFactorForma = idFactorForma;
    }
    public int GetIdSocket ()
    {
        return idSocket;
    }
    public void SetIdSocket (int idSocket)
    {
        this.idSocket = idSocket;
    }
    public int GetCantidadSATA ()
    {
        return cantidadSATA;
    }
    public void SetCantidadSATA (int cantidadSATA)
    {
        this.cantidadSATA = cantidadSATA;
    }
    public int GetCantidadPCIe16 ()
    {
        return cantidadPCIe16;
    }
    public void SetCantidadPCIe16 (int cantidadPCIe16)
    {
        this.cantidadPCIe16 = cantidadPCIe16;
    }
    public int GetCantidadPCIe8 ()
    {
        return cantidadPCIe8;
    }
    public void SetCantidadPCIe8 (int cantidadPCIe8)
    {
        this.cantidadPCIe8 = cantidadPCIe8;
    }
    public int GetVersionDDR ()
    {
        return versionDDR;
    }
    public void SetVersionDDR (int versionDDR)
    {
        this.versionDDR = versionDDR;
    }
    public int GetCantidadSlotsRAM ()
    {
        return cantidadSlotsRAM;
    }
    public void SetCantidadSlotsRAM(int cantidadSlotsRAM)
    {
        this.cantidadSlotsRAM = cantidadSlotsRAM;
    }
    public int GetLimiteRAM ()
    {
        return limiteRAM;
    }
    public void SetLimiteRAM (int limiteRAM)
    {
        this.limiteRAM = limiteRAM;
    }
    public int GetCantidadM2 ()
    {
        return cantidadM2;
    }
    public void SetCantidadM2 (int cantidadM2)
    {
        this.cantidadM2 = cantidadM2;
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
