package com.restapi.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.shoes.model.ShoesDTO;
import com.restapi.shoes.service.ShoesDetailsService;

@RestController
@RequestMapping("/api/shoes")
public class ShoesController {
	
	@Autowired
	ShoesDetailsService shoesDetailService;
	
	@RequestMapping({ "/allData" })
	public List<ShoesDTO> firstPage() {
		return shoesDetailService.getAllProduct();
	}
}
