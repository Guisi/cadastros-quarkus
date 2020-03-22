package com.rumolog.comum.cadastros.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.rumolog.comum.cadastros.model.Estado;
import com.rumolog.comum.cadastros.model.RetornoEstado;
import com.rumolog.comum.cadastros.repository.EstadosRepository;

import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class EstadoService extends BaseService {

	@Inject
	private EstadosRepository estadosRepository;
	
	public RetornoEstado getTodosEstados() {
		List<Estado> estados = this.estadosRepository.listAll(Sort.by("descricao"));
		
		RetornoEstado retornoEstado = new RetornoEstado();
		retornoEstado.setEstados(estados);
		return this.popularRetornoSucesso(retornoEstado);
	}

}
