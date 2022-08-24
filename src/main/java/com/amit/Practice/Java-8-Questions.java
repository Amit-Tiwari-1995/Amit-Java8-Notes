package com.amit.Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Main {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student(1, "Amit", 67, "M", "PCM", 26),
				new Student(2, "Roshni", 83, "F", "COMMERCE", 19), new Student(3, "Lakhan", 43, "M", "PCM", 25),
				new Student(4, "Ajeesh", 71, "M", "COMMERCE", 27), new Student(5, "Richa", 91, "F", "PCM", 22));

		// Names of employees whose age is greater than 25
		list.stream().filter(l -> l.getAge() > 25).map(l -> l.getName()).forEach(System.out::println);

		// Count employees with age less than 25
		long count = list.stream().filter(l -> l.getAge() < 25).count();
		System.out.println(count);

		// find employee details with name "Richa"
		list.stream().filter(l -> l.getName().equals("Richa")).forEach(System.out::println);

		// Find maximum age of employee
		Integer maxAge = list.stream().max((l1, l2) -> l1.getAge() - l2.getAge()).map(l -> l.getAge()).get();
		System.out.println(maxAge);
		// another approach
		list.stream().sorted((l1, l2) -> l2.getAge() - l1.getAge()).map(l -> l.getAge()).limit(1)
				.forEach(System.out::println);

		// Sort employees on basis of age
		list.stream().sorted((a, b) -> a.getAge() - b.getAge()).forEach(System.out::println);

		// Join employees names with ","
		String collectJoin = list.stream().map(l -> l.getName()).collect(Collectors.joining(","));
		System.out.println(collectJoin);

		// Group student by name
		Map<String, List<Student>> collectName = list.stream().collect(Collectors.groupingBy(l -> l.getName()));
		System.out.println(collectName);

		// Questions based on Integers and Strings

		List<Integer> numbers = Arrays.asList(5, 10, 2, 0, 17, 44, 5, 13, 67, 2, 44, 101);

		// Print square of numbers and print those square which are less than 200
		numbers.stream().map(l -> l * l).filter(l -> l < 200).forEach(System.out::println);

		// even numbers in a list
		List<Integer> collectEven = numbers.stream().filter(l -> l % 2 == 0).collect(Collectors.toList());
		System.out.println(collectEven);

		// Print numbers starting with "1"
		List<String> collectStarts = numbers.stream().map(l -> l.toString()).filter(l -> l.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(collectStarts);

		// Duplicate numbers from list
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> collectDup = numbers.stream().filter(l -> !set.add(l)).collect(Collectors.toSet());
		System.out.println(collectDup);
		Set<Integer> collectDup1 = numbers.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting()))
				.entrySet().stream().filter(l -> l.getValue() > 1).map(l -> l.getKey()).collect(Collectors.toSet());
		System.out.println(collectDup1);
		Set<Integer> collectDup2 = numbers.stream().filter(l -> Collections.frequency(numbers, l) > 1)
				.collect(Collectors.toSet());
		System.out.println(collectDup2);

		// first number from list
		Integer findFirst = numbers.stream().findFirst().get();
		System.out.println(findFirst);

		String str = "dbcdcceedfgll";

		// first non repetitive character
		Character charFirst = str.chars().mapToObj(s -> (char) s)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() == 1).map(s -> s.getKey()).findFirst().get();
		System.out.println(charFirst);

	}

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Student {

	private int id;
	private String name;
	private int marks;
	private String gender;
	private String branch;
	private int age;

}
