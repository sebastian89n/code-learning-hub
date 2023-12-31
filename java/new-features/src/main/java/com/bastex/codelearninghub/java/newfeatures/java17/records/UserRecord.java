package com.bastex.codelearninghub.java.newfeatures.java17.records;

/**
 * Internally implements equals/hashcode/toString/getters. Immutable object.
 * Cannot extend or be extended.
 */
public record UserRecord(String firstName, String lastName) {
    // examples of canonical constructor. Must have the same level or higher of visibility as  record
    public UserRecord {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Both firstName and lastName needs to be specified");
        }
    }

    // non-canonical record constructor. Must delegate to canonical constructor.
    public UserRecord(final String firstName, final String middleName, final String lastName) {
        this(firstName + " " + middleName, lastName);
    }
}
