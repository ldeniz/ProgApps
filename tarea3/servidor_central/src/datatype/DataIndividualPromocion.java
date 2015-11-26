/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataIndividualPromocion {

    private int cantidad;
    private DataIndividual individual;

    public DataIndividualPromocion() {
    }

    public DataIndividualPromocion(int cantidad, DataProducto individual) {
        this.cantidad = cantidad;
        this.individual = (DataIndividual) individual;
    }

    public DataIndividualPromocion(int i, DataStockProducto dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCantidad() {
        return cantidad;
    }

    public DataIndividual getIndividual() {
        return individual;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIndividual(DataIndividual individual) {
        this.individual = individual;
    }

}
