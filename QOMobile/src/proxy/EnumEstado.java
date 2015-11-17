
package proxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enumEstado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="enumEstado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PREPARACION"/>
 *     &lt;enumeration value="ENVIADO"/>
 *     &lt;enumeration value="RECIBIDO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumEstado")
@XmlEnum
public enum EnumEstado {

    PREPARACION,
    ENVIADO,
    RECIBIDO;

    public String value() {
        return name();
    }

    public static EnumEstado fromValue(String v) {
        return valueOf(v);
    }

}
