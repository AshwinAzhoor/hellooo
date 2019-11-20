package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ust.beans.Sales;
import com.ust.dao.productDao;


@RestController
public class productController {
	
	@Autowired
	productDao pdao;
	
	
	@RequestMapping(value = "/viewSales", headers = "Accept=application/json", method = RequestMethod.GET)
	public List viewMedList(@ModelAttribute("s") Sales s) {
		System.out.println("hjgfd");
		List SaleList = pdao.viewSalesList();
		return SaleList;
	}
	
	@RequestMapping(value = "getSalesById/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Sales getMedById(@PathVariable("pId") int pId) {
		return pdao.getSalesById(pId);
	}
	
	@RequestMapping(value = "search/{searchString}", method = RequestMethod.GET, produces = "application/json")
	public List<Sales> findMed(
			@PathVariable("searchString") String searchString) {

		List SalesList = pdao.searchList(searchString);
		return SalesList;
	}
	
	@RequestMapping(value = "/insertSales", method ={ RequestMethod.POST,RequestMethod.PUT})
	public void docInsert(@RequestBody Sales s) {
		if (s.getpId()== 0) {
			
			pdao.insertSales(s);
	} else {
		
			pdao.updateSales(s);
		}
	}
	
	
	@RequestMapping(value = "deleteSales/{pId}", method = RequestMethod.DELETE, produces = "application/json")
	public void DeleteSales(@PathVariable("pId") int pId) {
		 pdao.deleteSales(pId);
	}

}
