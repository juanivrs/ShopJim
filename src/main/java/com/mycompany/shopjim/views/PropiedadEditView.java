/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjim.views;

import com.mycompany.shopjim.controller.CategoriaController;
import com.mycompany.shopjim.controller.PromocionController;
import com.mycompany.shopjim.controller.TiendaController;
import com.mycompany.shopjim.model.Categoria;
import com.mycompany.shopjim.model.Promocion;
import com.mycompany.shopjim.model.Tienda;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author Administrador
 */
@ViewScoped
@Named
public class PropiedadEditView implements Serializable {

    @Inject
    private TiendaController tiendacontroller;
    @Inject
    private CategoriaController categoriacontroller;
    @Inject
    private PromocionController promocioncontroller;
  
    private Tienda tienda;
    //private final String destination;


  

    public PropiedadEditView() {
     //   FacesContext ctx = FacesContext.getCurrentInstance();
     //   this.destination  = ctx.getExternalContext().getInitParameter("ruta_imagenes");
        //System.out.println("El valor es " + myConstantValue);
    }

  
    /**
     * @return the t
     */
    public String getCategoria() {
        if (this.tienda.getCategoria() != null) {
            return this.tienda.getCategoria().getNombre();
        } else {
            return "";
        }

    }

    /**
     * @param t the t to set
     */
    public void setCategoria(String item) {
        Optional<Categoria> consulta = this.categoriacontroller.getItems().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.tienda.setCategoria(consulta.get());
        }
    }

    
    @PostConstruct
    public void init() {

        // this.tipo = new Tipo();
        if (this.tiendacontroller.getSelected() == null) {
            this.tienda = new Tienda();
        } else {
            //se clona por si se da a cancelar
            this.tienda = (Tienda) this.tiendacontroller.getSelected();//.clone(); //.getSelected();
          //  this.provincia = this.provinciacontroller.getProvinciaByLocalidad(this.propiedad.getLocalidad());

        }
    }

    public void onProvinciaChange() {
    //    Provincia p = this.provinciacontroller.getItems().get(0);

    }

    

    public List<Promocion> getPromociones() {
        return this.promocioncontroller.getItems();
    }

    public void setPromocion(String item) {
        Optional<Promocion> consulta = this.promocioncontroller.getItems().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.tienda.setPromocion(consulta.get());
        }
    }

    public String getPromocion() {
        if (this.tienda.getPromocion() != null) {
            return this.tienda.getPromocion().getNombre();
        } else {
            return "";
        }

    }

 

    public List<Categoria> getCategorias() {
        return this.categoriacontroller.getItems();
    }

    /**
     * @return the propiedad
     */
    public Tienda getTienda() {
        return tienda;
    }

    /**
     * @param propiedad the propiedad to set
     */
    public void setTienda(Tienda propiedad) {
        this.tienda = propiedad;
    }

 

    public String add() {
        Tienda p;
        if (this.tienda != null) {
            if (this.tienda.getId() != -1) {
                //se obtiene el original
                p = this.tiendacontroller.getTiendaById(tienda.getId());
                p.setDireccion(this.tienda.getDireccion());
                p.setActivo(tienda.isActivo());
                p.setPromocion(tienda.getPromocion());
                p.setCategoria(tienda.getCategoria());
                p.setPrecio(tienda.getPrecio());
                p.setCoordenadas(tienda.getCoordenadas());
                p.setPrecio(tienda.getPrecio());

                this.tiendacontroller.setSelected(null);
                return "sucess";
            } else {
                //nuevo
                this.tiendacontroller.setSelected(this.tienda);
                this.tiendacontroller.add();
                return "sucess";
            }
        } else {
            this.tiendacontroller.setSelected(null);
            return "failed";
        }

    }

    public String preEdit() {
        return "edit";
    }

  
}
