package interfaces;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorProducto {

    /**
     * Carga en memoria los datos de un producto de tipo individual ingresados
     * por el usuario.
     *
     * @param nombre
     * @param descripcion
     * @param nicknameRestaurante
     * @param precio
     */
    public void cargarDatosProducto(String nombre, String descripcion, String nicknameRestaurante, float precio);

    /**
     * Carga en memoria los datos de un producto de tipo promoción ingresados
     * por el usuario.
     *
     * @param nombre
     * @param descripcion
     * @param nicknameRestaurante
     * @param descuento
     * @param rutaImagen
     */
    public void cargarDatosProducto(String nombre, String descripcion, String nicknameRestaurante, float descuento, String rutaImagen);

    /**
     * Retorna true si el producto 'nombre' existe en el restaurante 'nickName'
     *
     * @param nickName
     * @param nombre
     * @return
     */
    public boolean existeProducto(String nickName, String nombre);

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

}
