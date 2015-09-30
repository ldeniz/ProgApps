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
    private int puntajePromedio;
    private int cantidadPuntuaciones;

    public Restaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
        productos = new ArrayList<>();
        puntajePromedio = 0;
        cantidadPuntuaciones = 0;
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getPuntajePromedio() {
        return puntajePromedio;
    }

    public void setPuntajePromedio(int puntajePromedio) {
        this.puntajePromedio = puntajePromedio;
    }

    public int getCantidadPuntuaciones() {
        return cantidadPuntuaciones;
    }

    public void setCantidadPuntuaciones(int cantidadPuntuaciones) {
        this.cantidadPuntuaciones = cantidadPuntuaciones;
    }
    
    public void calcularPromedioPuntaje(int puntaje){
        cantidadPuntuaciones = cantidadPuntuaciones + 1;
        puntajePromedio = (puntajePromedio + puntaje) / cantidadPuntuaciones;
    }

    @Override
    public DataUsuario obtenerDatosUsuario() {
        ArrayList<DataProducto> dataProductos = new ArrayList<>();

        if (!productos.isEmpty()) {
            for (Producto p : productos) {
                dataProductos.add(p.obtenerDatosProducto());
            }
        }
        DataUsuario dataUsuario = new DataRestaurante(rutaImagen, dataProductos, puntajePromedio, cantidadPuntuaciones, this.getNickname(), this.getMail(), this.getNombre(), this.getPass(), this.getDireccion());
        return dataUsuario;
    }

}
