
package com.amit.Practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ConsumerInterface {

	public static void main(String[] args) {

		// Consumer<T> Interface has accept method, it accepts a value and it returns
		// void.

		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String str) {
				System.out.println(str.length());
			}
		};
		consumer.accept("amit");

		Consumer<String> consumer2 = s -> System.out.println(s.length());
		consumer2.accept("amit");

		// Program to display Movie Information using Consumer

		List<Movie> movieList = Arrays.asList(new Movie("PK", "AAMIR", "ANUSHKA"),
				new Movie("TIGER", "SALMAN", "KATRINA"));

		Consumer<Movie> consumerMovie = m -> System.out.println(m);

		for (Movie m : movieList) {
			consumerMovie.accept(m);
		}

		// Program to display StudentInfo Information using Predicate, Function and
		// Consumer.

		List<StudentInfo> listStudentInfo = Arrays.asList(new StudentInfo("Amit", 91), new StudentInfo("Mayank", 67),
				new StudentInfo("Ajay", 83), new StudentInfo("Raman", 57), new StudentInfo("Kushal", 42));

		// --predicate to check student marks should be greater then 60
		Predicate<StudentInfo> predicateStudentInfo = s -> s.getStudentMarks() >= 60;

		// --Grade of student using function
		Function<StudentInfo, String> functionStudentInfo = s -> {
			if (s.getStudentMarks() >= 90) {
				return "A+";
			} else if (s.getStudentMarks() >= 80) {
				return "A";
			} else
				return "B+";
		};

		// -- to display student information
		Consumer<StudentInfo> studentConsumer = s -> System.out.println(s);

		for (StudentInfo s : listStudentInfo) {
			if (predicateStudentInfo.test(s)) {
				studentConsumer.accept(s);
				System.out.println("Grade of " + s.getStudentMarks() + " " + functionStudentInfo.apply(s));
			}
		}

	}

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Movie {
	private String movieName;
	private String actorName;
	private String actressName;

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class StudentInfo {
	private String studentName;
	private Integer studentMarks;

}
