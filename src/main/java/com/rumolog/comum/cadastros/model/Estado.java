package com.rumolog.comum.cadastros.model;

import javax.json.bind.annotation.JsonbNillable;
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

@Table
@Entity
@JsonbNillable(value = false)
public class Estado {

	@Id
	@NotNull(message = "ID do Estado não deve ser nulo.")
	@SequenceGenerator(name = "SEQ_ESTADO", sequenceName = "SEQ_ESTADO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ESTADO", strategy = GenerationType.SEQUENCE)
	private Integer idEstado;

	private Integer idPais;

	private String sigla;

	private String descricao;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		return new HashCodeBuilder(17, 37).append(idEstado).toHashCode();
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
		Estado other = (Estado) obj;
		return new EqualsBuilder().append(idEstado, other.idEstado).isEquals();
	}
}
