package com.coding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coding.model.Pilot;

@Controller
public class PilotDetailController {

	@RequestMapping("/pilotDetail/{id}")
	public ModelAndView spaceShipDetail(String id) {
		
		Pilot pilot = new Pilot();
		return new ModelAndView("pilotDetail", "Pilot", pilot);
	}
}
