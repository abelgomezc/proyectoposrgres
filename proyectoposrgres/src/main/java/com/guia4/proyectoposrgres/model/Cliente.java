package com.guia4.proyectoposrgres.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente", nullable = false, updatable = false)
    private Long idcliente;
    private String nombre;

    private String apellido;
    private String cedula;
    private String correo;
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "cliente_restaurante",
           joinColumns = @JoinColumn(name = "cliente_id"),
           inverseJoinColumns = @JoinColumn(name = "restaurante_id"))
private List<Restaurante> restaurantes;



}
