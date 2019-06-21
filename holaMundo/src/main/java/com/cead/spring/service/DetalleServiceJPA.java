package com.cead.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cead.spring.model.Detalle;
import com.cead.spring.repository.DetallesRepository;


@Service
public class DetalleServiceJPA implements IDetallesService{
	
	@Autowired
	private DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
		
	}

	@Override
	public void eliminar(int idDetalle) {
		
		detallesRepo.deleteById(idDetalle);
	}

}
