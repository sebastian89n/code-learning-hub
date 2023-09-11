package com.bastex.codelearninghub.designpatterns.creational.builder;

public interface QueryBuilder {
    QueryBuilder from(String from);

    QueryBuilder where(String where);

    Query buildQuery();

}
