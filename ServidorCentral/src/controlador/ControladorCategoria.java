/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataCategoria;
import datatype.DataRestaurante;
import interfaces.IControladorCategoria;
import java.util.ArrayList;
import manejador.ManejadorCategoria;
import modelo.Categoria;
import modelo.Restaurante;

/**
 *
 * @author Sebastián Estefan
 */
public class ControladorCategoria implements IControladorCategoria {

    public ControladorCategoria() {
    }

    @Override
    @SuppressWarnings("empty-statement")
    public ArrayList<DataCategoria> listarCategorias() {
        ArrayList<Categoria> categorias = ManejadorCategoria.getInstance().
                listarCategorias();
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();;
        if (!categorias.isEmpty()) {
            for (Categoria c : categorias) {
                dataCategorias.add(c.obtenerDatosCategoria());
            }
        }
        return dataCategorias;
    }

    @Override
    public void altaCategoria(String nombre) {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        mc.ingresarCategoria(new Categoria(nombre));
    }

    @Override
    public boolean existeCategoria(String nombre) {
        return ManejadorCategoria.getInstance().existeCategoriaNombre(nombre);
    }

    @Override
    public ArrayList<DataRestaurante> listarRestaurantes(String categoria) throws Exception {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        ArrayList<DataRestaurante> dataRestaurantes = null;
        if (mc.existeCategoriaNombre(categoria)) {
            ArrayList<Restaurante> lr = mc.obtenerRestaurantes(categoria);
            dataRestaurantes = new ArrayList<>();;
            if (!lr.isEmpty()) {
                for (Restaurante r : lr) {
                    dataRestaurantes.add((DataRestaurante) r.obtenerDatosUsuario());
                }
            }
        } else {
            throw new Exception("No existe categoria " + categoria);
        }
        return dataRestaurantes;
    }

}
