/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import herencias.TratamientoPassword;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ShibaXpath
 */
public class ConexionBaseDatos extends TratamientoPassword {


    /*
    ------------------------------------------
    |  Método para conectar la Base de datos|
    ------------------------------------------
     */
//Permite establecer la conexión con la base de datos
    private static Connection conectar() {
        try
        {
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectobomberos", "root", "12345");
            return cn;
        } catch (SQLException e)
        {
            System.err.println("Error en la conexión local " + e);
        }
        return null;
    }

    /*
    -----------------------------------------
    |  Método para la insercción de usuarios|
    -----------------------------------------
     */
    //Método para insertar usuarios en la base de datos
    public void insertarUsuarios(String usuario, String pass, String email, String rango, String sexo, String pais, String mensaje1, String mensaje2, String mensaje3, String user1, String user2, String user3,double salario, int horas) {
        String insertar = "INSERT INTO usuarios(USUARIO,CONTRA,EMAIL,RANGO,SEXO,PAIS,MENSAJE1,MENSAJE2,MENSAJE3, USER1,USER2,USER3,SALARIO,HORASVOLUNTARIO)VALUES( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String encryptedPassword = encryptPassword(pass);
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement inserccion = cn.prepareStatement(insertar);
            inserccion.setString(1, usuario);
            inserccion.setString(2, encryptedPassword);
            inserccion.setString(3, email);
            inserccion.setString(4, rango);
            inserccion.setString(5, sexo);
            inserccion.setString(6, pais);
            inserccion.setString(7, mensaje1);
            inserccion.setString(8, mensaje2);
            inserccion.setString(9, mensaje3);
            inserccion.setString(10, user1);
            inserccion.setString(11, user2);
            inserccion.setString(12, user3);
            inserccion.setDouble(13, salario);
            inserccion.setInt(14, horas);
            inserccion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al insertar." + e);
        }
    }

    /*
    --------------------------------------------
    |  Métodos para la comprobación de usuarios|
    --------------------------------------------
     */
    public boolean comprobarUsuario(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT USUARIO FROM USUARIOS");
            ResultSet rs = obtener.executeQuery();
            boolean bandera = false;
            while (rs.next())
            {
                if (rs.getString(1).equals(user))
                {
                    bandera = true;
                    break;
                }
            }
            cn.close();
            return bandera;
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }
        return false;
    }

    public boolean comprobarPass(String usuario, String pass) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT CONTRA FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, usuario);
            ResultSet rs = obtener.executeQuery();

            boolean bandera = false;

            if (rs.next())
            {
                String passBD = rs.getString(1);

                if (passBD.equals(pass))
                {
                    bandera = true;
                }
            }

            cn.close();
            return bandera;
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return false;
    }

    /*
    ----------------------------------------------
    |  Métodos para la devolver datos de usuarios|
    ----------------------------------------------
     */
    //Método que devuelve el email del usuario
    public String devolverEmail(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT EMAIL FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el sexo del usuario
    public String devolverSexo(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT SEXO FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    public String devolverSexoUser1(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT SEXOUSER1 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el rango del usuario
    public String devolverRango(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT RANGO FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    /*
    --------------------------------------------
    |  Método para la modificación de usuarios|
    --------------------------------------------
     */
    //Método para modificar usuarios en la base de datos
    public void modificarUsuarios(String usuario, String nuevoSexo, String nuevoEmail, String nuevoRango, String pass) {
        String actualizar = "UPDATE USUARIOS SET SEXO=?, EMAIL=?, RANGO=?, CONTRA=? WHERE USUARIO=?";
        String encryptedPassword = encryptPassword(pass);
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, nuevoSexo);
            actualizacion.setString(2, nuevoEmail);
            actualizacion.setString(3, nuevoRango);
            actualizacion.setString(4, encryptedPassword);
            actualizacion.setString(5, usuario);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    /*
    -------------------------------------------------------------
    |  Métodos para devolver los mensajes y usuarios del mensaje|
    -------------------------------------------------------------
     */
    //Método que devuelve el mensaje del usuario 1
    public String devolverMensaje1(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT MENSAJE1 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el usuario del mensaje 1
    public String devolverUser1(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT USER1 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el usuario del mensaje 1
    public String devolverFoto(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT SEXO FROM USUARIOS WHERE USER1=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);
            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return ""; // Devuelve una cadena vacía en lugar de null
    }

    //Método que devuelve el mensaje del usuario 2
    public String devolverMensaje2(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT MENSAJE2 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el usuario del mensaje 1
    public String devolverUser2(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT USER2 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el mensaje del usuario 3
    public String devolverMensaje3(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT MENSAJE3 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    //Método que devuelve el usuario del mensaje 1
    public String devolverUser3(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT USER3 FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return null;
    }

    /*
    -------------------------------------------------------------
    |  Métodos para modificar los mensajes y usuarios del mensaje|
    -------------------------------------------------------------
     */
    //Método para modificar mensaje y user 1
    public void modificarMensaje1(String mensaje1, String userReceptor, String sexo, String userEmisor) {
        String actualizar = "UPDATE USUARIOS SET MENSAJE1=?, USER1=?, SEXOUSER1=? WHERE USUARIO=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, mensaje1);
            actualizacion.setString(2, userReceptor);
            actualizacion.setString(3, sexo);
            actualizacion.setString(4, userEmisor);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    //Método para modificar mensaje y user 2
    public void modificarMensaje2(String mensaje2, String userReceptor, String sexo, String userEmisor) {
        String actualizar = "UPDATE USUARIOS SET MENSAJE2=?, USER2=?, SEXOUSER2=? WHERE USUARIO=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, mensaje2);
            actualizacion.setString(2, userReceptor);
            actualizacion.setString(3, sexo);
            actualizacion.setString(4, userEmisor);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    //Método para modificar mensaje y user 3
    public void modificarMensaje3(String mensaje3, String userReceptor, String sexo, String userEmisor) {
        String actualizar = "UPDATE USUARIOS SET MENSAJE3=?, USER3=?, SEXOUSER3=? WHERE USUARIO=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, mensaje3);
            actualizacion.setString(2, userReceptor);
            actualizacion.setString(3, sexo);
            actualizacion.setString(4, userEmisor);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    /*
    -------------------------------------------------------------
    |  Métodos para insertar los mensajes y usuarios del mensaje|
    -------------------------------------------------------------
     */
    public void insetarMensajes(String mensaje, String enviado, String recibido, int ID_Usuario, String tiempo) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement insertar = cn.prepareStatement("INSERT INTO MENSAJES(Mensaje, NombreUsuarioEnviado,NombreUsuarioRecibido,ID_Usuario,Tiempo)values(?,?,?,?,?)");
            insertar.setString(1, mensaje);
            insertar.setString(2, enviado);
            insertar.setString(3, recibido);
            insertar.setInt(4, ID_Usuario);
            insertar.setString(5, tiempo);
            insertar.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al insertar" + e);
        }
    }

    //Método que devuelve el usuario del mensaje 1
    public int devolverID_Usuario(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT ID FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getInt(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return 0;
    }

    public String devolverHistorial(int id_user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT Mensaje,NombreUsuarioEnviado, Tiempo FROM MENSAJES WHERE ID_Usuario=? ");
            obtener.setInt(1, id_user);
            ResultSet rs = obtener.executeQuery();
            String resultado = "";
            int contador = 0;
            while (rs.next())
            {
                contador++;
                resultado += "\nEnviado por: " + rs.getString(2) + " el " + rs.getString(3) + ": \n******************************************************\n" + "Mensaje enviado: " + rs.getString(1) + "\n******************************************************\n";
            }
            cn.close();
            return "Total de mensajes enviados a usted: " + contador + "\n" + resultado;

        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }

        return "";
    }

    //Método que devuelve el historial en japonés
    public String devolverHistorialJP(int id_user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT Mensaje,NombreUsuarioEnviado, Tiempo FROM MENSAJES WHERE ID_Usuario=?");
            obtener.setInt(1, id_user);
            ResultSet rs = obtener.executeQuery();
            String resultado = "";
            int contador = 0;
            while (rs.next())
            {
                contador++;
                resultado += "送信者: " + rs.getString(2) + " 投稿日 " + rs.getString(3) + ": \n******************************************************\n" + "メッセージを送信しました:  " + rs.getString(1) + "\n******************************************************\n";
            }
            cn.close();
            return "あなたに送信されたメッセージの合計数： " + contador + "\n" + resultado;

        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }

        return "";
    }

    /*
    -------------------------------------------------------------
    |  Métodos para insertar las emergencias y buscarlas|
    -------------------------------------------------------------
     */
    public void insetarEmergencia(String nombre, String prioridad, String tipo, String descripcion, String nombreCreador, String estado, String idioma) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement insertar = cn.prepareStatement("INSERT INTO EMERGENCIAS(Nombre,Prioridad,Tipo,Descripcion,NombreCreador,Estado,Idioma)values(?,?,?,?,?,?,?)");
            insertar.setString(1, nombre);
            insertar.setString(2, prioridad);
            insertar.setString(3, tipo);
            insertar.setString(4, descripcion);
            insertar.setString(5, nombreCreador);
            insertar.setString(6, estado);
            insertar.setString(7, idioma);
            insertar.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al insertar" + e);
        }
    }

    public void modificarCasoUsuario(int id_caso, String usuario) {
        String actualizar = "UPDATE USUARIOS SET ID_Caso=? WHERE USUARIO=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setInt(1, id_caso);
            actualizacion.setString(2, usuario);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    public void eliminarCasoUsuario(String usuario) {
        String actualizar = "UPDATE USUARIOS SET ID_Caso=NULL WHERE USUARIO=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, usuario);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    public void modificarCaso(int id_Usuario, String caso) {
        String actualizar = "UPDATE EMERGENCIAS SET ID_Usuario=? WHERE Nombre=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setInt(1, id_Usuario);
            actualizacion.setString(2, caso);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    public void eliminarCaso(String caso, String idioma) {

        String estado = "";
        if (idioma.equals("ESP"))
        {
            estado = "Finalizado";
        } else if (idioma.equals("JP"))
        {
            estado = "終了";
        }

        String actualizar = "UPDATE EMERGENCIAS SET Estado=? WHERE Nombre=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, estado);
            actualizacion.setString(2, caso);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    public void modificarCasoEnCurso(String caso, String idioma) {

        String estado = "";
        if (idioma.equals("ESP"))
        {
            estado = "En curso";
        } else if (idioma.equals("JP"))
        {
            estado = "進行中";
        }

        String actualizar = "UPDATE EMERGENCIAS SET Estado=? WHERE Nombre=?";
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement actualizacion = cn.prepareStatement(actualizar);
            actualizacion.setString(1, estado);
            actualizacion.setString(2, caso);
            actualizacion.executeUpdate();
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al actualizar." + e);
        }
    }

    //Método que devuelve el usuario del mensaje 1
    public int devolverID_Caso(String caso) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT ID FROM EMERGENCIAS WHERE Nombre=?");
            obtener.setString(1, caso);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getInt(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return 0;
    }

    public boolean devolverCasoUsuario(String usuario) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT IFNULL(ID_Caso, 0) FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, usuario);
            ResultSet rs = obtener.executeQuery();
            boolean bandera = false;
            while (rs.next())
            {
                if (rs.getInt(1) != 0)
                {
                    bandera = true;
                    break;
                }
            }
            cn.close();
            return bandera;
        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }
        return false;
    }

    public int devolverIDCasoUsuario(String usuario) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT IFNULL(ID_Caso, 0) FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, usuario);
            ResultSet rs = obtener.executeQuery();
            while (rs.next())
            {
                if (rs.getInt(1) == 0)
                {
                    return 0;
                } else
                {
                    return rs.getInt(1);
                }
            }
            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }
        return 0;
    }

    public boolean comprobarCaso(String caso) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT Nombre FROM EMERGENCIAS");
            ResultSet rs = obtener.executeQuery();
            boolean bandera = false;
            while (rs.next())
            {
                if (rs.getString(1).equals(caso))
                {
                    bandera = true;
                    break;
                }
            }
            cn.close();
            return bandera;
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }
        return false;
    }

    public String devolverUltimoCaso(String idioma) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = null;
            String resultado = "";

            if (idioma.equals("Sin seleccionar"))
            {
                obtener = cn.prepareStatement("SELECT Nombre,Prioridad, Tipo,Descripcion FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') ORDER BY ID ASC LIMIT 1");
            } else if (idioma.equals("ESP"))
            {
                obtener = cn.prepareStatement("SELECT Nombre,Prioridad, Tipo,Descripcion FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='ESP' ORDER BY ID ASC LIMIT 1");
            } else if (idioma.equals("JP"))
            {
                obtener = cn.prepareStatement("SELECT Nombre,Prioridad, Tipo,Descripcion FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='JP' ORDER BY ID ASC LIMIT 1");
            }

            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                if (idioma.equals("ESP"))
                {
                    resultado += "Nombre de la emergencia: " + rs.getString(1) + "\n\nPrioridad: " + rs.getString(2) + "\n\nTipo: " + rs.getString(3) + "\n\nDescripción: " + rs.getString(4);
                } else if (idioma.equals("JP"))
                {
                    resultado += "緊急事態の名前：" + rs.getString(1) + "\n\n優先度：" + rs.getString(2) + "\n\nタイプ：" + rs.getString(3) + "\n\n説明：" + rs.getString(4);
                }
            }

            cn.close();
            return resultado;

        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }

        return "";
    }

    public int devolveIDCaso(String idioma) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = null;
            int resultado = -1;

            if (idioma.equals("Sin seleccionar"))
            {
                obtener = cn.prepareStatement("SELECT ID FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') ORDER BY ID ASC LIMIT 1");
            } else if (idioma.equals("ESP"))
            {
                obtener = cn.prepareStatement("SELECT ID FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='ESP' ORDER BY ID ASC LIMIT 1");
            } else if (idioma.equals("JP"))
            {
                obtener = cn.prepareStatement("SELECT ID FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='JP' ORDER BY ID ASC LIMIT 1");
            }

            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                if (idioma.equals("ESP"))
                {
                    resultado = rs.getInt(1);
                } else if (idioma.equals("JP"))
                {
                    resultado = rs.getInt(1);
                }
            }

            cn.close();
            return resultado;

        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }

        return -1;
    }

    public String devolverNombreCaso(int id) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT Nombre FROM EMERGENCIAS WHERE ID=?");
            obtener.setInt(1, id);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return "";
    }

    //Devuelve cantidad de casos en un idioma concreto
    public int devolverCantidadCasos(String idioma) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = null;
            int resultado = 0;

            if (idioma.equals("Sin seleccionar"))
            {
                obtener = cn.prepareStatement("SELECT COUNT(*) FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中')");
            } else if (idioma.equals("ESP"))
            {
                obtener = cn.prepareStatement("SELECT COUNT(*) FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='ESP'");
            } else if (idioma.equals("JP"))
            {
                obtener = cn.prepareStatement("SELECT COUNT(*) FROM EMERGENCIAS WHERE Estado NOT IN('Finalizado','En curso','終了','進行中') AND Idioma='JP'");
            }

            ResultSet rs = obtener.executeQuery();
            if (rs.next())
            {
                resultado = rs.getInt(1);
            }
            cn.close();
            return resultado;

        } catch (SQLException e)
        {
            System.out.println("Error al acceder." + e);
        }

        return 0;
    }
    
    /*
    -------------------------------------
    |  Métodos para datos adicionales   |
    -------------------------------------
     */
    
    public int devolverHoras(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT HORASVOLUNTARIO FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getInt(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return 0;
    }
    
    public double devolverSalario(String user) {
        try
        {
            Connection cn = ConexionBaseDatos.conectar();
            PreparedStatement obtener = cn.prepareStatement("SELECT SALARIO FROM USUARIOS WHERE USUARIO=?");
            obtener.setString(1, user);
            ResultSet rs = obtener.executeQuery();

            if (rs.next())
            {
                return rs.getDouble(1);

            }

            cn.close();
        } catch (SQLException e)
        {
            System.out.println("Error al acceder.");
        }

        return 0.0;
    }
}
