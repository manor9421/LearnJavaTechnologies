package com.infiniteskills.data.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

//@MappedSuperclass// наследник будет иметь все эти методы и поля. Имеет смысл, если у таблиц некоторые одинаковые колонки
@Entity// #jpa
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)// #jpa
public abstract class Investment {

	@Id// #jpa
	@GeneratedValue(strategy=GenerationType.TABLE,generator="key_generator")// #jpa
	@TableGenerator(table="ifinances_keys",pkColumnName="pk_name",
		valueColumnName="pk_value",name="key_generator")// #jpa
	@Column(name="INVESTMENT_ID")// #jpa
	private Long investmentId;// #jpa
	
	@JoinColumn(name="PORTFOLIO_ID")// #jpa
	@ManyToOne(cascade=CascadeType.ALL)// #jpa
	private Portfolio portfolio;// #jpa
	
	
	@Column(name = "NAME")
	protected String name;

	@Column(name = "ISSUER")
	protected String issuer;

	@Column(name = "PURCHASE_DATE")
	protected Date purchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}