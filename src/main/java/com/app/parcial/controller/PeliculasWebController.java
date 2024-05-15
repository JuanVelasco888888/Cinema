package com.app.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.parcial.entity.Pelicula;
import com.app.parcial.exception.NotFoundException;
import com.app.parcial.repository.PeliculaRepositorio;



@Controller
@RequestMapping(value = "pelicula")
public class PeliculasWebController {
	
	@Autowired
	private PeliculaRepositorio pel_repositorio;
	
	@GetMapping("/lista")
	public String peliculaListTemplate(Model model) {
		model.addAttribute("pelicula", pel_repositorio.findAll());
		return "lista-pelicula";
	}
	
	@GetMapping("/crear")
	public String peliculaNewTemplate(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		return "formPelicula";
	}
	
	@GetMapping("/edit/{id}")
	public String peliculaEditTemplate(@PathVariable("id") String id, Model model) {
		model.addAttribute("pelicula", pel_repositorio.findById(id).orElseThrow(() -> new NotFoundException("Pelicula no encontrada")));
		return "formPelicula";
	}
	
	@PostMapping("/save")
	public String peliculaSaveProcess(@ModelAttribute("pelicula") Pelicula pelicula) {
		if(pelicula.getId().isEmpty()) {
			pelicula.setId(null);
		}
		pel_repositorio.save(pelicula);
		return "redirect:/pelicula/lista";
	}
	
	@GetMapping("/delete/{id}")
	public String peliculaDeleteProcess(@PathVariable("id") String id) {
		pel_repositorio.deleteById(id);
		return "redirect:/pelicula/lista";
		
	}

}

