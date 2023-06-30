/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencias;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ShibaXpath
 */
// Clase TratamientoPassword
public class TratamientoPassword {
    // Método para encriptar una contraseña utilizando el algoritmo SHA-512
    public String encryptPassword(String password) {
        try {
            // Obtener una instancia de MessageDigest con el algoritmo SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            
            // Actualizar el objeto MessageDigest con los bytes de la contraseña
            md.update(password.getBytes());
            
            // Calcular el hash de la contraseña en forma de bytes
            byte[] bytes = md.digest();
            
            // Convertir los bytes del hash en una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            // Devolver la representación hexadecimal del hash de la contraseña
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // En caso de que no se encuentre el algoritmo SHA-512, devolver null
            return null;
        }
    }
}
