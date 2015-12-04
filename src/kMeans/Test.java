package kMeans;

import java.util.ArrayList;

import model.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> tests = new ArrayList<User>();
		Run algo = new Run();
		User u1 = new User(47.7330, 7.3133);
		User u2 = new User(47.7290, 7.3093);
		
		System.out.println("u1 : " + u1);
		System.out.println("u2 : " + u2);
		
		tests.add(u1);
		tests.add(u2);
		
		ArrayList<User> problems = algo.problemDetected(tests);
		if(problems != null){
			System.out.println(problems);
		}
	}

}
