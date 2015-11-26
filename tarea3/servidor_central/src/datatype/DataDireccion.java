/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Sebastián Estefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataDireccion implements Serializable {

    String calle;
    String numero_puerta;
    String apto;
    //TODO: dar soporte para cuidad de la costa

    public DataDireccion() {
    }

    public DataDireccion(String calle, String numero_puerta, String apto) {
        this.calle = calle;
        this.numero_puerta = numero_puerta;
        this.apto = apto;
    }

    public DataDireccion(DataDireccion dd) {
        this.calle = dd.getCalle();
        this.numero_puerta = dd.getNumero_puerta();
        this.apto = dd.apto;
    }

    public String getApto() {
        return apto;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero_puerta() {
        return numero_puerta;
    }

    @Override
    public String toString() {
        return calle + " " + numero_puerta + " " + apto;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero_puerta(String numero_puerta) {
        this.numero_puerta = numero_puerta;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

}
