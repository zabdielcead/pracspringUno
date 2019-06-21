package com.cead.spring.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cead.spring.model.Pelicula;
import com.cead.spring.repository.PeliculasRepository;


@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
	@Autowired
	private PeliculasRepository peliculasRepo;
	
	
	
	@Override
	public void insertar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		if(optional.isPresent()) { //si lo encontro
			return optional.get();
		}
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
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

	@Override
	public void eliminar(int idPelicula) {
		
		peliculasRepo.deleteById(idPelicula);
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		
		return peliculasRepo.findAll(page);

	}

	
}
