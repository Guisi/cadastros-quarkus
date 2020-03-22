package com.rumolog.comum.cadastros.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rumolog.comum.cadastros.model.RetornoCidade;
import com.rumolog.comum.cadastros.service.CidadeService;

@Path("/comum/cadastros/cidades")
@Produces(MediaType.APPLICATION_JSON)
public class CidadesApiController {

	@Inject
	private CidadeService cidadeService;

	@GET
	public RetornoCidade consultarListaCidadePorFiltro(@QueryParam("siglaEstado") String siglaEstado, @QueryParam("textoLivre") String textoLivre) {
		return cidadeService.getCidadesPorEstado(siglaEstado, textoLivre);

	}

}
