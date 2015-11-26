/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qomobile;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author hernan.winter
 */
public class Propiedades {
    private static Propiedades INSTANCE = new Propiedades();
    
    public static Propiedades getInstance(){
        return INSTANCE;
    }
    
    public Service obtenerService(String servicio) throws FileNotFoundException {
          try {
              String propFileName = "config.properties";
              String homeDir = System.getProperty("user.home");
              String ruta = homeDir + "/.Quick Order";

              File file = new File(ruta);  
              URL[] urls = {file.toURI().toURL()};  
              ClassLoader loader = new URLClassLoader(urls);  
              ResourceBundle props = ResourceBundle.getBundle("config", Locale.getDefault(), loader);  

              if (props == null) {
                  throw new FileNotFoundException("property file '" + ruta + propFileName + "' not found in the classpath");
              }
              URL wsdlLocation = new URL(props.getString(servicio));
              QName serviceName = new QName(props.getString("wsdlDocumentLocation"), servicio + "Service");
              return Service.create(wsdlLocation, serviceName);


          } catch (MalformedURLException ex) {
              Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
     }
}
