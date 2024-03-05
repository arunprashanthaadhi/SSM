package com.ssm.webapp.model;
public class Student {
	private int userId;
	private int rollNumber;
	private String name;
	private int english;
	private int cs;
	private int maths;
	private int physics;
	private int chemistry;
	 private String firstName;
	    private String lastName;
	    private String dob; 
	    private String email;
	    private String address;
	    private String about;
	    private String username; 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
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
	        return "Student{" +
	                "userId=" + userId +
	                ", rollNumber=" + rollNumber +
	                ", name='" + name + '\'' +
	                ", english=" + english +
	                ", cs=" + cs +
	                ", maths=" + maths +
	                ", physics=" + physics +
	                ", chemistry=" + chemistry +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", dob='" + dob + '\'' +
	                ", email='" + email + '\'' +
	                ", address='" + address + '\'' +
	                ", about='" + about + '\'' +
	                ", username='" + username + '\'' +
	                '}';
	    }
}
