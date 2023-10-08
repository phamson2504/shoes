package com.restapi.shoes.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.shoes.entity.Bill;

public interface BillReponsitory extends CrudRepository<Bill, Integer>{

}
