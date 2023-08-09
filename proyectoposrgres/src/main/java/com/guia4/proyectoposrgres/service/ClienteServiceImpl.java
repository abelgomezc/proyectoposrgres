/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.service;

import com.guia4.proyectoposrgres.model.Carta;
import com.guia4.proyectoposrgres.model.Cliente;
import com.guia4.proyectoposrgres.respository.CartaRepository;
import com.guia4.proyectoposrgres.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements GenericService<Cliente, Long> {
           @Autowired
 ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Long> getDao() {
        return clienteRepository;
    }
}
