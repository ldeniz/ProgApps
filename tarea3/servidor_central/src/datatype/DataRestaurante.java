package datatype;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataRestaurante extends DataUsuario {

    private String[] rutaImagen;
    private ArrayList<DataProducto> dataProductos;
    private float puntajePromedio;
    private int cantidadPuntuaciones;

    public DataRestaurante() {                  
    }

    public DataRestaurante(String[] rutaImagen, ArrayList<DataProducto> dataProductos, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        this.dataProductos = dataProductos;
    }

    public DataRestaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
    }

    public DataRestaurante(String[] rutaImagen, ArrayList<DataProducto> dataProductos, float puntajePromedio, int cantidadPuntaje, String nickname, String mail, String nombre, String pass, DataDireccion direccion, ArrayList<DataPedido> dataPedidos) {
        super(nickname, mail, nombre, pass, direccion, dataPedidos);
        this.rutaImagen = rutaImagen;
        this.dataProductos = dataProductos;
        this.puntajePromedio = puntajePromedio;
        this.cantidadPuntuaciones = cantidadPuntaje;
    }

    public float getPuntajePromedio() {
        return puntajePromedio;
    }

    public int getCantidadPuntuaciones() {
        return cantidadPuntuaciones;
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }

    public ArrayList<DataProducto> getDataProductos() {
        return dataProductos;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public void setRutaImagen(String[] rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setDataProductos(ArrayList<DataProducto> dataProductos) {
        this.dataProductos = dataProductos;
    }

    public void setPuntajePromedio(float puntajePromedio) {
        this.puntajePromedio = puntajePromedio;
    }

    public void setCantidadPuntuaciones(int cantidadPuntuaciones) {
        this.cantidadPuntuaciones = cantidadPuntuaciones;
    }

}
