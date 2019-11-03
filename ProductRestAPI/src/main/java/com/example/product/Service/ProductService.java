package com.example.product.Service;

import java.util.List;
import java.util.Optional;


import com.example.product.model.Product;


public interface ProductService {

	public List<Product> findAll();
	
	public Optional<Product> findPbyID(long id);
	
	public void saveP(Product p);
	
	public void deleteP(Product p);
}
