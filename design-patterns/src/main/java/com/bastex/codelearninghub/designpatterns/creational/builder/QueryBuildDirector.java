package com.bastex.codelearninghub.designpatterns.creational.builder;

public class QueryBuildDirector {
    public Query buildQuery(final String from, final String where, final QueryBuilder builder) {
        builder.from(from);
        builder.where(where);
        return builder.getQuery();
    }
}
