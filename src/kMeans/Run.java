package kMeans;

import java.util.ArrayList;
import java.util.Random;

import model.User;

public class Run {
	private Random rand = new Random();
	private int nbClusters = 2;
	
	public User generateUser() {
		double x = new Double(rand.nextDouble());
		double y = new Double(rand.nextDouble());
		User res = new User(x, y);
		return res;
	}
	
	public double distance(User u1, User u2) {
		double dist = 0.0;
		dist += Math.pow(u1.getLatitude() - u2.getLatitude(), 2);
		dist += Math.pow(u1.getLongitude() - u2.getLongitude(), 2);
		return Math.sqrt(dist);
	}
	
	public User[] generateClusters() {
		User[] res = new User[this.nbClusters];
		for(int i = 0; i < res.length; ++i){
			res[i] = this.generateUser();
		}
		
		return res;
	}
	
	public int[] clusterMap(ArrayList<User> calls) {
		return null;
	}
	
	
}
