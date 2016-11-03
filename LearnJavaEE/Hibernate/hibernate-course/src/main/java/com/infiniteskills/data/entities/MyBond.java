package com.infiniteskills.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bond")
public class MyBond {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOND_ID")
	private Long id;

	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="ISSUER", nullable=false)
	private String issuer;
	
	@Column(name="PURCHASE_DATE", nullable=false)
	private Date purchaseDate;
	
	@Column(name="VALUE", nullable=false)
	private double value;
	
	@Column(name="INTEREST_RATE", nullable=false)
	private double interestRate;
	
	@Column(name="MATURITY_DATE", nullable=false, updatable=false)
	private Date marurityDate;
	
	@Column(name="PORTFOLIO_ID", nullable=false)
	private Long portfolioID;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getMarurityDate() {
		return marurityDate;
	}

	public void setMarurityDate(Date marurityDate) {
		this.marurityDate = marurityDate;
	}

	public Long getPortfolioID() {
		return portfolioID;
	}

	public void setPortfolioID(Long portfolioID) {
		this.portfolioID = portfolioID;
	}
	
}
