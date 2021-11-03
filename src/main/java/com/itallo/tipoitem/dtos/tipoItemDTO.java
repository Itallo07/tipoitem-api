package com.itallo.tipoitem.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.itallo.tipoitem.domain.tipoItem;

public class tipoItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Campo tipo item é requerido") 
	@Length(min = 3, max = 100, message = "Campo nome deve ter entre 3 e 100 caracteres")
	private String tipoItem;
	
	@NotEmpty(message = "Campo descrição é requerido") 
	@Length(min = 3, max = 200, message = "Campo descrição deve ter entre 3 e 200 caracteres")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String gettipoItem() {
		return tipoItem;
	}

	public void settipoItem(String tipoItem) {
		this.tipoItem =tipoItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public tipoItemDTO() {
		super();
		
	}

	public tipoItemDTO(tipoItem obj) {
		super();
		this.id = obj.getId();
		this.tipoItem = obj.gettipoItem();
		this.descricao = obj.getDescricao();
	}
}
