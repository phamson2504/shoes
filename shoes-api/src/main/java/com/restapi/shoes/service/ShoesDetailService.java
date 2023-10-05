package com.restapi.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.shoes.dao.ShoesReponsitory;
import com.restapi.shoes.model.ShoesDTO;

@Service
public class ShoesDetailService implements ShoesService{
	
	@Autowired
	ShoesReponsitory shoesReponsitory;
	
	@Override
	public List<ShoesDTO> getAllProduct() {
		return shoesReponsitory.getAllProduct();
	}

}
