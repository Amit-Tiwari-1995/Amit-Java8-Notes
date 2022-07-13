
package com.amit.Practice;

import java.util.Date;
import java.util.function.Supplier;

class SupplierInterface {

	public static void main(String[] args) {

		// Supplier<T> will return T type and it has get() method

		Supplier<String> supplier = new Supplier<String>() {
			public String get() {
				return "amit";
			}
		};
		System.out.println(supplier.get());

		Supplier<Integer> supplier2 = () -> 10;
		System.out.println(supplier2.get());

		// Supply system date using Supplier

		Supplier<Date> supplier3 = () -> new Date();
		System.out.println(supplier3.get());

		// Random name using Supplier

		Supplier<String> supplier4 = () -> {
			String[] names = { "amit", "anand", "mayank", "ankit", "ajay" };
			int x = (int) (Math.random() * 4);
			System.out.println(x);
			return names[x];

		};
		System.out.println(supplier4.get());

		// Random OTP using Supplier -- 6 digit -- 0-9

		Supplier<String> supplier5 = () -> {
			String otp = "";
			for (int i = 0; i < 6; i++) {
				otp = otp + (int) (Math.random() * 10);

			}
			return otp;
		};

		System.out.println(supplier5.get());

		// Random Password using Supplier -- should be 8 characters -- 2 4 6 8 places
		// digits -- 1 3 5 7 places alphabets and symbols

		Supplier<String> supplierPassword = () -> {
			String password = "";
			Supplier<Integer> digits = () -> (int) (Math.random() * 10); // to generate random numbers
			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
			Supplier<Character> characters = () -> symbols.charAt((int) (Math.random() * 28)); //// to generate random
																								//// characters

			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) {
					password = password + digits.get();
				} else {
					password = password + characters.get();
				}
			}

			return password;
		};

		System.out.println(supplierPassword.get());

	}

}