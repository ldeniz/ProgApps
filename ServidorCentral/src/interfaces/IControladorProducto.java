package interfaces;

import datatype.DataIndividual;
import datatype.DataProducto;
import datatype.DataPromocion;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorProducto {

    /**
     * Carga en memoria los datos de un producto ingresados por el usuario.
     *
     * @param nombre
     * @param descripcion
     * @param precio
     * @param rutaImagen
     */
    public void cargarDatosProducto(String nombre, String descripcion, float precio, String rutaImagen);

    /**
     * Carga en memoria los datos de un producto de tipo promoción ingresados
     * por el usuario.
     *
     * @param nombre
     * @param descripcion
     * @param descuento
     * @param rutaImagen
     */
    public void cargarDatosProducto(String nombre, String descripcion, int descuento, String rutaImagen);

    /**
     * Retorna true si el producto 'nombre' existe en el restaurante 'nickName'
     *
     * @param nickName
     * @param nombre
     * @return
     */
    public boolean existeProducto(String nickName, String nombre);

    /**
     * El sistema recuerda el restaurante
     *
     * @param nickName
     */
    public void seleccionarRestaurante(String nickName);

    /**
     * Agrega a la memoria un producto individual y su cantidad a asignar.
     *
     * @param nombre
     * @param cantidad
     */
    public void seleccionarProducto(String nombre, int cantidad);

    /**
     * Regresa el stock existente del producto individual 'nombre' del
     * restaurante 'nickname'
     *
     * @param nickName
     * @param nombre
     * @return
     */
    public int obtenerCantidadProductoIndividual(String nickName, String nombre);

    /**
     * El sistema persiste una nueva instancia de producto.
     */
    public void altaProducto();

    /**
     * Regresa una colección de productos
     *
     * @return
     */
    public ArrayList<DataProducto> listarProductos();

    /**
     * Limpia la memoria.
     */
    public void limpiarMemoria();

}
