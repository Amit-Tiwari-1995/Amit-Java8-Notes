
package com.amit.Practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FunctionInterface {

	public static void main(String[] args) {

		// Function<T,R> in 'T' is input parameter and 'R' Return type and it has
		// apply() method. Function can return any type : Integer, String, Class
		// Object.

		Function<String, Integer> functionAnno = new Function<String, Integer>() { // here String is Input parameter and
																					// Integer is return type
			public Integer apply(String str) {
				return str.length();
			}

		};

		System.out.println(functionAnno.apply("ankit"));

		// Function interface with Lamda Exprs
		Function<String, Integer> function = s -> s.length();
		System.out.println(function.apply("amit"));

		// Function Interface to return square for Integer
		Function<Integer, Integer> function2 = i -> i * i;
		System.out.println(function2.apply(11));

		// Function Interface to remove spaces in String
		Function<String, String> function3 = s -> s.replace(" ", "");
		System.out.println(function3.apply("this is just the beginning"));

		// Function Interface to count number of spaces in String
		Function<String, Integer> function4 = s -> {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ') {
					count++;
				}

			}
			return count;
		};
		System.out.println(function4.apply(" this is just the beginning "));
		// short approach for this
		Function<String, Integer> function5 = s -> s.length() - s.replace(" ", "").length();
		System.out.println(function5.apply(" this is just the beginning "));

		// Function Interface to find Student grade
		Function<Student, String> function6 = s -> {
			if (s.getGrade() > 90) {
				return "A+";
			} else if (s.getGrade() > 80) {
				return "A";
			} else
				return "B+";
		};
		List<Student> listStudent = Arrays.asList(new Student("Amit", 86), new Student("Ajay", 92),
				new Student("Anand", 78));

		for (Student s : listStudent) {
			System.out.println(s.getName() + " " + function6.apply(s));
		}

		// Perform salary increment of Employee using Function and Predicate
		List<Employee> listEmployee = Arrays.asList(new Employee("Amit", 4500), new Employee("Ajay", 2500),
				new Employee("Anand", 7000));
		Predicate<Employee> predicate = e -> e.getSalary() < 3000;
		Function<Employee, Employee> function7 = e -> {
			Integer salIncremented = e.getSalary() + 2000;
			e.setSalary(salIncremented);
			return e;
		};

		for (Employee e : listEmployee) {
			if (predicate.test(e)) {
				System.out.println("salary before :" + e.getSalary() + " " + function7.apply(e));

			}
		}

	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {

	private String name;
	private Integer grade;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {

	private String name;
	private Integer salary;
}
