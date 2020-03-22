package com.rumolog.comum.cadastros.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rumolog.comum.cadastros.model.RetornoEstado;
import com.rumolog.comum.cadastros.service.EstadoService;

@Path("/comum/cadastros/estados")
@Produces(MediaType.APPLICATION_JSON)
public class EstadosApiController {

	@Inject
	private EstadoService estadoService;
	
	@GET
	public RetornoEstado consultarListaEstadoPorFiltro() {
		return estadoService.getTodosEstados();
	}

}
