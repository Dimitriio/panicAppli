package kMeans;

import java.util.ArrayList;
import java.util.Random;

import model.User;

public class Run {

	private final static double EARTH_RADIUS = 6378140.0;
	private final static double DISTANCE_ALERT = 500.0; // distance between two
														// people to be consider
														// in the same group
	private final static int NUMBER_TO_WARN = 20; // number of persons in the
													// group for warning
													// authorities

	public double distance(User u1, User u2) {
		//Spheric coordinates converted in cartesian coordinates
		double dist = 0.0;
		double x1 = (-this.EARTH_RADIUS)*Math.cos(u1.getLongitude())*Math.cos(u1.getLatitude());
		double y1 = (-this.EARTH_RADIUS)*Math.cos(u1.getLatitude())*Math.sin(u1.getLongitude());
		double z1 = this.EARTH_RADIUS*Math.sin(u1.getLatitude());
		double x2 = (-this.EARTH_RADIUS)*Math.cos(u2.getLongitude())*Math.cos(u2.getLatitude());
		double y2 = (-this.EARTH_RADIUS)*Math.cos(u2.getLatitude())*Math.sin(u2.getLongitude());
		double z2 = this.EARTH_RADIUS*Math.sin(u2.getLatitude());
		dist += Math.pow(x1 - x2, 2);
		dist += Math.pow(y1 - y2, 2);
		dist += Math.pow(z1 - z2, 2);
		return Math.sqrt(dist);
	}

	public ArrayList<User> problemDetected(ArrayList<User> calls) {
		ArrayList<User> copy = new ArrayList<User>(calls);
		int[] proximity = new int[calls.size()];
		for (int i = 0; i < calls.size(); ++i) {
			copy.remove(i);
			for (User user : copy) {
				if (distance(calls.get(i), user) < this.DISTANCE_ALERT) {
					proximity[i]++;
				}
			}
			copy.add(i, calls.get(i));
		}

		ArrayList<User> res = new ArrayList<User>();
		for (int j = 0; j < proximity.length; ++j) {
			if (proximity[j] >= this.NUMBER_TO_WARN) {
				res.add(calls.get(j));
			}
		}
		return res;
	}

}
