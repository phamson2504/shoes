package com.restapi.shoes.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restapi.shoes.entity.Shoes;
import com.restapi.shoes.model.ShoesDTO;


public interface ShoesReponsitory extends CrudRepository<Shoes, Integer>{
	@Query(value = "Select new com.restapi.shoes.model.ShoesDTO("
			+ "s.id,s.img,s.title,s.star,s.reviews,s.prevPrice,s.newPrice,"
			+ "s.maxQuantity,s.company,s.color,c.nameCategory) "
			+ "From Shoes s INNER JOIN s.category c")
	List<ShoesDTO> getAllProduct();
	
	@Query(value = "Select new com.restapi.shoes.model.ShoesDTO("
			+ "s.id,s.img,s.title,s.star,s.reviews,s.prevPrice,s.newPrice,"
			+ "s.maxQuantity,s.company,s.color,c.nameCategory) "
			+ "From Shoes s INNER JOIN s.category c Where s.id in :id ")
	List<ShoesDTO> findShoesById(@Param("id") List<Integer> id);
	
	@Query( "select s from Shoes s where s.id in :ids" )
	List<Shoes> findByAllIds(@Param("ids") List<Integer> ids);
}
