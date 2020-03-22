package com.rumolog.comum.cadastros.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.rumolog.comum.cadastros.model.Cidade;
import com.rumolog.comum.cadastros.model.Estado;
import com.rumolog.comum.cadastros.model.RetornoCidade;
import com.rumolog.comum.cadastros.repository.CidadesRepository;
import com.rumolog.comum.cadastros.repository.EstadosRepository;

@ApplicationScoped
public class CidadeService extends BaseService {
	
	@Inject
	private CidadesRepository cidadesRepository;

	@Inject
	private EstadosRepository estadosRepository;

	public RetornoCidade getCidadesPorEstado(String siglaEstado, String textoLivre) {
		
		Integer idEstado = null;
		if (StringUtils.isNotBlank(siglaEstado)) {
			Estado estado = estadosRepository.findEstadoBySigla(siglaEstado);
			idEstado = estado != null ? estado.getIdEstado() : null;
		}
		
		String textoLivreLike = StringUtils.isNotBlank(textoLivre) ? "%" + StringUtils.stripAccents(StringUtils.upperCase(textoLivre)) + "%" : null;
		
		List<Cidade> cidades = this.cidadesRepository.findAllCidadePorFiltro(idEstado, textoLivreLike);

		RetornoCidade retornoCidades = new RetornoCidade();
		retornoCidades.setCidades(cidades);
		return this.popularRetornoSucesso(retornoCidades);
	}
}
