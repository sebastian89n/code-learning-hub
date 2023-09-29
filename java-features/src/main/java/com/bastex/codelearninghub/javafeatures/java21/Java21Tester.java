package com.bastex.codelearninghub.javafeatures.java21;

import com.bastex.codelearninghub.javafeatures.java21.ListUtils.ListPosition;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java21Tester
{
	public static void testJava21Features()
	{
		List<Person> people = new ArrayList<>();
		people.add(new Person(10, "Andrew", "Rose"));
		people.add(new Person(1, "John", "Smith"));
		people.add(new Person(5, "Mary", "Jane"));
		people.sort(Comparator.naturalOrder());

		updateList(people, new Person(1, "Mark", "Smith"));
		updateList(people, new Person(3, "Dwayne", "Johnson"));

		people.forEach(System.out::println);
	}

	private static void updateList(List<Person> people, Person target1)
	{
		switch (ListUtils.safeBinarySearch(people, target1)) {
			case ListPosition.Found(int position) -> people.set(position, target1);
			case ListPosition.NotFound(int candidatePosition) -> people.add(candidatePosition, target1);
		}
	}

	record Person(int id, String firstName, String lastName) implements Comparable<Person>
	{
		@Override
		public int compareTo(Person o)
		{
			return Integer.compare(id, o.id);
		}
	}
}
