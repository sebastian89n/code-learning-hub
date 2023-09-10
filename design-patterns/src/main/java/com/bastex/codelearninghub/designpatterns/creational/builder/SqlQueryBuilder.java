package com.bastex.codelearninghub.designpatterns.creational.builder;

public class SqlQueryBuilder implements QueryBuilder {

    private final SqlQuery query = new SqlQuery();

    @Override
    public void from(final String from) {
        query.setFrom(from);
    }

    @Override
    public void where(final String where) {
        query.setWhere(where);
    }

    @Override
    public Query getQuery() {
        return query;
    }

}
