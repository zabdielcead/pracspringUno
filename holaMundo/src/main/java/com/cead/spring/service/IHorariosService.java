package com.cead.spring.service;

import java.util.Date;
import java.util.List;

import com.cead.spring.model.Horario;

public interface IHorariosService {
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
}
