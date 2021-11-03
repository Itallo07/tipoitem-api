package com.itallo.tipoitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.itallo.tipoitem.domain.tipoItem;
import com.itallo.tipoitem.dtos.tipoItemDTO;
import com.itallo.tipoitem.repositories.tipoItemRepository;
import com.itallo.tipoitem.service.exceptions.ObjectNotFoundException;

@Service
public class tipoItemService {
	@Autowired
	private tipoItemRepository tipoItemRepository;

	public tipoItem findById(Integer id) {
		Optional<tipoItem> obj = tipoItemRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id ));
	}

	public List<tipoItem> findAll() {
		return tipoItemRepository.findAll();
	}

	public tipoItem create(tipoItem obj) {
		obj.setId(null);

		return tipoItemRepository.save(obj);
	}

	public tipoItem update(Integer id, tipoItemDTO objDTO) {
		tipoItem obj = findById(id);

		obj.settipoItem(objDTO.gettipoItem());
		obj.setDescricao(objDTO.getDescricao());
		return tipoItemRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);

		try {
			tipoItemRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) { 
			throw new com.itallo.tipoitem.service.DataIntegrityViolationException(
					"tipo item não pode ser deletado");
		}

	}
}
