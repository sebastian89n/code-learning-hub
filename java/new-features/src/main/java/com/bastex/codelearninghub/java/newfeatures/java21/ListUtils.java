package com.bastex.codelearninghub.java.newfeatures.java21;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListUtils {

    public static <E extends Comparable<? super E>> ListPosition safeBinarySearch(final List<E> list, final E target) {
        final int position = Collections.binarySearch(list, target);
        if (position >= 0) {
            return new ListPosition.Found(position);
        } else {
            return new ListPosition.NotFound(-position - 1); // decode the candidate position, according to javadoc
        }
    }

    public sealed interface ListPosition permits ListPosition.Found, ListPosition.NotFound {

        record Found(int position) implements ListPosition {
        }

        record NotFound(int candidatePosition) implements ListPosition {
        }

    }
}
