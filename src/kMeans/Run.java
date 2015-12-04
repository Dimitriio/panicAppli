package kMeans;

import java.util.ArrayList;

import model.User;

public class Run {

	private final double EARTH_RADIUS = 6378140.0;
	private final double DELTA_ALERT = 0.00629; // distance between two
												// people to be consider
												// in the same group
	private final int NUMBER_TO_WARN = 2; // number of persons in the
											// group for warning
											// authorities

	public Run() {
		// CARPE DIEM
	}

	@Deprecated
	public double distance(User u1, User u2) {
		// Spheric coordinates converted in cartesian coordinates
		double dist = 0.0;

		double x1 = -(this.EARTH_RADIUS * Math.cos(u1.getLongitude()))
				* Math.cos(u1.getLatitude());
		double y1 = -(this.EARTH_RADIUS * Math.cos(u1.getLongitude()))
				* Math.sin(u1.getLatitude());
		double z1 = -(this.EARTH_RADIUS * Math.sin(u1.getLongitude()));

		double x2 = -(this.EARTH_RADIUS * Math.cos(u2.getLongitude()))
				* Math.cos(u2.getLatitude());
		double y2 = -(this.EARTH_RADIUS * Math.cos(u2.getLongitude()))
				* Math.sin(u2.getLatitude());
		double z2 = -(this.EARTH_RADIUS * Math.sin(u2.getLongitude()));

		System.out.println("x1 : " + x1 + " x2 : " + x2 + " y1 : " + y1
				+ " y2 : " + y2 + " z1 : " + z1 + " z2 : " + z2);
		dist += Math.pow(x1 - x2, 2);
		dist += Math.pow(y1 - y2, 2);
		dist += Math.pow(z1 - z2, 2);
		System.out.println(Math.sqrt(dist));
		return Math.sqrt(dist);
	}

	public ArrayList<User> problemDetected(ArrayList<User> calls) {
		ArrayList<User> copy = new ArrayList<User>();
		int[] proximity = new int[calls.size()];
		for(int k = 0; k < proximity.length; k++){
			proximity[k] = 1;
		}
		
		for (int i = 0; i < calls.size(); ++i) {
			for (int j = 0; j < i; j++) {
				if ((Math.abs(calls.get(i).getLatitude() - calls.get(j).getLatitude()) < this.DELTA_ALERT)
						&& (Math.abs(calls.get(i).getLongitude()
								- calls.get(j).getLongitude()) < this.DELTA_ALERT)) {
					proximity[i]++;
					copy.add(calls.get(i));
				}
			}
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
