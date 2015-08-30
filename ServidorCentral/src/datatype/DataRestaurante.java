package datatype;

import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public class DataRestaurante extends DataUsuario {

    private String[] rutaImagen;
    private ArrayList<DataCategoria> dataCategorias;
    private ArrayList<DataProducto> dataProductos;

    public DataRestaurante(String[] rutaImagen, ArrayList<DataCategoria> dataCategorias, ArrayList<DataProducto> dataProductos, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        this.dataCategorias = dataCategorias;
        this.dataProductos = dataProductos;
    }

    public DataRestaurante(String[] rutaImagen, ArrayList<DataCategoria> dataCategorias, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        this.dataCategorias = dataCategorias;
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }

    public ArrayList<DataCategoria> getDataCategorias() {
        return dataCategorias;
    }

    public ArrayList<DataProducto> getDataProductos() {
        return dataProductos;
    }

}
