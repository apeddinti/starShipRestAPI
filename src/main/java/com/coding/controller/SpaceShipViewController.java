package com.coding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coding.model.SpaceShip;

@Controller
public class SpaceShipViewController {
	
	@RequestMapping("/spaceShipDetail/{id}")
	public ModelAndView spaceShipDetail(String id) {
 
		SpaceShip spaceShip = new SpaceShip();
		return new ModelAndView("spaceShipDetail", "SpaceShipDetail", spaceShip);
	}
}
