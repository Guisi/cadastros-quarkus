package com.rumolog.comum.cadastros.service;

import javax.ws.rs.core.Response.Status;

import com.rumolog.comum.cadastros.model.Retorno;

public abstract class BaseService {

	protected <R extends Retorno> R popularRetornoSucesso(R retorno) {
		retorno.setCodigo(Status.OK.getStatusCode());
		retorno.setMensagem("Operação executada com sucesso");
		return retorno;
	}

}