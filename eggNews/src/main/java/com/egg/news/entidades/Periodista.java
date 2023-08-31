package com.egg.news.entidades;

import com.egg.news.enumeraciones.Rol;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Periodista extends Usuario {

    private ArrayList<Noticia> misNoticas;

    private Integer sueldoMensual;

    public Periodista() {
    }

    public Periodista(ArrayList<Noticia> misNoticas, Integer sueldoMensual) {
        this.misNoticas = misNoticas;
        this.sueldoMensual = sueldoMensual;
    }

    public Periodista(ArrayList<Noticia> misNoticas, Integer sueldoMensual, String id, String nombreUsuario, String password, Date fechaDeAlta, Rol rol, Boolean activo) {
        super(id, nombreUsuario, password, fechaDeAlta, rol, activo);
        this.misNoticas = misNoticas;
        this.sueldoMensual = sueldoMensual;
    }

    public ArrayList<Noticia> getMisNoticas() {
        return misNoticas;
    }

    public void setMisNoticas(ArrayList<Noticia> misNoticas) {
        this.misNoticas = misNoticas;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

}
