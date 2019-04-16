package com.cead.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cead.spring.model.Horario;


@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

}
