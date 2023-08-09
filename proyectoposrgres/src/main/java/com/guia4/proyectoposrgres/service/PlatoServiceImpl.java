/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.service;

import com.guia4.proyectoposrgres.model.Cliente;
import com.guia4.proyectoposrgres.model.Plato;
import com.guia4.proyectoposrgres.respository.ClienteRepository;
import com.guia4.proyectoposrgres.respository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class PlatoServiceImpl extends GenericServiceImpl<Plato, Long> implements GenericService<Plato, Long>{
    @Autowired
 PlatoRepository platoRepository;

    @Override
    public CrudRepository<Plato, Long> getDao() {
        return platoRepository;
    }
}
