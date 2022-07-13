package com.amit.Practice;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceLamdaExp {
	public static void main(String[] args) throws Throwable {

		// Functional interfaces and Lambda exprs

		Runnable runnable = () -> System.out.println("runnable method is invoked...");
		runnable.run();

		Callable<Integer> callable = () -> 10;
		System.out.println(callable.call());

		Predicate<String> predicate = (x) -> x.equals("amit");
		System.out.println(predicate.test("amit"));

		Consumer<String> consumer = (x) -> System.out.println(x);
		consumer.accept("amit");

		Comparator<String> comparator = (x1, x2) -> x1.compareTo(x2);
		System.out.println(comparator.compare("amit", "chotu"));

	}
}
