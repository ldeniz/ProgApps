
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataRestaurante complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataRestaurante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataUsuario">
 *       &lt;sequence>
 *         &lt;element name="rutaImagen" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataProductos" type="{http://servidor/}dataProducto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="puntajePromedio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="cantidadPuntuaciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataRestaurante", propOrder = {
    "rutaImagen",
    "dataProductos",
    "puntajePromedio",
    "cantidadPuntuaciones"
})
public class DataRestaurante
    extends DataUsuario
{

    @XmlElement(nillable = true)
    protected List<String> rutaImagen;
    @XmlElement(nillable = true)
    protected List<DataProducto> dataProductos;
    protected float puntajePromedio;
    protected int cantidadPuntuaciones;

    /**
     * Gets the value of the rutaImagen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rutaImagen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRutaImagen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRutaImagen() {
        if (rutaImagen == null) {
            rutaImagen = new ArrayList<String>();
        }
        return this.rutaImagen;
    }

    /**
     * Gets the value of the dataProductos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataProductos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataProductos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataProducto }
     * 
     * 
     */
    public List<DataProducto> getDataProductos() {
        if (dataProductos == null) {
            dataProductos = new ArrayList<DataProducto>();
        }
        return this.dataProductos;
    }

    /**
     * Gets the value of the puntajePromedio property.
     * 
     */
    public float getPuntajePromedio() {
        return puntajePromedio;
    }

    /**
     * Sets the value of the puntajePromedio property.
     * 
     */
    public void setPuntajePromedio(float value) {
        this.puntajePromedio = value;
    }

    /**
     * Gets the value of the cantidadPuntuaciones property.
     * 
     */
    public int getCantidadPuntuaciones() {
        return cantidadPuntuaciones;
    }

    /**
     * Sets the value of the cantidadPuntuaciones property.
     * 
     */
    public void setCantidadPuntuaciones(int value) {
        this.cantidadPuntuaciones = value;
    }

}
