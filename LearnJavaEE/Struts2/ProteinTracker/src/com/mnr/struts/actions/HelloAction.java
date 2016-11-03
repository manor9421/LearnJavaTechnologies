package com.mnr.struts.actions;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	
	private String greeting;
	
	@Override
	public String execute() throws Exception {
		
		setGreeting("Hello Struts 2");
		
		return "success";
		
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
/*
struts.xml - yе нужен, потому что мы добавили struts2-convension jar
<?xml version="1.0" encoding="UTF-8"?>

 <!DOCTYPE struts PUBLIC
    "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
    "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>
	<package name="main" extends="struts-default">
		<action name="hello" class="com.mnr.struts.HelloAction" >
			<result name="success">/hello.jsp</result>
		</action>
	</package>

</struts>


*/