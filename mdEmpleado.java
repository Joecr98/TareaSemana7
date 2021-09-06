/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Joe
 */
public class mdEmpleado {

    private String NomEmpleado;
    private double Enero;
    private double Febrero;
    private double Marzo;
    private double Total;
    private double Promedio;

    public mdEmpleado(String nombre_emple) {
        this.NomEmpleado = nombre_emple;
    } 
    
    /**
     * @return the nombre
     */
    public String getNomEmpleado() {
        return NomEmpleado;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNomEmpleado(String nombre) {
        this.NomEmpleado = nombre;
    }

    /**
     * @return the Enero
     */
    public double getEnero() {
        return Enero;
    }

    /**
     * @param Enero the Enero to set
     */
    public void setEnero(double Enero) {
        this.Enero = Enero;
    }

    /**
     * @return the Febrero
     */
    public double getFebrero() {
        return Febrero;
    }

    /**
     * @param Febrero the Febrero to set
     */
    public void setFebrero(double Febrero) {
        this.Febrero = Febrero;
    }

    /**
     * @return the Marzo
     */
    public double getMarzo() {
        return Marzo;
    }

    /**
     * @param Marzo the Marzo to set
     */
    public void setMarzo(double Marzo) {
        this.Marzo = Marzo;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Enero + Febrero + Marzo;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }

    /**
     * @return the Promedio
     */
    public double getPromedio() {
        return ((Enero + Febrero + Marzo) / 3);
    }

    /**
     * @param Promedio the Promedio to set
     */
    public void setPromedio(double Promedio) {
        this.Promedio = Promedio;
    }

    
    @Override
    public String toString() {
        return this.getNomEmpleado();
    }
}
