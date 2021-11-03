package com.itallo.tipoitem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class tipoItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo tipo item é requerido") 
	@Length(min = 3, max = 100, message = "Campo tipo item deve ter entre 3 e 100 caracteres")
	private String tipoItem;
	
	@NotEmpty(message = "Campo descrição é requerido") 
	@Length(min = 3, max = 200, message = "Campo descrição deve ter entre 3 e 200 caracteres")
	private String descricao;



	public tipoItem() {
		super();
	}

	public tipoItem(Integer id, String tipoItem, String descricao) {
		super();
		this.id = id;
		this.tipoItem = tipoItem;
		this.descricao = descricao;
	}

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
		this.tipoItem = tipoItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tipoItem other = (tipoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
