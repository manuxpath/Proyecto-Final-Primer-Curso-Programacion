/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import herencias.Persona;

/**
 *
 * @author ShibaXpath
 */
public class BomberoVoluntario extends Persona {

    private int horasVoluntario;

    public int getHorasVoluntario() {
        return horasVoluntario;
    }

    public void setHorasVoluntario(int horasVoluntario) {
        this.horasVoluntario = horasVoluntario;
    }

    @Override
    public String devolverDescripcion() {
        if (super.isBandera())
        {
            return "El bombero voluntario cuyo nombre es: " + getUsuario()
                    + "\nSu email: " + getEmail()
                    + "\nSu rango: " + getRango()
                    + "\nSu sexo: " + getSexo()
                    + "\nSu horas voluntario:" + getHorasVoluntario() + " horas.\n\n"
                    + "Descripción del bombero voluntario:"
                    + "\nUn bombero voluntario es una persona que dedica"
                    + "\nsu tiempo y habilidades de manera altruista para"
                    + "\nformar parte de un cuerpo de bomberos en su comunidad.";
        } else
        {
           return "名前は" + getUsuario() + "さんのボランティア消防士です。\n"
                    + "メールアドレス: " + getEmail() + "\n"
                    + "階級: " + getRango() + "\n"
                    + "性別: " + getSexo() + "\n"
                    + "ボランティアの勤務時間: " + getHorasVoluntario() + " 時間\n\n"
                    + "ボランティア消防士の説明:\n"
                    + "ボランティア消防士は、地域の消防団に所属し、自己犠牲の精神で\n"
                    + "時間と能力を提供する人です。\n"
                    + "地域の消防活動に参加し、貢献します。";
        }
    }

}
