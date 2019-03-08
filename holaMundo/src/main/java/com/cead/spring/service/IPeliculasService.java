package com.cead.spring.service;
import java.util.List;

import com.cead.spring.model.Pelicula;
public interface IPeliculasService {
	
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula );
	
}
