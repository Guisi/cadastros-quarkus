package com.rumolog.comum.cadastros.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.rumolog.comum.cadastros.model.Cidade;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadesRepository implements PanacheRepository<Cidade> {

	public List<Cidade> findAllCidadePorFiltro(Integer idEstado, String textoLivre) {
		String query = "SELECT cidade FROM Cidade cidade WHERE (:idEstado IS NULL OR cidade.idEstado = :idEstado) "
				+ "AND (:textoLivre IS NULL "
				+ " OR TRANSLATE(UPPER(cidade.cidadeEstado),'ÁÉÍÓÚÀÈÙÂÊÎÔÛËÏÖÜÇÑÄÃÅÌØÐÝÒÕÆ+','AEIOUAEUAEIOUEIOUCNAAAIODYOOA ') LIKE :textoLivre"
				+ " OR TRANSLATE(UPPER(cidade.descricao),'ÁÉÍÓÚÀÈÙÂÊÎÔÛËÏÖÜÇÑÄÃÅÌØÐÝÒÕÆ+','AEIOUAEUAEIOUEIOUCNAAAIODYOOA ') LIKE :textoLivre"
				+ " OR UPPER(cidade.siglaEstado) LIKE :textoLivre) "
				+ "order by cidade.descricao";
		
		Map<String, Object> params = new HashMap<>();
		params.put("idEstado", idEstado);
		params.put("textoLivre", textoLivre);
		return list(query, params);
	}
	
	
	
}
