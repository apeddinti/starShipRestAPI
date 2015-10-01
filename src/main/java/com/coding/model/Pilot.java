package com.coding.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Pilot {

	private String name,height,mass,hairColor,skinColor,eyeColor,birthYear,gender,
	homeWorld;
	private Date created,edited;
	private List<String> films,species,vehicles,starships;
}