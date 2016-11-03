package com.mnr.test;

import com.mnr.beans.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("john@ad.com","1234");
		
		if(user.validate()){
			System.out.println("Bean validates OK.");
		}else{
			System.out.println(user.getMessage());
		}
	}

}
