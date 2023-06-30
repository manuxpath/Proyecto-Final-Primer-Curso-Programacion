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
public class BomberoNormal extends Persona {

    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String devolverDescripcion() {
        if (super.isBandera())
        {
            return "El bombero cuyo nombre es: " + getUsuario()
                    + "\nSu email: " + getEmail()
                    + "\nSu rango: " + getRango()
                    + "\nSu sexo: " + getSexo()
                    + "\nSu salario:" + getSalario() + "\n\n"
                    + "Descripción del bombero:"
                    + "\nLa principal función del bombero es proteger la vida\n"
                    + "y la propiedad de las personas en situaciones de emergencia,\n"
                    + "como incendios, accidentes de tráfico, rescates en altura,\n"
                    + "rescates acuáticos y otros desastres naturales o provocados\n"
                    + "por el ser humano.";
        } else
        {
            return "名前は" + getUsuario() + "さんの消防士です。\n"
                    + "メールアドレス: " + getEmail() + "\n"
                    + "階級: " + getRango() + "\n"
                    + "性別: " + getSexo() + "\n"
                    + "給与: " + getSalario() + "\n\n"
                    + "消防士の説明:"
                    + "\n消防士の主な役割は、緊急事態において人\n"
                    + "々の生命と財産を保護することです。\n"
                    + "火災、交通事故、高所救助、水難救助、\n"
                    + "自然災害や人災などの状況で活動します。";

        }
    }

}
