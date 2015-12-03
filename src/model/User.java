package model;

public class User {
	private float latitude;
	private float longitude;
	
	public User(float la, float lo){
		this.latitude = la;
		this.longitude = lo;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}	
	
}
