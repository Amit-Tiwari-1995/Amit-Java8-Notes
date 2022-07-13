
package com.amit.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	}

}
