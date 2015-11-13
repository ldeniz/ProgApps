/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qomobile;

import servidor.EnumEstado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Mathi
 */
@Entity
public class THistorial implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numero;
    private int estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;

    public int getNumero() {
        return numero;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;

    }

    public EnumEstado getEstado() {
        if(estado == 0){
            return EnumEstado.PREPARACION;
        }else if(estado == 1){
            return EnumEstado.ENVIADO;
        }else return EnumEstado.RECIBIDO;    
    }
    
    public Calendar getFecha() {
        return fecha;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setEstado(EnumEstado estado) {
        if(estado.toString().equals("PREPARACION")){
            this.estado = 0;
        }else if(estado.toString().equals("ENVIADO")){
            this.estado = 1;
        }else this.estado = 2;  
    }
}
