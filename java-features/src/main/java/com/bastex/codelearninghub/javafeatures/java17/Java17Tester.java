package com.bastex.codelearninghub.javafeatures.java17;

import com.bastex.codelearninghub.javafeatures.java17.records.UserRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java17Tester {
    public static void testJava17Features() {
        // Java 12 - Language-wise Switch Expressions were introduced as a preview feature, we got two G1 improvements(1, 2),
        // and a new experimental low-pause garbage collector – Shenandoah.

        // Java 13 - Switch Expressions were refined, Text Blocks got introduced as a preview feature, and Socket API reimplemented.
        // Additionally, we got Linux/AArch64 support for ZGC.

        // Java 14 had quite a few interesting additions:
        //
        // - Pattern Matching for instanceof (preview)
        // - JFR Event Streaming
        // - Records (preview)
        // - Helpful NullPointerExceptions with extra hints about what caused it
        // - Switch Expressions get promoted to standard
        // - and CMS garbage collector permanently removed

        // Java 15 is already out and has brought a few interesting additions:
        //
        //- Nashorn and biased locking removed
        //- Text Blocks, ZGC and Shenandoah GC promoted to standard features
        //- Sealed(Preview) and Hidden classes added
        //- DatagramSocket API reimplemented
        // As well as second previews of:
        //
        // - Records
        // - Pattern Matching for instanceof
        // - And the second incubator release of Foreign Memory Access API!

        final Level level = Level.One;

        final String message = switch (level) {
            case One -> "Level one selected";
            case Two -> "Lavel two selected";
            case Three -> {
                final String msg = "Level three selected";
                System.out.println("!!! " + msg + " !!!");
                yield msg; // return value from switch block
            }
        };

        final UserRecord userRecord = new UserRecord("firstName", "lastName");
        System.out.println(userRecord.firstName());
        System.out.println(userRecord.lastName());
        System.out.println(userRecord);
    }

    private enum Level {
        One, Two, Three
    }
}
