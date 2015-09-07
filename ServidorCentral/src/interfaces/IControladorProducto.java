package interfaces;

import datatype.DataProducto;
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
     *
     * @param nickName
     * @param nombre
     * @return
     */
    public DataProducto obtenerDatosRestauranteNombre(String nickName, String nombre);

    /**
     *
     * @param mombreViejo
     * @param nombre
     * @param descripcion
     * @param rutaImagen
     * @param precio
     */
    public void CargarDatosModificarProducto(String mombreViejo, String nombre, String descripcion,
            String rutaImagen, float precio);

    /**
     *
     * @param mombreViejo
     * @param nombre
     * @param descripcion
     * @param rutaImagen
     * @param descuento
     * @param activa
     */
    public void CargarDatosModificarProducto(String mombreViejo, String nombre, String descripcion,
            String rutaImagen, int descuento, boolean activa);

    /**
     * El sistema persiste una nueva instancia de producto.
     */
    public void altaProducto();

    /**
     *
     */
    public void ModificarProducto();

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
