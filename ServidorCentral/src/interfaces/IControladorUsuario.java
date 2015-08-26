package interfaces;

import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataRestaurante;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorUsuario {

    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String apellido, Date fechaNacimiento, String rutaImagen);

    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String[] rutaImagen);

    public void seleccionarCategoria(String name);

    public boolean existeUsuario(String nickname);

    public boolean existeMail(String mail);

    public boolean existeUsuario(String nickname, String mail);

    public void altaUsuario();

    public void limpiarMemoria();

    public ArrayList<DataCliente> listarClientes();

    public ArrayList<DataRestaurante> listarRestaurantes();

}
