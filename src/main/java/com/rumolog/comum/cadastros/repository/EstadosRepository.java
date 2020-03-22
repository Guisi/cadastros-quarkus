package com.rumolog.comum.cadastros.repository;

import javax.enterprise.context.ApplicationScoped;

import com.rumolog.comum.cadastros.model.Estado;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadosRepository implements PanacheRepository<Estado> {

	public Estado findEstadoBySigla(String sigla) {
		return find("sigla", sigla).firstResult();
	}
}
