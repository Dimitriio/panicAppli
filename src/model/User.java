package model;

public class User {
	private double latitude;
	private double longitude;
	
	public User(double d, double e){
		this.latitude = d;
		this.longitude = e;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}	
	
}
