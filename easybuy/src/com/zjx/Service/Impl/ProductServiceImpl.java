package com.zjx.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.Impl.ProductDaoImpl;
import com.zjx.Entity.Product;
import com.zjx.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDaoImpl pdi = new ProductDaoImpl();
	public List<Product> showAllUserByPage(int pageNo, int pageSize) {
		return pdi.showAllUserByPage(pageNo, pageSize);
	}

	public int countPageByProduct(int pageSize) {
		int result=0;
		if(pdi.countPageByProduct()%pageSize==0){
			result=pdi.countPageByProduct()/pageSize;
		}else{
			result=pdi.countPageByProduct()/pageSize+1;
		}
		return result;
	}

	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return pdi.addProduct(product);
	}

	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return pdi.findProductById(id);
	}

	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return pdi.updateProduct(product);
	}

	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return pdi.deleteProduct(id);
	}

	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return pdi.showAllProduct();
	}

	public List<Product> findLately(String[] arr) {
		// TODO Auto-generated method stub
		List<Product> li = new ArrayList<Product>();
		for(String id:arr){
			if(id!=null && !id.equals("")){
				int i = Integer.parseInt(id);
				Product p=pdi.findProductById(i);
				li.add(p);
			}	
		}
		return li;
	}

}
