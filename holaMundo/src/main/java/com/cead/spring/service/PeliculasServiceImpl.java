package com.cead.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cead.spring.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
	
	private List<Pelicula> lista = null;
	
	public PeliculasServiceImpl(){
			
			System.out.println("creando una instancia de la clase PeliculassERVICE impl");
		
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			
			try{
				
				this.lista = new LinkedList<>();
				
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
			}catch (Exception e) {
				// TODO: handle exception
			}	
			
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return this.lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for ( Pelicula p: lista ){
			if (p.getId() == idPelicula) {
				return p;
			}
			
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
	}

	@Override
	public List<String> buscarGeneros() {
		// TODO Auto-generated method stub
		List<String> generos =  new LinkedList<>();
		
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		
		
		return generos;
	}

}
