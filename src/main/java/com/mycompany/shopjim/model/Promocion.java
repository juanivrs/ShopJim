/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjim.model;

/**
 *
 * @author Pedro
 */
public class Promocion implements Cloneable {

    private String nombre;
    private String desc;
    private String finic;
    private String ffin;
    private boolean activo;
    private int id;

    public Promocion() {
        this.id = -1;
        this.nombre = "";
        this.activo=true;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /*@Override
    public int compareTo(Localidad o) {
        if (o == null) {
            return -1;
        } else {
            if (o.getId() == this.id) {
                return 0;
            } else {
                return 1;
            }
        }
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Promocion l = new Promocion();
        l.activo = this.activo;
        l.id = this.id;
        l.nombre = this.nombre;
        return l;
    }
    
    @Override
    public String toString(){
        return nombre;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the finic
     */
    public String getFinic() {
        return finic;
    }

    /**
     * @param finic the finic to set
     */
    public void setFinic(String finic) {
        this.finic = finic;
    }

    /**
     * @return the ffin
     */
    public String getFfin() {
        return ffin;
    }

    /**
     * @param ffin the ffin to set
     */
    public void setFfin(String ffin) {
        this.ffin = ffin;
    }
}
