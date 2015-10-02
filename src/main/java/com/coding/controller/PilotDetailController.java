package com.coding.controller;

import java.io.IOException;
import java.io.InputStream;

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

import com.coding.model.Pilot;
import com.coding.model.SpaceShip;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Controller
public class PilotDetailController {

	private static final String BASE_URL = "http://swapi.co/api/";
	private static final String PILOT_URL = "peoples/";
	private ObjectMapper objectMapper;
	private Pilot	pilot;
	
	@RequestMapping("/pilotDetail/{id}")
	public ModelAndView pilotDetail(String id) {
		try {
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(BASE_URL + PILOT_URL + id);
				HttpResponse response = client.execute(request);
				InputStream inputStream = response.getEntity().getContent();
				pilot = objectMapper.readValue(IOUtils.toByteArray(inputStream), Pilot.class);
		}
		catch (ClientProtocolException e)
		{
				log.debug("Client Protocol Exception");
				
		}
		catch (IOException ex)
		{
				log.debug("IO Exception");
				
		} 
		return new ModelAndView("pilotDetail", "Pilot", pilot);
	}
	
	
}
