package com.bastex.codelearninghub.javafeatures.java21;

import com.bastex.codelearninghub.javafeatures.java21.Action.Add;
import com.bastex.codelearninghub.javafeatures.java21.Action.Remove;
import com.bastex.codelearninghub.javafeatures.java21.ListUtils.ListPosition;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java21Tester
{
	@SneakyThrows
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

		var mapper = new ObjectMapper();
		final List<Action> actions = mapper.readValue(readActions(), new TypeReference<>() {});
		List<String> values = executeActions(actions);
		System.out.println("Values after executing the actions:");
		values.forEach(System.out::println);
	}

	private static String readActions()
	{
		// simulate the retrieval of actions as a json string
		return """
				[
				{
					"type": "addLast",
					"value": "last"
				},
				{
					"type": "addFirst",
					"value": "first"
				},
				{
					"type": "addAt",
					"position": 1,
					"value": "at"
				},
				{
					"type": "removeFrom",
					"position": 2
				}
				]""";
	}

	private static List<String> executeActions(List<Action> actions)
	{
		List<String> values = new ArrayList<>();

		actions.forEach(action -> {
			switch (action) {
				case Add add -> handleAdd(add, values);
				case Remove remove -> handleRemove(remove, values);
				case Action.Set(int position, String value) -> values.set(position, value);
			}
		});

		return values;
	}

	private static void handleAdd(Add action, List<String> values)
	{
		switch (action) {
			case Add.Last(String value) -> values.addLast(value); // new method in sequenced collections, equivalent to .add
			case Add.First(String value) -> values.addFirst(value); // sequenced collections to the rescue!
			case Add.At(int position, String value) -> values.add(position, value);
		}
	}

	private static void handleRemove(Remove action, List<String> values)
	{
		switch (action) {
			// with preview features we can replace "ignored" with "_" so that no variable is bound in the
			// first 2 branches of this switch
			case Remove.Last ignored -> values.removeLast(); // sequenced collections to the rescue!
			case Remove.First ignored -> values.removeFirst(); // sequenced collections to the rescue!
			case Remove.From(int position) -> values.remove(position);
		}
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
