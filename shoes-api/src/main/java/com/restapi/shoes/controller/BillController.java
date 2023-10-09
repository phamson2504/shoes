package com.restapi.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.shoes.entity.CheckBill;
import com.restapi.shoes.model.ShoesDTO;
import com.restapi.shoes.service.CheckBillDetailsService;

@RestController
@RequestMapping("/api/checkBill")
public class BillController {
	
	@Autowired
	CheckBillDetailsService cbService;
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST)
	public List<ShoesDTO> checkBill(@RequestBody List<CheckBill> shoes)throws Exception{
		return cbService.checkBill(shoes);
	}
	
	@RequestMapping(value = "/payBill/{userName}", method = RequestMethod.POST)
	public ResponseEntity<?>  payBill(@PathVariable String userName,@RequestBody List<CheckBill> shoes)throws Exception{
		try {
			cbService.saveBill(userName, shoes);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
