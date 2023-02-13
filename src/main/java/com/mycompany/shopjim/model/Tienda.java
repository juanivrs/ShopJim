/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjim.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Pedro
 */
public class Tienda implements Cloneable{
    private String nombre;
    private String direccion;
    private int precio;
    private String descripcion;
    private String coordenadas;
    private boolean activo;
    private int id;
    private Categoria categoria;
    private Promocion promocion;
    
   public Tienda(){
       this.id=-1;
       this.nombre="";
       this.direccion="";
       this.activo=true;
       this.categoria=new Categoria();
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

    /**
     * @return the localidades
     */
    public Categoria getCategoria() {
        return categoria;
    }
 
   
    public void setCategoria(Categoria c) {
        this.categoria = c;
    }
   @Override
    protected Object clone(){
        Tienda item= new Tienda();
        item.activo=this.activo;
        item.id=this.id;
        item.nombre=this.nombre;
        return item;
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
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the coordenadas
     */
    public String getCoordenadas() {
        return coordenadas;
    }

    /**
     * @param coordenadas the coordenadas to set
     */
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * @return the promocion
     */
    public Promocion getPromocion() {
        return promocion;
    }

    /**
     * @param promocion the promocion to set
     */
    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}
