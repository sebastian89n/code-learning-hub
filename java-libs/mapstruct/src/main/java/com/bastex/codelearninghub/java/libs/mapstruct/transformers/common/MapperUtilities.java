package com.bastex.codelearninghub.java.libs.mapstruct.transformers.common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * It can be used to create common methods to transform one object to another, like collections etc.
 */
public final class MapperUtilities {
    /**
     * Forcing Mapstruct to transform List to unmodifiable Set.
     */
    public static <T> Set<T> toSet(final List<T> list) {
        if (list == null) {
            return Collections.emptySet();
        } else {
            return Collections.unmodifiableSet(new LinkedHashSet<>(list));
        }
    }
}
