package com.itallo.tipoitem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itallo.tipoitem.domain.tipoItem;

@Repository
public interface tipoItemRepository extends JpaRepository<tipoItem, Integer>{

}
