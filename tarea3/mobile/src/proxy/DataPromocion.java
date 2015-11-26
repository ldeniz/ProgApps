
package proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataPromocion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataPromocion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataProducto">
 *       &lt;sequence>
 *         &lt;element name="descuento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activa" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="individualPromocion" type="{http://servidor/}dataIndividualPromocion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataPromocion", propOrder = {
    "descuento",
    "activa",
    "individualPromocion"
})
public class DataPromocion
    extends DataProducto
{

    protected int descuento;
    protected boolean activa;
    @XmlElement(nillable = true)
    protected List<DataIndividualPromocion> individualPromocion;

    /**
     * Obtiene el valor de la propiedad descuento.
     * 
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     * 
     */
    public void setDescuento(int value) {
        this.descuento = value;
    }

    /**
     * Obtiene el valor de la propiedad activa.
     * 
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Define el valor de la propiedad activa.
     * 
     */
    public void setActiva(boolean value) {
        this.activa = value;
    }

    /**
     * Gets the value of the individualPromocion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualPromocion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualPromocion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataIndividualPromocion }
     * 
     * 
     */
    public List<DataIndividualPromocion> getIndividualPromocion() {
        if (individualPromocion == null) {
            individualPromocion = new ArrayList<DataIndividualPromocion>();
        }
        return this.individualPromocion;
    }

}
