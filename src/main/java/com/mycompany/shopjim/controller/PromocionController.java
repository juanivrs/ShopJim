/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjim.controller;

import com.mycompany.shopjim.model.Categoria;
import com.mycompany.shopjim.model.Promocion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class PromocionController extends AbstractController<Promocion> {
    @Inject
    TiendaController tiendacontroller;
    public PromocionController() {
        super(Promocion::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("Descuento 10%");
        this.getSelected().setDesc("Descuento 10%");
        this.getSelected().setFinic("22/07/2022");
        this.getSelected().setFfin("25/08/2022");
        this.add();

         this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("Descuento 20%");
        this.getSelected().setDesc("Descuento 10%");
        this.getSelected().setFinic("22/07/2022");
        this.getSelected().setFfin("25/08/2022");
        this.add();

          this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("Descuento 30%");
        this.getSelected().setDesc("Descuento 10%");
        this.getSelected().setFinic("22/07/2022");
        this.getSelected().setFfin("25/08/2022");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
           if (this.tiendacontroller.getItems().stream().filter(item -> {
                return item.getPromocion() == this.getSelected();
            }).count() == 0) {
                this.repositorio.remove(this.getSelected());
                return "remove";
            } else {
                return "";
            }

        }
        //se tiene que poner el error
        return "";

    }

    @Override
    public String preEdit() {

        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());
            //si ya existe
    
        }
        return "sucess";
    }
}
