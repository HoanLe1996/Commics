package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.product.Service.impl.ProductImpl;
import com.example.product.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductImpl productImpl;
	
	// Get all product 
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll(){
		List<Product> product = productImpl.findAll();
		if(product.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.valueOf("ko co cai nao"));
		}
		return new ResponseEntity<List<Product>>(product,HttpStatus.FOUND);
	}
	
	// Create Product 
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct( @Valid @RequestBody  Product product , UriComponentsBuilder builder) {
		productImpl.saveP(product);
		HttpHeaders h = new HttpHeaders();
		h.setLocation(builder.path("/products/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		
	}
	
	
	// update Product
	@PutMapping("/products/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id , @RequestBody Product p){
		Optional<Product> product = productImpl.findPbyID(id); // bao boc 1 gia tri duy nhat co the null or ko null
		if(!product.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.valueOf("ko co product can sua"));
		}
			product.get().setName(p.getName());
			product.get().setPrice(p.getPrice());
			product.get().setDescription(p.getDescription());
		
		return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
		
	}
	
	// Xoa Product
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<Product>  deleteP(@PathVariable("id") Long id){
		Optional<Product> p = productImpl.findPbyID(id);
		if(p.isPresent() == false) {
			return new ResponseEntity<Product>(HttpStatus.valueOf("Khong co id de khoa"));
			
		}
		productImpl.deleteP(p.get());
		return new ResponseEntity<Product>(HttpStatus.valueOf("xoa thanh cong"));
		
	}
	
	
	
	
}
