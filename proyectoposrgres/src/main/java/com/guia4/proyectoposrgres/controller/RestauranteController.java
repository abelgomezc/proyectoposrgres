/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guia4.proyectoposrgres.controller;

import com.guia4.proyectoposrgres.model.Restaurante;
import com.guia4.proyectoposrgres.service.RestauranteServiceImpl;
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
@RequestMapping("/api/restaurante")
public class RestauranteController {
       @Autowired
    RestauranteServiceImpl restauranteServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestau() {
        return new ResponseEntity<>(restauranteServiceImpl.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearRestau(
            @RequestBody Restaurante p) {
        return new ResponseEntity<>(restauranteServiceImpl.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestau(@PathVariable Long id, @RequestBody Restaurante p) {
        Restaurante restENcontrada = restauranteServiceImpl.findById(id);
        if (restENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                restENcontrada.setNombre(p.getNombre());
                restENcontrada.setCorreo(p.getCorreo());
                restENcontrada.setDireccion(p.getDireccion());
                    restENcontrada.setTelefono(p.getTelefono());
                return new ResponseEntity<>(restauranteServiceImpl.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRestau(@PathVariable Long id) {
        restauranteServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
