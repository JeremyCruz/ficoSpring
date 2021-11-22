package com.pe.fico.service;

import java.util.List;

import com.pe.fico.entities.CategoryProduct;

public interface ICategoryProductService {

	public boolean insert(CategoryProduct category);

	List<CategoryProduct> list();
	
	CategoryProduct listarId(int idInstitution);
}
