package com.cead.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cead.spring.model.Noticia;
import com.cead.spring.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear(){
		
		return "noticias/formNoticia";
	}
	
	//@PostMapping(value="/save")
//	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, //por parametros pasan por el post
//							@RequestParam("detalle") String detalle){
	//por modelo}
	@PostMapping(value="/save")
	public String guardar(Noticia noticia){ //Noticia obj es por data binding
		
		
//		Noticia noticia = new Noticia();
//		noticia.setTitulo(titulo);
//		noticia.setEstatus(estatus);
//		noticia.setDetalle(detalle);
		
		
//		System.out.println("titulo: "+titulo);
//		System.out.println("estatus: "+estatus);
//		System.out.println("detalle: "+detalle);
		System.out.println(noticia);
		
		serviceNoticias.guardar(noticia);
		
		return "noticias/formNoticia";
	}

}
