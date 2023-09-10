package com.bastex.codelearninghub.designpatterns.creational.builder;

public class MongoDbQueryBuilder implements QueryBuilder {

    private final MongoDbQuery query = new MongoDbQuery();

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
