package com.product.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.product.domain.Product;
import com.product.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	ProductService productDaoService;
	@RequestMapping("/")
	public ModelAndView initialize(Model model)
	{
		return new ModelAndView("redirect:addproductdetail");
	}
	@RequestMapping("addproductdetail")
	public ModelAndView addproduct(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		
		return new ModelAndView("product");
		
	}

	@RequestMapping(value="addproduct",method=RequestMethod.POST)
	public ModelAndView getDeatilOfProduct(@ModelAttribute("product") Product objProduct,Model model) throws Exception
	{
		try
		{
			Product objGetProduct=new Product();
			objGetProduct.setCategory(objProduct.getCategory());
			objGetProduct.setFullName(objProduct.getFullName());
			objGetProduct.setLatitude(objProduct.getLatitude());
			objGetProduct.setLongitude(objProduct.getLongitude());
			objGetProduct.setRating(objProduct.getRating());
			productDaoService.insertProductDetail(objProduct);
			String Message="store detail added successfully";
			model.addAttribute("message",Message);
			return new ModelAndView("redirect:addproductdetail","model",model);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("search")
	public ModelAndView getsearch()
	{
		return new ModelAndView("findproduct");
	}
	
	@RequestMapping(value="searchproduct",method=RequestMethod.POST)
	public ModelAndView getSearchResult(@RequestParam("name") String name,Model model) throws Exception
	{
		try
		{
			List<Product> listProducts=Collections.emptyList();
			if(name != null)
			{	
				listProducts=productDaoService.searchFullText(name);
			}
		model.addAttribute("liofproducts", listProducts);
		return new ModelAndView("viewproductinfo","model",model);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}