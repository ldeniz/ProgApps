package datatype;

/**
 *
 * @author sestefan
 */
public class DataRestaurante extends DataUsuario{
    
    private String[] rutaImagen;

    public DataRestaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }
    
}
