package com.coding.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Pilot {

	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String home_world;
	private Date created,edited;
	private List<String> films,species,vehicles,starships;
}
