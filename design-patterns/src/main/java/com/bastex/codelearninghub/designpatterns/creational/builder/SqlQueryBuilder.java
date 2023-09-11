package com.bastex.codelearninghub.designpatterns.creational.builder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SqlQueryBuilder implements QueryBuilder {
    private final SqlQuery query = new SqlQuery();

    public static QueryBuilder newBuilder() {
        return new SqlQueryBuilder();
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
