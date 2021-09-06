/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.mdEmpleado;
import excepciones.*;
import java.util.*;

/**
 *
 * @author Joe
 */
public class RegEmpleadosImpl implements RegEmpleados {

    private final AccesoDatos datos;

    public RegEmpleadosImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarEmpleado(String nomEmpleado, String nombreArchivo) {
        mdEmpleado emple = new mdEmpleado(nomEmpleado);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(emple, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarEmpleado(String nombreArchivo) {

        try {
            List<mdEmpleado> emples = datos.listar(nombreArchivo);
            for (mdEmpleado emple : emples) {
                System.out.println("Empleado: " + emple);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarEmpleado(String nombreArchivo, String buscar) {
        String resultado = null;
        try {

            resultado = datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar Empleado");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado Busqueda:" + resultado);

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {

        try {
            if (datos.existe(nombreArchivo)) {
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }

    }

}//Fin clase
