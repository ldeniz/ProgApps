/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qomobile;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mathi
 */
@Entity
public class TProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int numero;
    private String nombre;
    private int cantidad;
    private float precio;

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
        
    public float getPrecio() {
        return precio;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    
    }
    
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }        
}
