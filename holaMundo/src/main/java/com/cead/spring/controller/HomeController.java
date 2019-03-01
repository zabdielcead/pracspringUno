package com.cead.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cead.spring.model.Pelicula;
import com.cead.spring.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat datef = new SimpleDateFormat("dd-MM-yyyy");
	
	// get home
	@RequestMapping(value="/home", method=RequestMethod.GET) 
	public String goHome(){
		
		return "home"; //nombre jsp
	}
	
	//@RequestMapping(value="/search", method=RequestMethod.POST) antes de spring 4.3
	@PostMapping(value="/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		System.out.println("buscando todas las peliculas: "+ fecha);
		
		List<Pelicula> peliculas = getListaPelis();
		List<String> listaFechas = Utileria.getNextDays(4);
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas",peliculas);
		return "home";
	}
	
	//@RequestMapping(value="/", method=RequestMethod.GET)  antes de spring 4.3
	@GetMapping(value="/")
	public String mostrarPrincipal(Model model){
		List<Pelicula> peliculas = getListaPelis();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda", datef.format(new Date()));
		model.addAttribute("peliculas",peliculas);
		return "home"; //nombre jsp
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET ) // url 
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha){
		System.out.println("buscando horario para la pelicula idpelicula: "+ idPelicula);
		System.out.println("para la fecha: "+ fecha);
		
		String tituloPelicula ="Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		model.addAttribute("titulo",tituloPelicula);
		model.addAttribute("duracion",duracion);
		model.addAttribute("precioEntrada",precioEntrada);
		
		return "detalle";
	}
	
	@RequestMapping(value="/detailReqParam", method=RequestMethod.GET ) // url 
	public String mostrarDetalleReq(Model model,@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha){
		System.out.println("buscando horario para la pelicula idpelicula: "+ idPelicula);
		System.out.println("para la fecha: "+ fecha);
		
		String tituloPelicula ="Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		model.addAttribute("titulo",tituloPelicula);
		model.addAttribute("duracion",duracion);
		model.addAttribute("precioEntrada",precioEntrada);
		
		return "detalle";
	}

	private List<Pelicula> getListaPelis(){
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		try{
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formater.parse("02-05-2018"));
			pelicula1.setImagen("cinema.png");
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formater.parse("20-05-2018"));
			pelicula2.setImagen("bella.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formater.parse("20-05-2018"));
			pelicula3.setImagen("contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong la isla calavera");
			pelicula4.setDuracion(115);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y aventura");
			pelicula4.setFechaEstreno(formater.parse("06-06-2018"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			return lista;
		} catch (ParseException e){
			System.out.println("Error "+e.getMessage());
			return null;
		}
		
		
	}
}
