package DAL;
import Entidades.Empleado;
import java.util.ArrayList;
import java.io.*;

public class EmpleadoDAL 
{
    private static ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
    private String ruta ="/var/FichProyecto/Empleado.bin";
    
    public Empleado BuscarEmpleado (String cedulaEmpleado) throws Exception
    {
        Empleado empleado = new Empleado();
        empleado.SetCedula("");
        for(Empleado e: listaEmpleado)
        {
            if (e.GetCedula().equals(cedulaEmpleado))
            {
                empleado = e;
                break;
            }
        }
        return empleado;
    }
    
    public ArrayList<Empleado> BuscarTodos() throws Exception
    {
        return listaEmpleado;
    }
    
    public boolean IngresarEmpleado (Empleado empleado) throws Exception
    {
        boolean retVal;
        if (BuscarEmpleado(empleado.GetCedula()).GetCedula().equals(""))
        {
            //incrementa el id de cliente basado en el ultimo registro en el arreglo
            empleado.SetIdEmpleado(listaEmpleado.size()+1);
            listaEmpleado.add(empleado);
            Escribir();
            retVal = true;
        }
        else
        {
            retVal = false;
        }
        return retVal;
    }
    
    public boolean ActualizarEmpleado (Empleado empleado) throws Exception
    {
        boolean retVal = false;
        for(Empleado e: listaEmpleado)
        {
            if (e.GetCedula().equals(empleado.GetCedula()))
            {
                e.SetCedula(empleado.GetCedula());
                e.SetNombreCompleto(empleado.GetNombreCompleto());
                e.SetTelefono(empleado.GetTelefono());
                e.SetCorreo(empleado.GetCorreo());
                e.SetPuestoAdministrativo(empleado.GetPuestoAdministrativo());
                retVal = true;
                Escribir();
                break;
            }
        }
        return retVal;
    }    
    public boolean PrimerIngreso () throws Exception
    {
        boolean retVal = true;
        int contador=0;
        for (Empleado e: listaEmpleado)
        {
            if (e.GetPuestoAdministrativo())
                contador++;
        }
        if (contador<1)
            retVal = false;
        return retVal;
    }
    
    /*Metodo privado de acceso a la escritura de los datos, se encuentra encapsulado al solamente ser llamado
    desde metodos públicos, siento este privado. Escribe el ArrayList declarado globalmente, utilizando la variable
    ruta declarada globalmente*/
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaEmpleado);
        escribiendoArchivo.close();
    }
    /*Metodos de lectura de los datos, el metodo de lectura como tal se encuentra encapsulado en un metodo
    público. El metodo Leer crea un objeto File para determinar si este existe, si no, lo crea
    Posterior a esta condicional, carga los archivos desde los archivos en memoria secundaria a memoria primaria*/
    public void AccesoLeer () throws Exception
    {
        Leer();
    }
    private void Leer() throws Exception
    {
        File archivo = new File(ruta);
        if (!archivo.exists())
        {
            ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
            archivo.createNewFile();
            escribiendoArchivo.writeObject(listaEmpleado);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaEmpleado = (ArrayList<Empleado>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
