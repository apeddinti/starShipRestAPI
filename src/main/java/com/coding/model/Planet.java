package com.coding.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Planet {

	private String name,rotationPeriod,orbitalPeriod,diameter,climate,gravity,terrian,
	surfaceWater,population;
	private Date created,edited;
	private List<String> residents,films;
}