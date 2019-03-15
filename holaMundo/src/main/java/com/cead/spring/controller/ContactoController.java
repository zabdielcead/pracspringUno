package com.cead.spring.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cead.spring.model.Contacto;
import com.cead.spring.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePeliculas;
	
	
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto, Model model){
		model.addAttribute("generos", servicePeliculas.buscarGeneros());
		model.addAttribute("tipos", tipoNotificaciones());
		return "formContacto";
	}
	// se pueden llamar igual cuando  GetMapping("/contacto") PostMapping la diferencia es post y get 
	@PostMapping("/contacto") 
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto,  Model model){
		// ESTE OBJETO YA SE PUEDE GUARDAR
		System.out.println(contacto);		
		return "redirect:/contacto";
	}
	
	
	private List<String> tipoNotificaciones(){
		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		
		return tipos;
	}
}
