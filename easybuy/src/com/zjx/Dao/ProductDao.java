package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Product;

	public interface ProductDao {
	public List<Product> showAllUserByPage(int pageNo,int pageSize);
	public int countPageByProduct();
	public int addProduct(Product product);
	public Product findProductById(int id);
	public int updateProduct(Product product);
	public int deleteProduct(int id);
	public List<Product> showAllProduct();
}
