package com.amit.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortingCollectionUsingLamda {

	public static void main(String[] args) {

		// Sorting of List using lamda

		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(4);
		list.add(26);
		list.add(7);

		Collections.sort(list, (i1, i2) -> i1.compareTo(i2));

		System.out.println(list);

		// Sorting of TreeSet using lamda

		Set<String> setTree = new TreeSet<String>((s1, s2) -> s2.compareTo(s1));
		setTree.add("karan");
		setTree.add("ron");
		setTree.add("amit");
		setTree.add("ram");

		System.out.println(setTree);

		// Sorting of TreeMap using lamda via key
		
		Map<Integer, String> map = new TreeMap<>((i1, i2) -> i2.compareTo(i1));

		map.put(67, "cat");
		map.put(11, "run");
		map.put(23, "apple");

		System.out.println(map);

	}

}
