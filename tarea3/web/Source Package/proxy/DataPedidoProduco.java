
package proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataPedidoProduco complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataPedidoProduco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stockProduco" type="{http://servidor/}dataStockProducto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataPedidoProduco", propOrder = {
    "cantidad",
    "stockProduco"
})
public class DataPedidoProduco {

    protected int cantidad;
    protected DataStockProducto stockProduco;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad stockProduco.
     * 
     * @return
     *     possible object is
     *     {@link DataStockProducto }
     *     
     */
    public DataStockProducto getStockProduco() {
        return stockProduco;
    }

    /**
     * Define el valor de la propiedad stockProduco.
     * 
     * @param value
     *     allowed object is
     *     {@link DataStockProducto }
     *     
     */
    public void setStockProduco(DataStockProducto value) {
        this.stockProduco = value;
    }

}
