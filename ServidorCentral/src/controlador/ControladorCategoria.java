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

/**
 *
 * @author Sebastián Estefan
 */
public class ControladorCategoria implements IControladorCategoria {

    public ControladorCategoria() {
    }

    @Override
    public ArrayList<DataCategoria> listarCategorias() {
        return ManejadorCategoria.getInstance().listarCategorias();
    }

    @Override
    public void altaCategoria(String nombre) {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        mc.ingresarCategoria(new DataCategoria(nombre));
    }

    @Override
    public boolean existeCategoria(String nombre) {
        return ManejadorCategoria.getInstance().existeCategoriaNombre(nombre);
    }

}
