/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataIndividualPromocion;

/**
 *
 * @author sestefan
 */
public class IndividualPromocion {

    private int cantidad;
    private Individual individual;

    public IndividualPromocion(int cantidad, Individual individual) {
        this.cantidad = cantidad;
        this.individual = individual;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public DataIndividualPromocion obtenerDatosIndividualPromocion() {
        return new DataIndividualPromocion(cantidad, individual.obtenerDatosProducto());
    }

}
