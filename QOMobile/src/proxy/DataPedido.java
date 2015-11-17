
package proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataPedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    @XmlSchemaType(name = "string")
    protected EnumEstado estado;
    @XmlElement(nillable = true)
    protected List<DataPedidoProduco> dataPedidoProducos;
    protected DataComentario dataComentario;

    /**
     * Obtiene el valor de la propiedad nickNameCliente.
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
     * Define el valor de la propiedad nickNameCliente.
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
     * Obtiene el valor de la propiedad nickNameRestaurante.
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
     * Define el valor de la propiedad nickNameRestaurante.
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
     * Obtiene el valor de la propiedad numero.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPedido.
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
     * Define el valor de la propiedad fechaPedido.
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
     * Obtiene el valor de la propiedad precioTotal.
     * 
     */
    public float getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Define el valor de la propiedad precioTotal.
     * 
     */
    public void setPrecioTotal(float value) {
        this.precioTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
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
     * Define el valor de la propiedad estado.
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
     * Obtiene el valor de la propiedad dataComentario.
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
     * Define el valor de la propiedad dataComentario.
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
