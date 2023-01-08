package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...
    
	// Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}
	
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(this.pin < 100000 || this.pin > 999999) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (this.id == confirmedAuthID) {
			return true;
		} else {
			this.authIncident();
			return false;
		}
	}
    
    // TO DO: Setters & Getters

}
