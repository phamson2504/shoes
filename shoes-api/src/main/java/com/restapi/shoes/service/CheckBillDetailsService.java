package com.restapi.shoes.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.shoes.dao.BillDetailReponsitory;
import com.restapi.shoes.dao.BillReponsitory;
import com.restapi.shoes.dao.ShoesReponsitory;
import com.restapi.shoes.dao.UserRepository;
import com.restapi.shoes.entity.Bill;
import com.restapi.shoes.entity.BillDetail;
import com.restapi.shoes.entity.CheckBill;
import com.restapi.shoes.entity.Shoes;
import com.restapi.shoes.entity.User;
import com.restapi.shoes.model.ShoesDTO;

@Service
public class CheckBillDetailsService implements CheckBillService {

	@Autowired
	ShoesReponsitory shoesReponsitory;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BillDetailReponsitory billDetailReponsitory;

	@Autowired
	BillReponsitory billReponsitory;

	@Override
	public List<ShoesDTO> checkBill(List<CheckBill> checkShoes) {
		List<Integer> idCheckShoes = checkShoes.stream().map(CheckBill::getId).collect(Collectors.toList());
		List<ShoesDTO> shoes = shoesReponsitory.findShoesById(idCheckShoes);
		List<ShoesDTO> shoesFail = new ArrayList<ShoesDTO>();
		for (ShoesDTO s : shoes) {
			for (CheckBill cS : checkShoes) {
				if (cS.getId() == s.getId()) {
					if (cS.getQty() > s.getMaxQuantity()) {
						shoesFail.add(s);
					}
				}
			}
		}
		return shoesFail;
	}

	@Override
	public void saveBill(String userName, List<CheckBill> checkBills) {
		try {
			User user = userRepository.findByUsername(userName);
			Iterable<Integer> ids = checkBills.stream().map(CheckBill::getId).toList();
			List<Shoes> listShoes = (List<Shoes>) shoesReponsitory.findAllById(ids);
			if (user != null) {
				Bill bill = new Bill(user, LocalDate.now());
				billReponsitory.save(bill);
				for (CheckBill checkBill : checkBills) {
					Shoes shoes = listShoes.stream().filter(s -> s.getId() == checkBill.getId()).toList().get(0);
					BillDetail billDetail = new BillDetail(shoes, bill, shoes.getNewPrice(), checkBill.getQty());
					billDetailReponsitory.save(billDetail);
					shoes.setMaxQuantity(shoes.getMaxQuantity() - checkBill.getQty());
					shoesReponsitory.save(shoes);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
