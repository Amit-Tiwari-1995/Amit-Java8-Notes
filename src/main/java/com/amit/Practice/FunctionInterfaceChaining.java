package com.amit.Practice;

import java.util.function.Function;

public class FunctionInterfaceChaining {

	public static void main(String[] args) {

		// andThen() and compose() are default methods in Function interface.I it used
		// for function chaining.
		// (f1).andThen(f2) : f1 will be applied followed by f2
		// (f1).compose(f2) : f2 will be applied followed by f1

		// andThen() and compose

		// Ex 1
		Function<String, String> function1 = s -> s.toUpperCase(); // NARAYAN

		Function<String, String> function2 = s -> s.substring(0, 5); // Naray

		System.out.println((function1).andThen(function2).apply("Narayan")); // NARAY

		System.out.println((function1).compose(function2).apply("Narayan")); // NARAY

		// Ex 2
		Function<Integer, Integer> function3 = i -> i + i; // 12
		Function<Integer, Integer> function4 = i -> i * i * i; // 216

		System.out.println(function3.andThen(function4).apply(6)); // 1728

		System.out.println(function3.compose(function4).apply(6)); // 432

	}

}
