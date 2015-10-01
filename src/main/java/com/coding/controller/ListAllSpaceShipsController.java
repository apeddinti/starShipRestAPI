package com.coding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.coding.model.SpaceShip;

@Controller
public class ListAllSpaceShipsController extends MultiActionController{
	
	@RequestMapping("/listSpaceShips")
	public ModelAndView listSpaceShips() {
 
		List<SpaceShip> listSpaceShip = new ArrayList<SpaceShip>();
		return new ModelAndView("listAllSpaceShips", "List", listSpaceShip);
	}
	
	@RequestMapping("/listSpaceShipsbyShipName")
	public ModelAndView listSpaceShipsbyShipName(String shipName) {
 
		List<SpaceShip> listSpaceShipByShipName = new ArrayList<SpaceShip>();
		return new ModelAndView("searchListByShipName", "List", listSpaceShipByShipName);
	}

	@RequestMapping("/SortListByPrice")
	public ModelAndView sortListByPrice() {
 
		List<SpaceShip> sortListByPrice = new ArrayList<SpaceShip>();
		return new ModelAndView("sortListByPrice", "List", sortListByPrice);
	}
	
	@RequestMapping("/filterListByPrice")
	public ModelAndView filterListByPrice() {
 
		List<SpaceShip> filterListByPrice = new ArrayList<SpaceShip>();
		return new ModelAndView("filterListByPrice", "List", filterListByPrice);
	}
	
}
