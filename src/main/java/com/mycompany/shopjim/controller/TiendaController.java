/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjim.controller;


import com.mycompany.shopjim.model.Categoria;
import com.mycompany.shopjim.model.Tienda;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class TiendaController extends AbstractController<Tienda> {

    @Inject
    private CategoriaController categoriacontroller;
    @Inject
    private PromocionController promocioncontroller;
    public TiendaController() {
        super(Tienda::new);
        //this.load();
    }

    @Override
    public Tienda getSelected() {
        return super.getSelected();
    }

    @Override
    @PostConstruct
    public void load() {

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
       
          this.getSelected().setNombre("Movil Europa");
           this.getSelected().setDireccion("Los Palacios");
            this.getSelected().setCoordenadas("00000");
           this.getSelected().setDescripcion("00000");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-2);
         this.getSelected().setDireccion("Los Palacios");
            this.getSelected().setCoordenadas("00000");
           this.getSelected().setDescripcion("00000");
        this.getSelected().setNombre("Cafetería Manolo");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
         this.getSelected().setDireccion("Los Palacios");
            this.getSelected().setCoordenadas("00000");
           this.getSelected().setDescripcion("00000");
        this.getSelected().setNombre("Bolos maritili");
        this.add();
    }

    public String remove() {

        if (this.getSelected() != null) {
           // if(this.getSelected().getCategoria().getNombre() == null){
                  this.repositorio.remove(this.getSelected());
                return "remove";
          //  }

            //se mira si existe alguna propiedad con alguna localidad de la provincia TO-DOOO
          //  return "failure";
              
           
            }else {
            return "";
        }
            // this.repositorio.remove(this.getSelected());
        

       
    }

    @Override
    public String preEdit() {
        /*Provincia t = new Provincia();
        t.setActivo(this.getSelected().isActivo());
        t.setId(this.getSelected().getId());
        t.setNombre(this.getSelected().getNombre());
        t.setLocalidades(this.getSelected().getLocalidades());
        this.setSelected(t);*/
        return "edit";
    }


    public void selectedChange(ValueChangeEvent event) {
        Tienda pr = this.repositorio.getAll().stream().filter(p
                -> {
            return p.getNombre().equals(event.getNewValue().toString());
        }
        ).findFirst().get();
        this.setSelected(pr);
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());
        }
        return "sucess";
    }
    
    public Tienda getTiendaById(int id){
        Tienda p=null;
        Optional <Tienda> element = this.getItems().stream().filter(item -> {
           return item.getId() == id;
        }).findFirst();
        if(!element.isEmpty()) {
            p=element.get();
        }
        return p;
    }
}
