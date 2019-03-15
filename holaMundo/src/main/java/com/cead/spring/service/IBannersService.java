package com.cead.spring.service;

import java.util.List;

import com.cead.spring.model.Banner;

public interface IBannersService {
	void insertar(Banner banner); 
	List<Banner> buscarTodos();
}
