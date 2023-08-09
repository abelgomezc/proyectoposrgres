/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.service;

import com.guia4.proyectoposrgres.model.Plato;
import com.guia4.proyectoposrgres.model.Restaurante;
import com.guia4.proyectoposrgres.respository.PlatoRepository;
import com.guia4.proyectoposrgres.respository.RestauranteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante, Long> implements GenericService<Restaurante, Long> {

    @Autowired
    RestauranteRespository restauranteRepository;

    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return restauranteRepository;
    }
}
