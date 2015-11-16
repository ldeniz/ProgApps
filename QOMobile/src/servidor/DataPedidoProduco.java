
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataPedidoProduco complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the cantidad property.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the stockProduco property.
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
     * Sets the value of the stockProduco property.
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
