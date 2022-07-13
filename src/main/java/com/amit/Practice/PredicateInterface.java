
package com.amit.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class PredicateInterface {

	public static void main(String[] args) {

		// Predicate
		// It use Test() method and use to check boolean condition
		// It is for conditional check

		Predicate<Integer> predicate = new Predicate<Integer>() {
			public boolean test(Integer i) {
				if (i > 10) {
					return true;
				} else
					return false;
			}
		};

		System.out.println(predicate.test(11));

		// Predicate with lamda exp
		Predicate<Integer> predicateLamda = (i) -> i > 10;

		System.out.println(predicateLamda.test(9));

		// Predicate to find length of string is greater than 5 or not

		Predicate<String> predicate1 = (s) -> s.length() > 5;
		System.out.println("tiwari");

		// Predicate to check Collection is empty or not

		Predicate<Collection> predicate2 = (c) -> c.isEmpty();
		List<String> list = new ArrayList<>();
		System.out.println(predicate2.test(list));

		// Predicate to display name starting with 'K'

		String names[] = { "Amit", "Krunal", "Don", "Karan" };
		Predicate<String> predicate3 = (s) -> s.startsWith("K");
		for (String s : names) {
			if (predicate3.test(s))
				System.out.println(s);
		}

		// Predicate to remove null values and empty String from list

		String str[] = { "Amit", null, "Don", "" };

		Predicate<String> predicate4 = (s) -> s != null && s.length() > 0;
		List<String> list2 = new ArrayList<String>();

		for (String s : str) {
			if (predicate4.test(s)) {
				list2.add(s);
			}
		}

		System.out.println(list2);

		// Predicate for user authentication
		List<User> listUsers = Arrays.asList(new User("amit", "amit@1995"), new User("amit1", "amit@1997"));

		Predicate<User> predicate5 = (u) -> u.getPassword().equals("amit@1995");

		for (User u : listUsers) {
			if (predicate5.test(u)) {
				System.out.println("For " + u.getUserName() + " Password is correct");
			} else {
				System.out.println("For " + u.getUserName() + " Password is incorrect");
			}
		}

		// Predicate Interface isEqual() : to check equality purpose

		Predicate<String> predicate6 = Predicate.isEqual("amit");
		System.out.println(predicate6.test("amit"));

	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
	private String userName;
	private String password;
}
