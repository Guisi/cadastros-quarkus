package com.rumolog.comum.cadastros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Formula;

@Table
@Entity
public class Cidade {

	@Id
	@NotNull(message = "ID da Cidade não deve ser nulo.")
	@SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_CIDADE", strategy = GenerationType.SEQUENCE)
	private Integer idCidade;

	private Integer idEstado;

	private String sigla;

	private String siglaEstado;

	private String descricao;
	
	@Formula("CONCAT(CONCAT(UPPER(descricao), ' - '), UPPER(sigla_estado))")
	private String cidadeEstado;

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(idCidade).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Cidade other = (Cidade) obj;
		return new EqualsBuilder().append(idCidade, other.idCidade).isEquals();
	}
}
