package com.bastex.codelearninghub.java.newfeatures.java21;

import com.bastex.codelearninghub.java.newfeatures.java21.Action.Add;
import com.bastex.codelearninghub.java.newfeatures.java21.Action.Remove;
import com.bastex.codelearninghub.java.newfeatures.java21.ListUtils.ListPosition;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java21Tester {
    @SneakyThrows
    public static void testJava21Features() {
        final List<Person> people = new ArrayList<>();
        people.add(new Person(10, "Andrew", "Rose"));
        people.add(new Person(1, "John", "Smith"));
        people.add(new Person(5, "Mary", "Jane"));
        people.sort(Comparator.naturalOrder());

        updateList(people, new Person(1, "Mark", "Smith"));
        updateList(people, new Person(3, "Dwayne", "Johnson"));

        people.forEach(System.out::println);

        final var mapper = new ObjectMapper();
        final List<Action> actions = mapper.readValue(readActions(), new TypeReference<>() {
        });
        final List<String> values = executeActions(actions);
        System.out.println("Values after executing the actions:");
        values.forEach(System.out::println);
    }

    private static String readActions() {
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
                },
                {
                	"type": "set",
                	"position": 1,
                	"value": "at-updated"
                }
                ]""";
    }

    private static List<String> executeActions(final List<Action> actions) {
        final List<String> values = new ArrayList<>();

        actions.forEach(action -> {
            switch (action) {
                case final Add add -> handleAdd(add, values);
                case final Remove remove -> handleRemove(remove, values);
                case final Action.Set set -> values.set(set.position(), set.value());
            }
        });

        return values;
    }

    private static void handleAdd(final Add action, final List<String> values) {
        switch (action) {
            case final Add.Last last ->
                    values.addLast(last.value()); // new method in sequenced collections, equivalent to .add
            case final Add.First first -> values.addFirst(first.value()); // sequenced collections to the rescue!
            case final Add.At at -> values.add(at.position(), at.value());
        }
    }

    private static void handleRemove(final Remove action, final List<String> values) {
        switch (action) {
            // with preview features we can replace "ignored" with "_" so that no variable is bound in the
            // first 2 branches of this switch
            case final Remove.Last ignored -> values.removeLast(); // sequenced collections to the rescue!
            case final Remove.First ignored -> values.removeFirst(); // sequenced collections to the rescue!
            case final Remove.From from -> values.remove(from.position());
        }
    }

    private static void updateList(final List<Person> people, final Person target1) {
        switch (ListUtils.safeBinarySearch(people, target1)) {
            case final ListPosition.Found found -> people.set(found.position(), target1);
            case final ListPosition.NotFound notFound -> people.add(notFound.candidatePosition(), target1);
        }
    }

    record Person(int id, String firstName, String lastName) implements Comparable<Person> {
        @Override
        public int compareTo(final Person o) {
            return Integer.compare(id, o.id);
        }
    }
}
