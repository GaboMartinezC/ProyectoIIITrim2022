package GUI;
import BL.ArranqueBL;

public class inicio 
{
    public static void main(String[] args) 
    {
        ArranqueBL bl = new ArranqueBL();
        bl.Cargar();
        InicioSesion.Cargar();
    }
    
}
