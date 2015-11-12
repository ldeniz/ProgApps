/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumEstado implements Serializable {

    PREPARACION, ENVIADO, RECIBIDO;

    public static EnumEstado getPREPARACION() {
        return PREPARACION;
    }

    public static EnumEstado getENVIADO() {
        return ENVIADO;
    }

    public static EnumEstado getRECIBIDO() {
        return RECIBIDO;
    }

}
