package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.domain.Product;
@Service("loginservice")
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductDao productDao;
	@Override
	public boolean insertProductDetail(Product objProduct) throws Exception {
		return productDao.insertProductDetail(objProduct);
	}
	@Override
	public List<Product> search(String searchCategory) throws Exception {
		return productDao.search(searchCategory);
	}
	@Override
	public List<Product> searchFullText(String searchText) throws Exception {
		return productDao.searchFulltext(searchText);
	}
	
}
