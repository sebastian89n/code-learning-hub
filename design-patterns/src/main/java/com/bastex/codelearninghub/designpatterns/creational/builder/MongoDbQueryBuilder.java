package com.bastex.codelearninghub.designpatterns.creational.builder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MongoDbQueryBuilder implements QueryBuilder {
    private final MongoDbQuery query = new MongoDbQuery();

    public static QueryBuilder newBuilder() {
        return new MongoDbQueryBuilder();
    }

    @Override
    public QueryBuilder from(final String from) {
        query.setFrom(from);
        return this;
    }

    @Override
    public QueryBuilder where(final String where) {
        query.setWhere(where);
        return this;
    }

    @Override
    public Query buildQuery() {
        return query;
    }
}
