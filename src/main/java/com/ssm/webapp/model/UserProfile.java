package com.ssm.webapp.model;

public class UserProfile {

	    private String firstName;
	    private String lastName;
	    private String dob; 
	    private String email;
	    private String address;
	    private String about;
	    private String username; 

	    public UserProfile(String username, String firstName, String lastName, String dob, String email, String address, String about) {
	        this.username = username;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.dob = dob;
	        this.email = email;
	        this.address = address;
	        this.about = about;
	    }
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getAbout() {
	        return about;
	    }

	    public void setAbout(String about) {
	        this.about = about;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    @Override
	    public String toString() {
	        return "User{" +
	                "firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", dob='" + dob + '\'' +
	                ", email='" + email + '\'' +
	                ", address='" + address + '\'' +
	                ", about='" + about + '\'' +
	                ", username='" + username + '\'' +
	                '}';
	    }
}
