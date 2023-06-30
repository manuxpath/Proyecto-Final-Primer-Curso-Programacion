/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencias;

import javax.swing.JFrame;

/**
 *
 * @author ShibaXpath
 */
// Clase abstracta Idiomas que extiende JFrame
public abstract class Idiomas extends JFrame {
    private boolean bandera;
    
    // Método abstracto para cambiar el idioma
    public abstract void cambiarIdioma(boolean idioma);

    // Getter para obtener el valor de la bandera
    public boolean isBandera() {
        return bandera;
    }

    // Setter para establecer el valor de la bandera
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    
    
}
