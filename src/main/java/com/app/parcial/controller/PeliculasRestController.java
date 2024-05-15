package com.app.parcial.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.parcial.entity.Pelicula;
import com.app.parcial.exception.NotFoundException;
import com.app.parcial.repository.PeliculaRepositorio;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculasRestController {
    
    @Autowired
    private PeliculaRepositorio pel_repositorio;

    @GetMapping("/")
    public List<Pelicula> getAllPeliculas() {
        return pel_repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable String id) {
        return pel_repositorio.findById(id).orElseThrow(() -> new NotFoundException("Pelicula no encontrada"));
    }

    @PostMapping("/")
    public Pelicula savePelicula(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Pelicula pelicula = mapper.convertValue(body, Pelicula.class);
        return pel_repositorio.save(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Pelicula pelicula = mapper.convertValue(body, Pelicula.class);
        pelicula.setId(id);
        return pel_repositorio.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public Pelicula deletePelicula(@PathVariable String id) {
        Pelicula pelicula = pel_repositorio.findById(id).orElseThrow(() -> new NotFoundException("Pelicula no encontrada"));
        pel_repositorio.deleteById(id);
        return pelicula;
    }
}
