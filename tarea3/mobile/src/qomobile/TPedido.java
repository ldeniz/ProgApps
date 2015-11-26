/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qomobile;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Mathi
 */
@Entity
public class TPedido implements Serializable {

    @Id
    private int numero;
    private String cliente;
    private float total;

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }
    
    public float getTotal() {
        return total;
    }
    
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
        
    public void setTotal(float total) {
        this.total = total;
    }

    
    
}
