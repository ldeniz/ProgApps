
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dataPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nickNameCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nickNameRestaurante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaPedido" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="precioTotal" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="estado" type="{http://servidor/}enumEstado" minOccurs="0"/>
 *         &lt;element name="dataPedidoProducos" type="{http://servidor/}dataPedidoProduco" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataComentario" type="{http://servidor/}dataComentario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataPedido", propOrder = {
    "nickNameCliente",
    "nickNameRestaurante",
    "numero",
    "fechaPedido",
    "precioTotal",
    "estado",
    "dataPedidoProducos",
    "dataComentario"
})
public class DataPedido {

    protected String nickNameCliente;
    protected String nickNameRestaurante;
    protected int numero;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPedido;
    protected float precioTotal;
    protected EnumEstado estado;
    @XmlElement(nillable = true)
    protected List<DataPedidoProduco> dataPedidoProducos;
    protected DataComentario dataComentario;

    /**
     * Gets the value of the nickNameCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickNameCliente() {
        return nickNameCliente;
    }

    /**
     * Sets the value of the nickNameCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickNameCliente(String value) {
        this.nickNameCliente = value;
    }

    /**
     * Gets the value of the nickNameRestaurante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickNameRestaurante() {
        return nickNameRestaurante;
    }

    /**
     * Sets the value of the nickNameRestaurante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickNameRestaurante(String value) {
        this.nickNameRestaurante = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Gets the value of the fechaPedido property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Sets the value of the fechaPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPedido(XMLGregorianCalendar value) {
        this.fechaPedido = value;
    }

    /**
     * Gets the value of the precioTotal property.
     * 
     */
    public float getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Sets the value of the precioTotal property.
     * 
     */
    public void setPrecioTotal(float value) {
        this.precioTotal = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link EnumEstado }
     *     
     */
    public EnumEstado getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumEstado }
     *     
     */
    public void setEstado(EnumEstado value) {
        this.estado = value;
    }

    /**
     * Gets the value of the dataPedidoProducos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataPedidoProducos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataPedidoProducos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataPedidoProduco }
     * 
     * 
     */
    public List<DataPedidoProduco> getDataPedidoProducos() {
        if (dataPedidoProducos == null) {
            dataPedidoProducos = new ArrayList<DataPedidoProduco>();
        }
        return this.dataPedidoProducos;
    }

    /**
     * Gets the value of the dataComentario property.
     * 
     * @return
     *     possible object is
     *     {@link DataComentario }
     *     
     */
    public DataComentario getDataComentario() {
        return dataComentario;
    }

    /**
     * Sets the value of the dataComentario property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataComentario }
     *     
     */
    public void setDataComentario(DataComentario value) {
        this.dataComentario = value;
    }

}
