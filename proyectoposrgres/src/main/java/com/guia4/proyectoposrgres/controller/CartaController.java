/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.controller;

import com.guia4.proyectoposrgres.model.Carta;
import com.guia4.proyectoposrgres.service.CartaServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abel Gomez
 */
@RestController
@RequestMapping("/api/carta")
public class CartaController {
    
       @Autowired
    CartaServiceImpl cartaServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Carta>> listarcarta() {
        return new ResponseEntity<>(cartaServiceImpl.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Carta> crearCarta(
            @RequestBody Carta p) {
        return new ResponseEntity<>(cartaServiceImpl.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carta> actualizarCarta(@PathVariable Long id, @RequestBody Carta p) {
        Carta cartaENcontrada = cartaServiceImpl.findById(id);
        if (cartaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cartaENcontrada.setNombre(p.getNombre());
                cartaENcontrada.setCategoria(p.getCategoria());
                cartaENcontrada.setCantidad(p.getCantidad());
                return new ResponseEntity<>(cartaServiceImpl.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carta> eliminarCarta(@PathVariable Long id) {
        cartaServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
