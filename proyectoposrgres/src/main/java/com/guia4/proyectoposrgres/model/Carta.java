package com.guia4.proyectoposrgres.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carta")
public class Carta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarta", nullable = false, updatable = false)
    private Long idCarta;
    private  String nombre;
    private String categoria;
    private int cantidad;
    
        @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
        
        
          @ManyToMany
    @JoinTable(name = "carta_plato",
               joinColumns = @JoinColumn(name = "carta_id"),
               inverseJoinColumns = @JoinColumn(name = "plato_id"))
    private List<Plato> platos;
}
