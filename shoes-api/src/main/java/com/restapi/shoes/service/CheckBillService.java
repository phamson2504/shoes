package com.restapi.shoes.service;

import java.util.List;

import com.restapi.shoes.entity.CheckBill;
import com.restapi.shoes.model.ShoesDTO;

public interface CheckBillService {
	List<ShoesDTO> checkBill(List<CheckBill> checkShoes);
	void saveBill(String idUser, List<CheckBill> checkBills);
}
