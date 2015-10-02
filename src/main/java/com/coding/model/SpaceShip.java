package com.coding.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SpaceShip {
	private String name,model,manufacturer,cost_in_credits,length,
	max_atmosphering_speed,crew,passengers,cargo_capacity,consumbles,hyperdrive_rating,
	MGLT,starship_class;
	private List<String> pilots;
	private List<String> films;
	private String created;
	private String edited;	
}