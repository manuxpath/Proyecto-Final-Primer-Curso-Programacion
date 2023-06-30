/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import interfazgrafica.MensajesEnviar;
import interfazgrafica.MensajesRecibidos;
import conexion.ConexionBaseDatos;
import herencias.Idiomas;

/**
 *
 * @author ShibaXpath
 */
// Clase Mensajes que extiende de la clase Idiomas
public class Mensajes extends Idiomas {
    private String nombreUsuario, usuario;
    
    // Setter para establecer el nombre de usuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    // Setter para establecer el usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    // Método para recibir mensajes
    public void mensajesRecibir(ConexionBaseDatos cn) {
        // Crear una instancia de MensajesRecibidos
        MensajesRecibidos recibidos = new MensajesRecibidos();
        
        // Establecer la bandera del idioma según el valor de la superclase Idiomas
        recibidos.setBandera(super.isBandera());
        
        // Cambiar el idioma en la instancia de MensajesRecibidos según el valor de la bandera
        recibidos.cambiarIdioma(super.isBandera());
        
        // Establecer el nombre de usuario en la instancia de MensajesRecibidos
        recibidos.setNombreUsuario(nombreUsuario);
        
        // Obtener y establecer los datos de mensajes y usuarios en la instancia de MensajesRecibidos
        recibidos.setCampoUser1(cn.devolverMensaje1(nombreUsuario));
        recibidos.setUser1(cn.devolverUser1(nombreUsuario));
        recibidos.setFoto1(cn.devolverSexo(cn.devolverUser1(nombreUsuario)));
        
        recibidos.setCampoUser2(cn.devolverMensaje2(nombreUsuario));
        recibidos.setUser2(cn.devolverUser2(nombreUsuario));
        recibidos.setFoto2(cn.devolverSexo(cn.devolverUser2(nombreUsuario)));
        
        recibidos.setCampoUser3(cn.devolverMensaje3(nombreUsuario));
        recibidos.setUser3(cn.devolverUser3(nombreUsuario));
        recibidos.setFoto3(cn.devolverSexo(cn.devolverUser3(nombreUsuario)));
        
        // Hacer visible la instancia de MensajesRecibidos
        recibidos.setVisible(true);
    }
    
    // Método para enviar mensajes
    public void mensajesEnviar() {
        // Crear una instancia de MensajesEnviar
        MensajesEnviar enviar = new MensajesEnviar();
        
        // Establecer la bandera del idioma según el valor de la superclase Idiomas
        enviar.setBandera(super.isBandera());
        
        // Cambiar el idioma en la instancia de MensajesEnviar según el valor de la bandera
        enviar.cambiarIdioma(super.isBandera());
        
        // Establecer el nombre de usuario en la instancia de MensajesEnviar
        enviar.setNombreUsuario(nombreUsuario);
        
        // Establecer el usuario a quien se enviará el mensaje en la instancia de MensajesEnviar
        enviar.setUsuarioEnviar(usuario);
        
        // Hacer visible la instancia de MensajesEnviar
        enviar.setVisible(true);
    }

    // Método para cambiar el idioma (sobrescrito de la superclase Idiomas)
    @Override
    public void cambiarIdioma(boolean idioma) {
        // Aquí se puede implementar la lógica para cambiar el idioma de la interfaz de usuario
        // Dependiendo del valor del parámetro "idioma"
    }
    
}

