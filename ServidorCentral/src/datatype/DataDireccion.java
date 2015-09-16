/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datatype;

/**
 *
 * @author Sebastián Estefan
 */
public class DataDireccion {
    String calle;
    String numero_puerta;
    String apto;
    //TODO: dar soporte para cuidad de la costa

    public DataDireccion(String calle, String numero_puerta, String apto) {
        this.calle = calle;
        this.numero_puerta = numero_puerta;
        this.apto = apto;
    }

    public DataDireccion(DataDireccion dd){
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
}
