
package com.amit.Practice;

class MethodReference {

	public static void view() {
		System.out.println("method reference...");
	}

	public static void main(String[] args) {

		// Method reference :: (scope resolution operator)
		// We can use scope resolution operator as Method reference and Constructor
		// Reference

		// With Lamda Expression
		MovieRef movie = () -> System.out.println("lamda implementation...");
		movie.display();

		// with Method reference
		MovieRef movie2 = MethodReference::view;
		movie2.display();

	}

}

interface MovieRef {
	public void display();
}