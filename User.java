package com.caresoft.clinicapp;

public class User {
	protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
    public Integer getId() {
    	return this.id;
    }
    
    public Integer getPin() {
    	return this.pin;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public void setPin(Integer pin) {
    	this.pin = pin;
    }
    // Implement a constructor that takes an ID
    public User(Integer id) {
    	this.id = id;
    }
}
