package com.coding.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SpaceShip {

	private String name,model,manufacturer,costInCredits,length,
	maxAtmospheringSpeed,crew,passengers,cargoCapacity,consumbles,hyperdriveRating,
	MGLT,starShipClass;
	private List<String> pilots;
	private List<String> films;
	private Date created;
	private Date edited;
	
}