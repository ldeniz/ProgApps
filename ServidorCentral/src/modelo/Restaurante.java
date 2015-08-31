/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataDireccion;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public class Restaurante extends Usuario implements Serializable {

    private String[] rutaImagen;
    private ArrayList<Producto> productos;

    public Restaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        productos = new ArrayList<>();
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String[] rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public DataUsuario obtenerDatosUsuario() {
        ArrayList<DataProducto> dataProductos = new ArrayList<>();

        if (!productos.isEmpty()) {
            for (Producto p : productos) {
                dataProductos.add(p.obtenerDatosProducto());
            }
        }
        DataUsuario dataUsuario = new DataRestaurante(rutaImagen, dataProductos, this.getNickname(), this.getMail(), this.getNombre(), this.getPass(), this.getDireccion());
        return dataUsuario;
    }

}
