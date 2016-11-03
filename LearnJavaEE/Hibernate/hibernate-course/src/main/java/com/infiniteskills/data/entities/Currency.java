package com.infiniteskills.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.infiniteskills.data.entities.ids.CurrencyId;

@Entity
@IdClass(CurrencyId.class)// в этом классе имена здешних PK - такие же!!!
public class Currency {

	@Id// PK
	@Column(name="NAME")
	private String name;

	@Id// PK
	@Column(name="COUNTRY_NAME")
	private String countryName;

	@Column(name="SYMBOL")
	private String symbol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}