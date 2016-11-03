package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.MyBond;

public class ITry {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		MyBond b = new MyBond();
		
		b.setName("Roman");
		b.setIssuer("Abc");
		b.setPurchaseDate(new Date());
		b.setValue(10.2);
		b.setInterestRate(2);
		b.setMarurityDate(new Date());
		b.setPortfolioID(2L);
		
		session.save(b);
		
		t.commit();
		
		session.close();
		
	}
}
