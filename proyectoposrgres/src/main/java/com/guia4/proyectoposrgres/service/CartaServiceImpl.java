/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.service;


import com.guia4.proyectoposrgres.model.Carta;
import com.guia4.proyectoposrgres.respository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class CartaServiceImpl  extends GenericServiceImpl<Carta, Long> implements GenericService<Carta, Long> {
       @Autowired
   CartaRepository cartaRepository;

    @Override
    public CrudRepository<Carta, Long> getDao() {
        return cartaRepository;
    }
}
