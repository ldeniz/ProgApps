/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral;

import datatype.DataCategoria;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sestefan
 */
public class ServidorCentral {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        IControladorCategoria categoria = Fabrica.getInstance().obtenerControladorCategoria();
        ArrayList<DataCategoria> dataCategorias = null;
        categoria.altaCategoria("nueva");
        categoria.altaCategoria("nueva1");
        categoria.altaCategoria("nueva2");
        
        // Creación de BufferedReader para facilitar la lectura.
        @SuppressWarnings("UnusedAssignment")
        String nombre = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            // Lectura de un entero
            System.out.println("Igrese categoria:");
            nombre = br.readLine();
            if (categoria.existeCategoria(nombre)){
                System.out.println("La categoria \'" + nombre + "\' ya existe");
            }else{
                categoria.altaCategoria(nombre);
                System.out.println("Se cargó correctamente la categoría: " + nombre);
                System.out.println("Las categorías del sistema son:");
                dataCategorias = categoria.listarCategorias();
                for (DataCategoria dataCategoria : dataCategorias){
                    System.out.println(dataCategoria.getNombre());
                }
            }

        }catch (IOException | NumberFormatException e)
        {
           System.out.print ("Explotó");
        }

    }
    */
}
