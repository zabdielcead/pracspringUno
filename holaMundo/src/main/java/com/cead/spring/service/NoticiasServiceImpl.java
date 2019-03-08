package com.cead.spring.service;

import org.springframework.stereotype.Service;

import com.cead.spring.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService{
	

	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public NoticiasServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}

	@Override
	public void guardar(Noticia noticia) {
		
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
	}

}
