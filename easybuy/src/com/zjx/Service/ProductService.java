package com.zjx.Service;

import java.util.List;

import com.zjx.Entity.Product;

public interface ProductService {
	public List<Product> showAllUserByPage(int pageNo, int pageSize);
	public int countPageByProduct(int pageSize);
	public int addProduct(Product product);
	public Product findProductById(int id);
	public int updateProduct(Product product);
	public int deleteProduct(int id);
	public List<Product> showAllProduct();
	
	public List<Product> findLately(String[] arr);
}
