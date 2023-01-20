package Entidades;
import java.io.Serializable;

public class Detalles implements Serializable
{
    private int idDetalle;
    private int idPedido;
    private int idPlacaMadre;
    private int idProcesador;
    private int idEnfriamiento;
    private int idRam;
    private int cantidadRam;
    private int idGrafica;
    private int idCase;
    private int idUnidadAlmacenamiento;
    private int cantidadUnidades;
    private int idFuente;
    
    public int GetIdDetalle ()
    {
        return idDetalle;
    }
    public void SetIdDetalle (int idDetalle)
    {
        this.idDetalle = idDetalle;
    }
    public int GetIdPedido ()
    {
        return idPedido;
    }
    public void SetIdPedido (int idPedido)
    {
        this.idPedido = idPedido;
    }
    public int GetIdPlacaMadre ()
    {
        return idPlacaMadre;
    }
    public void SetIdPlacaMadre (int idPlacaMadre)
    {
        this.idPlacaMadre = idPlacaMadre;
    }
    public int GetIdProcesador ()
    {
        return idProcesador;
    }
    public void SetIdProcesador (int idProcesador)
    {
        this.idProcesador = idProcesador;
    }
    public int GetIdEnfriamiento ()
    {
        return idEnfriamiento;
    }
    public void SetIdEnfriamiento (int idEnfriamiento)
    {
        this.idEnfriamiento = idEnfriamiento;
    }
    public int GetIdRam ()
    {
        return idRam;
    }
    public void SetIdRam (int idRam)
    {
        this.idRam = idRam;
    }
    public int GetCantidadRam ()
    {
        return cantidadRam;
    }
    public void SetCantidadRam (int cantidadRam)
    {
        this.cantidadRam = cantidadRam;
    }
    public int GetIdGrafica ()
    {
        return idGrafica;
    }
    public void SetIdGrafica (int idGrafica)
    {
        this.idGrafica = idGrafica;
    }
    public int GetIdCase ()
    {
        return idCase;
    }
    public void SetIdCase (int idCase)
    {
        this.idCase = idCase;
    }
    public int GetUnidadAlmacenamiento ()
    {
        return idUnidadAlmacenamiento;
    }
    public void SetUnidadAlmacenamiento (int idUnidadAlmacenamiento)
    {
        this.idUnidadAlmacenamiento = idUnidadAlmacenamiento;
    }
    public int GetCantidadUnidades ()
    {
        return cantidadUnidades;
    }
    public void SetCantidadUnidades (int cantidadUnidades)
    {
        this.cantidadUnidades = cantidadUnidades;
    }
    public int GetIdFuente ()
    {
        return idFuente;
    }
    public void SetIdFuente (int idFuente)
    {
        this.idFuente = idFuente;
    }
}
