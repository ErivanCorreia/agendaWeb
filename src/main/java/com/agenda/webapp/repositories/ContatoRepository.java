package com.agenda.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.webapp.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
