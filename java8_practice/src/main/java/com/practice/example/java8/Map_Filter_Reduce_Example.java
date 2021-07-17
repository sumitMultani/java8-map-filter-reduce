package com.practice.example.java8;

import java.util.Arrays;
import java.util.List;

public class Map_Filter_Reduce_Example {

	public static void main(String[] args) {

		// map example
		String[] nameArrays = new String[] { "abc", "karan", "mohit", "vivek" };
		String[] newArray = Arrays.stream(nameArrays).map(name -> name.toUpperCase()).toArray(String[]::new);

		System.out.println(Arrays.toString(newArray));

		// filter example
		String[] array = Arrays.stream(nameArrays).filter(name -> name.length() > 3).map(n -> n.toUpperCase())
				.toArray(String[]::new);

		System.out.println("filter eg : " + Arrays.toString(array));

		// reduce method example
		String combination = Arrays.stream(nameArrays).reduce(" ", (name1, name2) -> name1 + name2);
		System.out.println("reduce eg: " + combination);

		Integer[] numberArray = new Integer[] { 1, 2, 3, 4, 5 };
		Integer reduceSum = Arrays.stream(numberArray).reduce(0, (a, b) -> a + b);
		System.out.println("reduceSum : " + reduceSum);

		Integer sumUsingMethodRef = Arrays.stream(numberArray).reduce(Integer::sum).get();
		System.out.println(sumUsingMethodRef);

		// filter, map and reduce example
		List<Student> studentList = Student.getStudentList();
		Integer sumOfJavaMarks = studentList.stream().filter(s -> s.getSubject().equalsIgnoreCase("java"))
				.map(s -> s.getMarks()).reduce(Integer::sum).get();
		System.out.println("sumOfJavaMarks : " + sumOfJavaMarks);
	}
}
