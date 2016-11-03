package com.mnr.struts.actions;

import com.opensymphony.xwork2.ActionSupport;;

public class EnterProtein extends ActionSupport{

	private int enteredProtein;
	
	@Override
	public String execute() throws Exception {
		
		ProteinTrackingService proteinTrackingService = new ProteinTrackingService();
		proteinTrackingService.addProtein(enteredProtein);
		
		return SUCCESS;
		
	}

	public int getEnteredProtein() {
		return enteredProtein;
	}

	public void setEnteredProtein(int enterProtein) {
		this.enteredProtein = enterProtein;
	}
	
	public String getGoalText(){
		return getText("goal.text");
	}
}
