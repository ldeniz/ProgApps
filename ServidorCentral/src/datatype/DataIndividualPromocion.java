/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

/**
 *
 * @author sestefan
 */
public class DataIndividualPromocion {

    private int cantidad;
    private DataIndividual individual;

    public DataIndividualPromocion(int cantidad, DataProducto individual) {
        this.cantidad = cantidad;
        this.individual = (DataIndividual) individual;
    }

    public int getCantidad() {
        return cantidad;
    }

    public DataIndividual getIndividual() {
        return individual;
    }

}
