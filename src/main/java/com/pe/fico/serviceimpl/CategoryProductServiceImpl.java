package com.pe.fico.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.fico.entities.CategoryProduct;
import com.pe.fico.repositories.ICategoryProductRepository;
import com.pe.fico.service.ICategoryProductService;

@Service
public class CategoryProductServiceImpl implements ICategoryProductService {

	@Autowired
	private ICategoryProductRepository cR;

	@Override
	public boolean insert(CategoryProduct category) {
		// TODO Auto-generated method stub
		CategoryProduct ob = cR.save(category);

		if (ob == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public CategoryProduct listarId(int idInstitution) {
		// TODO Auto-generated method stub
		Optional<CategoryProduct> op = cR.findById(idInstitution);
		return op.isPresent() ? op.get() : new CategoryProduct();
	}

}
