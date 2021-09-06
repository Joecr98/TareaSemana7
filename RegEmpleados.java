/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Joe
 */
public interface RegEmpleados {

    public void agregarEmpleado(String nomEmpleado, String nombreArchivo);

    public void listarEmpleado(String nombreArchivo);

    public void buscarEmpleado(String nombreArchivo, String buscar);

    public void iniciarArchivo(String nombreArchivo);

}
