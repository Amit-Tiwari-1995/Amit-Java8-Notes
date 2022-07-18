
package com.amit.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class StreamAPI {

	public static void main(String[] args) {

		// Stream is used to ordered collection.It has several methods which are
		// pipe line together and used in collection to get desired result.

		List<Integer> list = new ArrayList<Integer>();

		list.add(5);
		list.add(7);
		list.add(9);
		list.add(8);
		list.add(10);

		// without Stream even numbers
		List<Integer> listEven = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i % 2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println(listEven);
		// with Stream (filter method)

		List<Integer> listEven2 = list.stream().filter(l -> l % 2 == 0).collect(Collectors.toList());
		System.out.println(listEven2);

		// Every element double of original list without stream
		List<Integer> listDouble = new ArrayList<Integer>();

		for (Integer i : list) {
			listDouble.add(i * 2);
		}

		System.out.println(listDouble);

		// with stream (map method)
		List<Integer> listDouble2 = list.stream().map(l -> l * 2).collect(Collectors.toList());
		System.out.println(listDouble2);

		// Print names whose length is greater than 5
		List<String> listNames = Arrays.asList("amit", "rajeev", "lakhan", "narayan", "ajay");
		System.out.println(listNames.stream().filter(l -> l.length() > 5).collect(Collectors.toList()));
		// --convert first letter of names in upper case
		System.out.println(listNames.stream().map(l -> l.toUpperCase()).collect(Collectors.toList()));

		// Count() method. Number of element in Collection using count().
		System.out.println(listNames.stream().count());
		// --count whose name starts with 'a'
		System.out.println(listNames.stream().filter(l -> l.startsWith("a")).count());

		// Sorted() method of stream to sort collections.

		List<Integer> listNumbers = Arrays.asList(45, 11, 0, 23, 56, 7);
		// --Default sorting using sorted() method.
		System.out.println(listNumbers.stream().sorted().collect(Collectors.toList()));
		// --Customized sorting using sorted(Comparator<>) method. Ex : reversing
		// sorting of numbers
		System.out.println(listNumbers.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList()));

		// min() and max() method of stream.
		List<Integer> listNumb = Arrays.asList(45, 11, 0, 23, 56, 7);
		System.out.println(listNumb.stream().min((i1, i2) -> i1.compareTo(i2)).get());
		System.out.println(listNumb.stream().max((i1, i2) -> i1.compareTo(i2)).get());

		// forEach() method of stream

		List<String> listDemo = Arrays.asList("A", "B", "C");
		listDemo.stream().forEach(l -> System.out.println(l));
		// --using method reference
		listDemo.stream().forEach(System.out::println);

		// toArray() method : to copy elements from stream to array

		List<Integer> listNew = Arrays.asList(56, 78, 99, 23, 11, 9);
		Integer[] arr = listNew.stream().toArray(Integer[]::new);
		for (Integer i : arr) {
			System.out.println(i);
		}

		// print cube of only odd numbers
		List<Integer> numbers = Arrays.asList(4, 6, 3, 8, 2, 7);
		numbers.stream().filter(l -> l % 2 != 0).map(l -> l * l * l).forEach(System.out::println);

		// print number of characters of each course length
		List<String> names = Arrays.asList("amit", "raman", "lakhan", "ajay");
		names.stream().map(l -> l + " ").forEach(System.out::println);

		// Sum of all Integers using stream
		List<Integer> numbers1 = Arrays.asList(6, 4, 6, 7, 3, 10);
		System.out.println(numbers1.stream().reduce(0, (a, b) -> a + b));// a is aggregate and b is next number
		System.out.println(numbers1.stream().reduce(0, Integer::sum));
		// --find max number present in list using reduce()
		System.out.println(numbers.stream().reduce(0, (a, b) -> a > b ? a : b));

		// Square of every number in list and print sum of it
		List<Integer> numbers2 = Arrays.asList(5, 2, 9);
		System.out.println(numbers2.stream().map(l -> l * l).reduce(0, (a, b) -> a + b));

		// Cube of every number in list and print sum of it
		System.out.println(numbers2.stream().map(l -> l * l * l).reduce(0, (a, b) -> a + b));
		// find the sum of odd numbers in list
		System.out.println(numbers2.stream().filter(l -> l % 2 != 0).reduce(0, (a, b) -> a + b));

		// How PREDICATE,FUNCTION and CONSUMER works
		List<Integer> numbersEx = Arrays.asList(5, 11, 8, 10, 13, 27);

		Predicate<Integer> predicate = i -> i % 2 == 0;
		Function<Integer, Integer> function = i -> i * i;
		Consumer<Integer> consumer = i -> System.out.println(i);

		numbersEx.stream().filter(predicate).map(function).forEach(consumer);

		// Create Functional Interface of second argument of reduce() method :
		// Integer::sum
		List<Integer> numbersSum = Arrays.asList(7, 3, 10, 18, 12);

		System.out.println(numbersSum.stream().reduce(0, Integer::sum));
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		System.out.println(numbersSum.stream().reduce(0, sum));

		// allMatch(), noneMatch(), anyMatch()

		List<StudentDetail> listStudents = Arrays.asList(new StudentDetail(1, "Amit", 76),
				new StudentDetail(2, "Raman", 87), new StudentDetail(3, "Ajay", 65), new StudentDetail(4, "Albert", 98),
				new StudentDetail(5, "Rohit", 76), new StudentDetail(6, "Raman", 76));

		// Whether all student have marks greater than 70 : allMatch()
		System.out.println(listStudents.stream().allMatch(l -> l.getMarks() > 70));

		// Whether none student have marks greater than 70 : noneMatch()
		System.out.println(listStudents.stream().noneMatch(l -> l.getMarks() > 70));

		// Whether any student have marks greater than 70 : noneMatch()
		System.out.println(listStudents.stream().anyMatch(l -> l.getMarks() > 70));

		// Print top 3 marks getter using limit
		listStudents.stream().sorted((s1, s2) -> s2.getMarks().compareTo(s1.getMarks())).limit(3)
				.forEach(System.out::println);

		// Grouping using Stream.
		System.out.println(listStudents.stream().collect(Collectors.groupingBy(l -> l.getName())));

		// Count occurance of letters in list
		List<String> listCount = Arrays.asList("a", "c", "c", "g");
		System.out.println(listCount.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting())));
		// count number of times marks occurance in Student class
		System.out.println(
				listStudents.stream().collect(Collectors.groupingBy(l -> l.getMarks(), Collectors.counting())));

		System.out.println(listStudents.stream().collect(Collectors.groupingBy(l -> l.getMarks(),
				Collectors.maxBy((i1, i2) -> i2.getMarks().compareTo(i1.getMarks())))));

		System.out.println(listStudents.stream().collect(
				Collectors.groupingBy(l -> l.getName(), Collectors.mapping(l -> l.getName(), Collectors.toList()))));

		// Duplicate elements using Stream
		List<Integer> listDuplicate = Arrays.asList(17, 10, 5, 2, 90, 10, 17);
		Set<Integer> set = new HashSet<>();
		// print duplicate element from list using stream
		listDuplicate.stream().filter(l -> !set.add(l)).forEach(System.out::println);
		// remove duplicate element from list using stream
		listDuplicate.stream().filter(l -> set.add(l)).forEach(System.out::println);
		// count duplicate elements from list using Stream
		System.out.println(listDuplicate.stream().filter(l -> !set.add(l)).count());

		// Last element in list using stream
		list.stream().skip(list.size() - 1).forEach(System.out::println);

		// Not repetitive element from list using Stream
		List<Integer> listRep = Arrays.asList(17, 10, 5, 2, 90, 10, 17);
		listRep.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting())).entrySet().stream()
				.filter(l -> l.getValue() == 1).map(l -> l.getKey()).forEach(System.out::println);

		// Stream using Stream.of()
		Stream<Integer> stream = Stream.of(8, 7, 4, 4);
		System.out.println(stream.count());

		// Sum of first 100 numbers using IntStream

		IntStream streamSum = IntStream.range(1, 101);
		System.out.println(streamSum.sum());
		// --Sum of first 50 even numbers using IntStream
		IntStream streamEven = IntStream.range(1, 101);
		System.out.println(streamEven.filter(l -> l % 2 == 0).sum());

		// Sum of every third number.(First 10 numbers)
		System.out.println(IntStream.iterate(1, n -> n + 2).limit(10).sum());

		// Sum of first 10 even numbers are print them
		System.out.println(IntStream.iterate(2, n -> n + 2).limit(10).peek(System.out::println).sum());

		// Convert IntStream to list or Collections
		System.out.println(IntStream.iterate(2, n -> n + 2).limit(20).peek(System.out::println).boxed()
				.collect(Collectors.toList()));

		List<String> listStrings = Arrays.asList("Amit", "Binod", "Raman", "Lalit", "Akash");

		// Create one string by joining all the names separated by ','
		System.out.println(listStrings.stream().collect(Collectors.joining(",")));

		List<EmployeeDepartment> listDep = Arrays.asList(new EmployeeDepartment("Amit", "IT", 10000, "Active", "Male"),
				new EmployeeDepartment("Neha", "CS", 7000, "Inctive", "Female"),
				new EmployeeDepartment("Amkit", "IT", 11000, "Active", "Male"),
				new EmployeeDepartment("Reshma", "CA", 15000, "Active", "Female"),
				new EmployeeDepartment("Lakhan", "CA", 6000, "Inctive", "Male"));
		// Print Highest salary of employee in each department
		Map<String, Optional<EmployeeDepartment>> collect = listDep.stream()
				.collect(Collectors.groupingBy(EmployeeDepartment::getDepartment,
						Collectors.reducing(BinaryOperator.maxBy((a, b) -> a.getSalary().compareTo(b.getSalary())))));

		System.out.println(collect);

		// average salary of female and male employees
		Map<String, Double> collectAv = listDep.stream().collect(
				Collectors.groupingBy(EmployeeDepartment::getGender, Collectors.averagingDouble(l -> l.getSalary())));

		System.out.println(collectAv);

		// Highest paid employee
		EmployeeDepartment collectSal = listDep.stream()
				.collect(Collectors.maxBy((a, b) -> a.getSalary().compareTo(b.getSalary()))).get();
		System.out.println(collectSal);

		// Count the number of employees in each department

		Map<String, Long> collDepCount = listDep.stream()
				.collect(Collectors.groupingBy(EmployeeDepartment::getDepartment, Collectors.counting()));
		System.out.println(collDepCount);

		// Average salary of each department

		Map<String, Double> collectAvSal = listDep.stream().collect(
				Collectors.groupingBy(EmployeeDepartment::getDepartment, Collectors.averagingInt(l -> l.getSalary())));
		System.out.println(collectAvSal);

		// Lowest salary from IT department

		EmployeeDepartment employeeDepartment = listDep.stream().filter(l -> l.getDepartment().equals("IT"))
				.min((a, b) -> a.getSalary().compareTo(b.getSalary())).get();

		System.out.println(employeeDepartment);

		// How many male and female employee in IT

		Map<String, Long> collectCount = listDep.stream().filter(l -> l.getDepartment().equals("IT"))
				.collect(Collectors.groupingBy(EmployeeDepartment::getGender, Collectors.counting()));

		System.out.println(collectCount);

		// Separate the employees who have salary more than 10,000
		Map<Boolean, List<EmployeeDepartment>> collectSep = listDep.stream()
				.collect(Collectors.partitioningBy(l -> l.getSalary() > 10000));
		System.out.println(collectSep);

		// Highest salaried Employee name and status and Department

		EmployeeDepartment employeeDepSal = listDep.stream().max((l1, l2) -> l1.getSalary().compareTo(l2.getSalary()))
				.get();

		System.out.println("Name of employee " + employeeDepSal.getName());

		System.out.println("Status of employee " + employeeDepSal.getStatus());

		System.out.println("Department of employee " + employeeDepSal.getDepartment());

		// Increase salary of employee by 2,000 whose status is active

		List<EmployeeDepartment> mapAct = listDep.stream().filter(l -> l.getStatus().equals("Active")).map(l -> {
			int salary = l.getSalary() + 2000;
			l.setSalary(salary);
			return l;
		}).collect(Collectors.toList());

		System.out.println(mapAct);

	}

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class StudentDetail {
	private Integer id;
	private String name;
	private Integer marks;

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class EmployeeDepartment {
	private String name;
	private String department;
	private Integer salary;
	private String status;
	private String gender;

}
