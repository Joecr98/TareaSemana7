/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;
import negocio.*;

/**
 *
 * @author Joe
 */
public class ClsPrincipal {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\Joe\\Documents\\ArchivosNetBeans\\DB_Empleados.txt";
    private static final RegEmpleados infoEmpleados = new RegEmpleadosImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegEmpleadosImpl comi = new RegEmpleadosImpl();
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar DB_Empleados.txt"
                        + "\n2.- Agregar Empleados\n"
                        + "3.- Listar Empleados\n"
                        + "4.- Buscar Empleado\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        //Inicializamos nuestro archivo de texto
                        infoEmpleados.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //Agregar informacion archivo                  
                        System.out.println("|FORMATO: ---------------------------------------------------|");
                        System.out.println("|-------- NOMBRE,DATO_ENERO,DATO_FEBRERO,DATO_MARZO ---------|");
                        System.out.println("|------------------------------------------------------------|");
                        System.out.println("Ingresa la información del empleado, guíate del formato:");
                        String nombre = scanner.nextLine();
                        infoEmpleados.agregarEmpleado(nombre, nombreArchivo);
                        break;
                    case 3:
                        //Listar DB_Empleados.txt completo
                        infoEmpleados.listarEmpleado(nombreArchivo);
                        break;
                    case 4:
                        //Buscar Empleado
                        System.out.println("Introduce el nombre del Empleado a buscar:");
                        String buscar = scanner.nextLine();
                        infoEmpleados.buscarEmpleado(nombreArchivo, buscar);
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }//cierra while
}//FIN CLASE
