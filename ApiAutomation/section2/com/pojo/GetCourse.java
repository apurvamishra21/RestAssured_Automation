package com.pojo;

public class GetCourse {
	
	//For all other variables it will directly fetch the value but for courses it will go to the courses class execute the entire piece of code and come back
	private String url;
	private String services;
	private String expertise;
	private Courses Courses;//courses is  mini json
	private String instructor;
	private String linkedIn;
	
	

	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public com.pojo.Courses getCourses() {
		return Courses;
	}
	public void setCourses(com.pojo.Courses courses) {
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	

}
