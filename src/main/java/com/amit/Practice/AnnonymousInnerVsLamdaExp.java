package com.amit.Practice;

public class AnnonymousInnerVsLamdaExp {

	public static void main(String[] args) {

		// Annonymous inner class VS Lamda
		// Note : Every anno. inner class can't be replace with lamda exp (some cases
		// are valid)
		// If your interface contains only one abstarct method(functional interface) in
		// that case you can use Lamda exprs in place of Anno, inner class.
		// Inside anno. inner class we can declare instance variable and inside lambda
		// express variable declare act as local variable
		// Inside anno. inner class 'this' always refers current inner class object but
		// inside lamda exprs 'this' always refers current outer class object.

		// Annonymous Inner class

		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("hello");
			}

		};

		Thread t1 = new Thread(runnable);
		t1.start();

		// With Lamda Exprsn

		Runnable runnableLamda = () -> System.out.println("hello lamda");
		Thread t2 = new Thread(runnableLamda);
		t2.start();

		// more short code by passing in Thread Constructor as Runnable interface object
		// as parameter

		Thread t3 = new Thread(() -> System.out.println("hey guys"));
		t3.start();

	}

}
