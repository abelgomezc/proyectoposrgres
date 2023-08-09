/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guia4.proyectoposrgres.respository;

import com.guia4.proyectoposrgres.model.Carta;
import com.guia4.proyectoposrgres.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abel Gomez
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
