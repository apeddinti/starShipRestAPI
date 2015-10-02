package com.coding.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.coding.model.SpaceShip;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Controller
public class ListAllSpaceShipsController extends MultiActionController{
	
	 private static final String BASE_URL = "http://swapi.co/api/";
	 private static final String SPACE_SHIP_URL = "spaceships/";
	 
	private ObjectMapper objectMapper;
	
	private List<SpaceShip> listSpaceShip;
	
	public ListAllSpaceShipsController()
	{
		objectMapper = new ObjectMapper();
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(BASE_URL + SPACE_SHIP_URL);
			HttpResponse response = client.execute(request);
			InputStream inputStream = response.getEntity().getContent();
			listSpaceShip = objectMapper.readValue(IOUtils.toByteArray(inputStream), List.class);
			}
			catch (ClientProtocolException e)
			{
				log.debug("Client Protocol Exception");
				listSpaceShip = new ArrayList<SpaceShip>();
			}
			catch (IOException ex)
			{
				log.debug("IO Exception");
				listSpaceShip = new ArrayList<SpaceShip>();
			} 
	}
	
	@RequestMapping("/listSpaceShips")
	@ResponseBody
	public  ModelAndView listSpaceShips()  {
		return new ModelAndView("listAllSpaceShips", "List", this.listSpaceShip);
	}
	
	@RequestMapping("/searchSpaceShipByShipName")
	public ModelAndView searchSpaceShipByShipName(String shipName) {
	
		SpaceShip spaceShip = listSpaceShip.stream().filter(c -> c.getName().equalsIgnoreCase(shipName)).findAny().get();
		
		return new ModelAndView("searchListByShipName", "spaceShipByShipName", spaceShip);
	}

	@RequestMapping("/SortListByPrice")
	public ModelAndView sortListByPrice() {
 
		 Comparator<SpaceShip> byPrice = (s1, s2) -> Double.compare(
		            Double.parseDouble(s1.getCost_in_credits()), Double.parseDouble(s2.getCost_in_credits()));
		 
		listSpaceShip.stream().sorted(byPrice);
		return new ModelAndView("sortListByPrice", "List", listSpaceShip);
	}
	
	@RequestMapping("/filterListByPrice")
	public ModelAndView filterListByPrice(String price) {
		
		SpaceShip spaceShip = listSpaceShip.stream()
										.filter(c -> c.getCost_in_credits().equalsIgnoreCase(price)).findAny()
										.get();
		return new ModelAndView("filterListByPrice", "spaceShip", spaceShip);
	}
	
}
