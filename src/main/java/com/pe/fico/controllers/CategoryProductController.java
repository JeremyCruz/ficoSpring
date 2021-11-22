package com.pe.fico.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.pe.fico.entities.CategoryProduct;
import com.pe.fico.service.ICategoryProductService;

@Controller
@RequestMapping("/categories")
public class CategoryProductController {

	@Autowired
	private ICategoryProductService cService;

	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new CategoryProduct());
		return "category/category";
	}

	@GetMapping("/list")
	public String listCategories(Model model) {
		try {
			model.addAttribute("category", new CategoryProduct());
			model.addAttribute("listaCategorias", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "category/listCategories";
	}

	@RequestMapping("/save")
	public String saveMarca(@ModelAttribute @Valid CategoryProduct category, BindingResult result, Model model, SessionStatus status)
			throws ParseException{
		if (result.hasErrors()) {
			return "category/category";
		} else {
			boolean flag=cService.insert(category);
			if (flag) {
				return "redirect:/categories/list";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/categories/new";
			}
		}
	}
}
