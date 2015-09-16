package interfaces;

import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorUsuario {

    /**
     * Carga en memoria los datos de un cliente ingresados por el usuario.
     *
     * @param nickname
     * @param mail
     * @param nombre
     * @param pass
     * @param direccion
     * @param apellido
     * @param fechaNacimiento
     * @param rutaImagen
     */
    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String apellido, Date fechaNacimiento, String rutaImagen);

    /**
     * Carga en memoria los datos de un restaurante ingresados por el usuario.
     *
     * @param nickname
     * @param mail
     * @param nombre
     * @param pass
     * @param direccion
     * @param rutaImagen
     * @throws java.lang.Exception
     *
     * @
     */
    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String[] rutaImagen) throws Exception;

    /**
     * Agrega a la memoria una categoria
     *
     * @param name
     */
    public void seleccionarCategoria(String name);

    /**
     * Valida si el usuario con nickname @nickname existe.
     *
     * @param nickname
     * @return
     */
    public boolean existeUsuario(String nickname);

    /**
     * Valida si el usuario con nickname
     *
     * @param nickname
     * @param mail
     * @return
     */
    public boolean existeUsuario(String nickname, String mail);

    /**
     * Impacta los datos cargados en memoria en el sistema.
     */
    public void altaUsuario();

    /**
     * Limpia la memoria de los datos cargados.
     */
    public void limpiarMemoria();

    /**
     * Retorna una lista de los clientes existentes en el sistema.
     *
     * @return
     */
    public ArrayList<DataCliente> listarClientes();

    /**
     * Retorna una lista de los Restaurantes existenes en el sistema
     *
     * @return
     */
    public ArrayList<DataRestaurante> listarRestaurantes();

    /**
     * Retorna una lista de todos los usuarios existenes en el sistema
     *
     * @return
     */
    public ArrayList<DataUsuario> listarUsaurios();

    /**
     * Retorna una lista de todos los productos existenes en el sistema del
     * restaurante 'nickName'
     *
     * @param nickName
     * @return
     */
    public ArrayList<DataProducto> listarProductos(String nickName);

    public ArrayList<DataPedido> listarPedidosCliente(String nickName);

}
