package com.infiniteskills.data.entities.ids;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CurrencyId implements Serializable{// Serializable - просто маркер для JPA, который показывает, что класс хранит PK

	private String name;

	private String countryName;

	public CurrencyId(){
		
	}
	
	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}

	public final String getName() {
		return name;
	}

	public final String getCountryName() {
		return countryName;
	}

}