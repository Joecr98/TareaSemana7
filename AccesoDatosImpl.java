/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.mdEmpleado;
import excepciones.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 *
 * @author Joe
 */
public class AccesoDatosImpl implements AccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<mdEmpleado> listar(String nombreArchivo) throws LecturaDatosEx {
        List<mdEmpleado> empleados = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                mdEmpleado empleado = new mdEmpleado(linea);
                empleados.add(empleado);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return empleados;
    }

    @Override
    public void escribir(mdEmpleado empleado, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(empleado.toString());
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "mdEmpleado: " + linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));  
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
