/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt_Usuarios")
public class Usuario implements Serializable{
    @Id
    @Column(name="Id_usuario")
    private int id_usuario;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name="Domicilio")
    private String domicilio;
    @Column(name="Direccion")
    private String direccion;
    @Column(name="tel_casa")
    private String tel_casa;
    @Column(name="tel_movil")
    private String tel_movil;
    @Column(name="cve_usuario")
    private String cve_usuario;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="bloqueo")
    private int bloqueo;

    public Usuario(String Nombre, String domicilio, String direccion, String tel_casa, String tel_movil, String cve_usuario, String contrasena, int bloqueo) {
        this.Nombre = Nombre;
        this.domicilio = domicilio;
        this.direccion = direccion;
        this.tel_casa = tel_casa;
        this.tel_movil = tel_movil;
        this.cve_usuario = cve_usuario;
        this.contrasena = contrasena;
        this.bloqueo = bloqueo;
    }

    
    public Usuario() {
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the tel_casa
     */
    public String getTel_casa() {
        return tel_casa;
    }

    /**
     * @param tel_casa the tel_casa to set
     */
    public void setTel_casa(String tel_casa) {
        this.tel_casa = tel_casa;
    }

    /**
     * @return the tel_movil
     */
    public String getTel_movil() {
        return tel_movil;
    }

    /**
     * @param tel_movil the tel_movil to set
     */
    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }

    /**
     * @return the cve_usuario
     */
    public String getCve_usuario() {
        return cve_usuario;
    }

    /**
     * @param cve_usuario the cve_usuario to set
     */
    public void setCve_usuario(String cve_usuario) {
        this.cve_usuario = cve_usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the bloqueo
     */
    public int getBloqueo() {
        return bloqueo;
    }

    /**
     * @param bloqueo the bloqueo to set
     */
    public void setBloqueo(int bloqueo) {
        this.bloqueo = bloqueo;
    }
}
