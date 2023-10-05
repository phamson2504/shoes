package com.restapi.shoes.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restapi.shoes.entity.Shoes;
import com.restapi.shoes.model.ShoesDTO;


public interface ShoesReponsitory extends CrudRepository<Shoes, Integer>{
	@Query(value="Select new com.restapi.shoes.model.ShoesDTO("
			+ "s.id,s.img,s.title,s.star,s.reviews,s.prevPrice,s.newPrice,"
			+ "s.maxQuantity,s.company,s.color,c.nameCategory) "
			+ "From Shoes s INNER JOIN s.category c")
	List<ShoesDTO> getAllProduct();
}
