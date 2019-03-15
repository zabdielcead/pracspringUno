package com.cead.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cead.spring.model.Pelicula;
import com.cead.spring.service.IPeliculasService;
import com.cead.spring.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
		@Autowired
		private IPeliculasService servicePeliculas;
		
		@GetMapping("/index")
		public String mostrarIndex(Model model) {
			List<Pelicula> lista = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", lista);
			return "peliculas/listPeliculas";
		}
		
		@GetMapping("/create")
		public String crear(@ModelAttribute Pelicula pelicula, Model model){
			 model.addAttribute("generos", servicePeliculas.buscarGeneros());
			return "peliculas/formPelicula";
		}
		
		@PostMapping("/save")
		public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, //podemos ver los errores Binding si sale un 400 u otro error
				 			  @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){ // linea para subir archivos 
			// RedirectAttributes attributes son atributos se pasan por redirect y spring los elimina cuando se hizo la peticion 
			
			if(result.hasErrors()){
				return "peliculas/formPelicula";
				//ver si existen errores
			}
			
			/*for( ObjectError error : result.getAllErrors() ){ //nos mostrara los errores en pantalla
				System.out.println(error.getDefaultMessage());
			}*/
			// https://stackoverflow.com/questions/6128134/can-i-manage-multiple-browser-tabs-with-spring-security
			
			if (!multiPart.isEmpty()) { //subir archivos
				String nombreImagen = Utileria.guardarImagen(multiPart,request);
				  System.out.println("la imagen se guardara en: " + nombreImagen);
				  pelicula.setImagen(nombreImagen);
			}

			
			System.out.println("Recibiendo objeto pelicula: "+pelicula );
			
			System.out.println("Elementos en la lista antes de la insercion: "+ servicePeliculas.buscarTodas().size() );
			
			    servicePeliculas.insertar(pelicula);
			    
			    System.out.println("Elementos en la lista despues de la insercion: "+ servicePeliculas.buscarTodas().size() );    
			
			//return "peliculas/formPelicula";
			    attributes.addFlashAttribute("mensaje", "El registro fue guardado");
			    
			    return "redirect:/peliculas/index"; // redireccionamiento  a una url no a un jsp    va al metodo public String mostrarIndex(Model model) { de este mismo controlador 
		}
		
		
		@InitBinder 
		public void initBinder(WebDataBinder binder) { //WebDataBinder registra validaciones
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //para todas las propiedades tipo Date  vas a crear un objeto customeditor nicamente este controlador (validara dd-mm-yyyy) y el false indica que no vamos a permitir que las fechas sean vacias
		}
		
		
}
