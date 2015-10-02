package com.coding.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.coding.model.SpaceShip;
import com.fasterxml.jackson.databind.ObjectMapper;


@Slf4j
@Controller
public class SpaceShipViewController {
	
	private static final String BASE_URL = "http://swapi.co/api/";
	private static final String SPACE_SHIP_URL = "spaceships/";
	private ObjectMapper objectMapper;
	
	private SpaceShip spaceShip;
	
	@RequestMapping("/spaceShipDetail/{id}")
	public ModelAndView spaceShipDetail(String id) {
		try {
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(BASE_URL + SPACE_SHIP_URL + id);
				HttpResponse response = client.execute(request);
				InputStream inputStream = response.getEntity().getContent();
				spaceShip = objectMapper.readValue(IOUtils.toByteArray(inputStream), SpaceShip.class);
		}
		catch (ClientProtocolException e)
		{
				log.debug("Client Protocol Exception");
				spaceShip = new SpaceShip();
		}
		catch (IOException ex)
		{
				log.debug("IO Exception");
				spaceShip = new SpaceShip();
		} 
		return new ModelAndView("spaceShipDetail", "SpaceShip", spaceShip);
	}
}
