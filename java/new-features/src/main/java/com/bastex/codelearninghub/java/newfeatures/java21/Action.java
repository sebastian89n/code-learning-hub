package com.bastex.codelearninghub.java.newfeatures.java21;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = Action.Add.class), //
        @JsonSubTypes.Type(value = Action.Remove.class), //
        @JsonSubTypes.Type(value = Action.Set.class, name = "set")})
public sealed interface Action permits Action.Add, Action.Remove, Action.Set {

    @JsonSubTypes({@JsonSubTypes.Type(value = Add.Last.class, name = "addLast"),
            @JsonSubTypes.Type(value = Add.First.class, name = "addFirst"),
            @JsonSubTypes.Type(value = Add.At.class, name = "addAt")})
    sealed interface Add extends Action permits Add.At, Add.First, Add.Last {
        record Last(String value) implements Add {
        }

        record First(String value) implements Add {
        }

        record At(int position, String value) implements Add {
        }
    }

    @JsonSubTypes({@JsonSubTypes.Type(value = Remove.Last.class, name = "removeLast"),
            @JsonSubTypes.Type(value = Remove.First.class, name = "removeFirst"),
            @JsonSubTypes.Type(value = Remove.From.class, name = "removeFrom")})
    sealed interface Remove extends Action permits Remove.First, Remove.From, Remove.Last {
        record Last() implements Remove {
        }

        record First() implements Remove {
        }

        record From(int position) implements Remove {
        }
    }

    record Set(int position, String value) implements Action {
    }

}
