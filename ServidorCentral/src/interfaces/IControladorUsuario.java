package interfaces;

import datatype.DataDireccion;
import java.util.Date;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorUsuario {

    public void CargarDatosUsuario(String nickname, String mail, String nombre, DataDireccion direccion, String apellido, Date fechaNacimiento, String rutaImagen);

    public void CargarDatosUsuario(String nickname, String mail, String nombre, DataDireccion direccion, String[] rutaImagen);

    public void seleccionarCategoria(String name);

    public boolean existeUsuario(String nickname);
    
    public boolean existeMail(String mail);

    public boolean existeUsuario(String nickname, String mail);

    public void altaUsuario();
    
    public void limpiarMemoria();

}
