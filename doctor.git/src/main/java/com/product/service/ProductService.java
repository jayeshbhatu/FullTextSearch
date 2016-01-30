package com.product.service;

import java.util.List;

import com.product.domain.Product;

public interface ProductService {
	boolean insertProductDetail(Product objProduct) throws Exception;
	public List<Product> search(String searchCategory)throws Exception;
	public List<Product> searchFullText(String searchText) throws Exception;
	
}
