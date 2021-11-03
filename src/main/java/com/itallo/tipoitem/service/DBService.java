package com.itallo.tipoitem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itallo.tipoitem.domain.tipoItem;
import com.itallo.tipoitem.repositories.tipoItemRepository;


@Service
public class DBService {
	
	@Autowired
	private tipoItemRepository tipoItemRepository;
	
	public void instanciaBaseDeDados() {
		
		tipoItem tipo1 = new tipoItem(null, "tipoitem1", "teste XXX");
		tipoItem tipo2 = new tipoItem(null, "tipoitem2", "teste YYY");
		tipoItem tipo3 = new tipoItem(null, "tipoitem3", "teste ZZZ");

		tipoItemRepository.saveAll(Arrays.asList(tipo1, tipo2, tipo3));
		
	}

}
