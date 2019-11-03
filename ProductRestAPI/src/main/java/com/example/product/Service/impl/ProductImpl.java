package com.example.product.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Service.ProductService;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductImpl implements ProductService{
	
	@Autowired
	private ProductRepository prepository;

	@Override
	public List<Product> findAll() {
		return prepository.findAll();
	}

	@Override
	public Optional<Product> findPbyID(long id) {
		// TODO Auto-generated method stub
		return prepository.findById(id);
	}

	@Override
	public void saveP(Product p) {
		// TODO Auto-generated method stub
		prepository.save(p);
	}

	@Override
	public void deleteP(Product p) {
		prepository.delete(p);
		
	}

}
