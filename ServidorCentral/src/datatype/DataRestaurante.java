package datatype;

import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public class DataRestaurante extends DataUsuario {

    private String[] rutaImagen;
    private ArrayList<DataProducto> dataProductos;

    public DataRestaurante(String[] rutaImagen, ArrayList<DataProducto> dataProductos, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        this.dataProductos = dataProductos;
    }

    public DataRestaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }

    public ArrayList<DataProducto> getDataProductos() {
        return dataProductos;
    }

}
